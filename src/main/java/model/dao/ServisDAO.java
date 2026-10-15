package dao;

import database.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Komputer;
import model.Laptop;
import model.Pelanggan;
import model.Perangkat;
import model.Servis;

public class ServisDAO {

    private PelangganDAO pelangganDAO = new PelangganDAO();
    private PerangkatDAO perangkatDAO = new PerangkatDAO();

    // READ
    public ArrayList<Servis> tampilkanSemuaServis() {
        ArrayList<Servis> daftarServis = new ArrayList<>();

        String sql = "SELECT id_servis FROM servis";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Servis servis = cariServis(
                        rs.getString("id_servis")
                );
                if (servis != null) {
                    daftarServis.add(servis);
                }
            }

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan servis: "
                    + e.getMessage());
        }
        return daftarServis;
    }

    // SEARCH
    public Servis cariServis(String id) {
        String sql = "SELECT * FROM servis WHERE id_servis = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String idPelanggan = rs.getString("id_pelanggan");
                    String idPerangkat = rs.getString("id_perangkat");

                    Pelanggan pelanggan = pelangganDAO.cariPelanggan(idPelanggan);
                    Perangkat perangkat = perangkatDAO.cariPerangkat(idPerangkat);

                    if (pelanggan != null && perangkat != null) {
                        return new Servis(
                                rs.getString("id_servis"),
                                formatTanggal(rs.getString("tanggal")),
                                kapitalAwal(rs.getString("status")),
                                rs.getInt("biaya"), pelanggan, perangkat);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari servis: "
                    + e.getMessage());
        }
        return null;
    }

    // CREATE
    public boolean tambahServis(Servis servis) {
        String sqlPelanggan = "INSERT INTO pelanggan "
                + "(id_pelanggan, nama, no_telepon, alamat) "
                + "VALUES (?, ?, ?, ?)";
        String sqlPerangkat = "INSERT INTO perangkat "
                + "(id_perangkat, jenis_perangkat, merk, tipe, "
                + "kerusakan, ukuran_layar, jenis_casing) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlServis = "INSERT INTO servis "
                + "(id_servis, tanggal, status, biaya, "
                + "id_pelanggan, id_perangkat) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = KoneksiDatabase.getConnection()) {
            conn.setAutoCommit(false);

            try {
                // Simpan pelanggan
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlPelanggan)) {
                    Pelanggan p = servis.getPelanggan();

                    ps.setString(1, p.getIdPelanggan());
                    ps.setString(2, p.getNama());
                    ps.setString(3, p.getNoTelepon());
                    ps.setString(4, p.getAlamat());
                    ps.executeUpdate();
                }

                // Simpan perangkat
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlPerangkat)) {
                    Perangkat p = servis.getPerangkat();

                    ps.setString(1, p.getIdPerangkat());

                    if (p instanceof Laptop) {
                        Laptop laptop = (Laptop) p;
                        ps.setString(2, "Laptop");
                        ps.setString(3, p.getMerk());
                        ps.setString(4, p.getTipe());
                        ps.setString(5, p.getKerusakan());
                        ps.setString(6, laptop.getUkuranLayar());
                        ps.setNull(7, Types.VARCHAR);
                        
                    } else if (p instanceof Komputer) {
                        Komputer komputer = (Komputer) p;

                        ps.setString(2, "Komputer");
                        ps.setString(3, p.getMerk());
                        ps.setString(4, p.getTipe());
                        ps.setString(5, p.getKerusakan());
                        ps.setNull(6, Types.VARCHAR);
                        ps.setString(7, komputer.getJenisCasing());

                    } else {
                        conn.rollback();
                        return false;
                    }
                    ps.executeUpdate();
                }

                // Simpan servis
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlServis)) {

                    ps.setString(1, servis.getIdServis());
                    ps.setDate(2, java.sql.Date.valueOf(
                            keFormatDatabase(servis.getTanggal())
                    ));

                    ps.setString(3, servis.getStatus());
                    ps.setInt(4, servis.getBiaya());
                    ps.setString(5, servis.getPelanggan().getIdPelanggan());
                    ps.setString(6, servis.getPerangkat().getIdPerangkat());
                    ps.executeUpdate();
                }
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Gagal menambahkan servis: "
                        + e.getMessage());
                return false;
                
            } catch (RuntimeException e) {
                conn.rollback();

                System.out.println("Format tanggal tidak valid: "
                        + e.getMessage());
                return false;

            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengakses database: " + e.getMessage());
            return false;
        }
    }

    // UPDATE
    public boolean ubahServis(Servis servis) {
        String sql = "UPDATE servis SET tanggal = ?, "
                + "status = ?, biaya = ? WHERE id_servis = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(
                    keFormatDatabase(servis.getTanggal())
            ));
            ps.setString(2, servis.getStatus());
            ps.setInt(3, servis.getBiaya());
            ps.setString(4, servis.getIdServis());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Gagal mengubah servis: " + e.getMessage());
            return false;

        } catch (RuntimeException e) {
            System.out.println("Format tanggal tidak valid: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean hapusServis(String id) {
        String sql = "DELETE FROM servis WHERE id_servis = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus servis: " + e.getMessage());
            return false;
        }
    }

    // FORMAT TANGGAL UNTUK DATABASE
    private String keFormatDatabase(String tanggal) {
        LocalDate date = LocalDate.parse(tanggal, DateTimeFormatter.ofPattern("dd-MM-yyyy")
        );
        return date.toString();
    }

    // FORMAT TANGGAL UNTUK TAMPILAN
    private String formatTanggal(String tanggal) {
        if (tanggal == null || tanggal.isEmpty()) {
            return tanggal;
        }
        LocalDate date = LocalDate.parse(tanggal);
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")
        );
    }

    // FORMAT STATUS
    private String kapitalAwal(String teks) {
        if (teks == null || teks.isEmpty()) {
            return teks;
        }
        return teks.substring(0, 1).toUpperCase()
                + teks.substring(1).toLowerCase();
    }
}
