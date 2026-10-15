package dao;

import database.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pelanggan;

public class PelangganDAO {

    // READ
    public void tampilkanSemuaPelanggan() {
        String sql = "SELECT * FROM pelanggan";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID Pelanggan: "
                        + rs.getString("id_pelanggan"));
                System.out.println("Nama: "
                        + rs.getString("nama"));
                System.out.println("No. Telepon: "
                        + rs.getString("no_telepon"));
                System.out.println("Alamat: "
                        + rs.getString("alamat"));
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan pelanggan: "
                    + e.getMessage());
        }
    }

    // CREATE
    public boolean tambahPelanggan(
            String id, String nama,
            String noTelepon, String alamat) {

        String sql = "INSERT INTO pelanggan "
                + "(id_pelanggan, nama, no_telepon, alamat) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2, nama);
            ps.setString(3, noTelepon);
            ps.setString(4, alamat);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan pelanggan: " + e.getMessage());
            return false;
        }
    }

    // SEARCH
    public Pelanggan cariPelanggan(String id) {
        String sql = "SELECT * FROM pelanggan " + "WHERE id_pelanggan = ?";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pelanggan(
                            rs.getString("id_pelanggan"),
                            rs.getString("nama"),
                            rs.getString("no_telepon"),
                            rs.getString("alamat")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari pelanggan: " + e.getMessage());
        }
        return null;
    }
}
