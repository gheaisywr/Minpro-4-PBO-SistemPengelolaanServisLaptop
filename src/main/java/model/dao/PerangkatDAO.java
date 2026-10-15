package dao;

import database.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import model.Komputer;
import model.Laptop;
import model.Perangkat;

public class PerangkatDAO {

    // READ
    public void tampilkanSemuaPerangkat() {
        String sql = "SELECT * FROM perangkat";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID Perangkat: "
                        + rs.getString("id_perangkat"));
                System.out.println("Jenis Perangkat: "
                        + rs.getString("jenis_perangkat"));
                System.out.println("Merk: "
                        + rs.getString("merk"));
                System.out.println("Tipe: "
                        + rs.getString("tipe"));
                System.out.println("Kerusakan: "
                        + rs.getString("kerusakan"));

                if ("Laptop".equalsIgnoreCase(
                        rs.getString("jenis_perangkat"))) {
                    System.out.println("Ukuran Layar: "
                            + rs.getString("ukuran_layar"));
                } else {
                    System.out.println("Jenis Casing: "
                            + rs.getString("jenis_casing"));
                }
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menampilkan perangkat: "
                    + e.getMessage());
        }
    }

    // CREATE
    public boolean tambahPerangkat(
            String id, String jenis, String merk,
            String tipe, String kerusakan,
            String ukuranLayar, String jenisCasing) {
            String sql = "INSERT INTO perangkat "
                + "(id_perangkat, jenis_perangkat, merk, tipe, "
                + "kerusakan, ukuran_layar, jenis_casing) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, jenis);
            ps.setString(3, merk);
            ps.setString(4, tipe);
            ps.setString(5, kerusakan);

            if (ukuranLayar == null
                    || ukuranLayar.trim().isEmpty()) {
                ps.setNull(6, Types.VARCHAR);
            } else {
                ps.setString(6, ukuranLayar);
            }
            if (jenisCasing == null
                    || jenisCasing.trim().isEmpty()) {
                ps.setNull(7, Types.VARCHAR);
            } else {
                ps.setString(7, jenisCasing);
            }
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan perangkat: " + e.getMessage());
            return false;
        }
    }

    // SEARCH
    public Perangkat cariPerangkat(String id) {
        String sql = "SELECT * FROM perangkat "
                + "WHERE id_perangkat = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String jenis = rs.getString("jenis_perangkat");
                    String idPerangkat = rs.getString("id_perangkat");
                    String merk = rs.getString("merk");
                    String tipe = rs.getString("tipe");
                    String kerusakan = rs.getString("kerusakan");

                    if ("Laptop".equalsIgnoreCase(jenis)) {
                        return new Laptop(idPerangkat, merk, tipe, kerusakan, rs.getString("ukuran_layar")
                        );
                    } else if ("Komputer".equalsIgnoreCase(jenis)) {
                        return new Komputer(idPerangkat, merk, tipe, kerusakan, rs.getString("jenis_casing")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari perangkat: "
                    + e.getMessage());
        }
        return null;
    }
}
