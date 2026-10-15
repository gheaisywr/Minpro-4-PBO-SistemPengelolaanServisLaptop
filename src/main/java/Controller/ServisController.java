package controller;

import java.util.ArrayList;
import java.util.Scanner;
import dao.PelangganDAO;
import dao.PerangkatDAO;
import dao.ServisDAO;
import model.Komputer;
import model.Laptop;
import model.Pelanggan;
import model.Perangkat;
import model.Servis;
import validasiinput.ValidasiInput;

public class ServisController {
    private Scanner input;
    private ValidasiInput validasi;
    private PelangganDAO pelangganDAO;
    private PerangkatDAO perangkatDAO;
    private ServisDAO servisDAO;

    public ServisController(Scanner input) {
        this.input = input;
        this.validasi = new ValidasiInput(input);
        this.pelangganDAO = new PelangganDAO();
        this.perangkatDAO = new PerangkatDAO();
        this.servisDAO = new ServisDAO();
    }

    // CREATE
    public void tambahServis() {
        System.out.println("\n=== TAMBAH DATA SERVIS ===");
        System.out.println("\n--- DATA PELANGGAN ---");

        String idPelanggan = validasi.inputTeks("ID Pelanggan: ");

        if (pelangganDAO.cariPelanggan(idPelanggan) != null) {
            System.out.println("ID Pelanggan sudah digunakan!");
            return;
        }

        String nama = validasi.inputTeks("Nama: ");
        String noTelepon = validasi.inputNomorTelepon("No Telepon: ");
        String alamat = validasi.inputTeks("Alamat: ");
        System.out.println("\n--- DATA PERANGKAT ---");

        int pilihanJenis = pilihJenisPerangkat();
        String idPerangkat = validasi.inputTeks("ID Perangkat: ");

        if (perangkatDAO.cariPerangkat(idPerangkat) != null) {
            System.out.println("ID Perangkat sudah digunakan!");
            return;
        }
        String merk = validasi.inputTeks("Merk: ");
        String tipe = validasi.inputTeks("Tipe: ");
        String kerusakan = validasi.inputTeks("Kerusakan: ");

        Perangkat perangkat;

        if (pilihanJenis == 1) {
            String ukuranLayar =
                    validasi.inputTeks("Ukuran Layar (Inci): ");
            perangkat = new Laptop(
                    idPerangkat, merk, tipe,
                    kerusakan, ukuranLayar
            );
        } else {
            String jenisCasing =
                    validasi.inputTeks("Jenis Casing: ");
            perangkat = new Komputer(
                    idPerangkat, merk, tipe,
                    kerusakan, jenisCasing
            );
        }
        System.out.println("\n--- DATA SERVIS ---");
        String idServis = validasi.inputTeks("ID Servis: ");

        if (servisDAO.cariServis(idServis) != null) {
            System.out.println("ID Servis sudah digunakan!");
            return;
        }
        String tanggal =
                validasi.inputTanggal("Tanggal (DD-MM-YYYY): ");
        String status = pilihStatus();
        int biaya = validasi.inputBiaya("Biaya: Rp");

        Pelanggan pelanggan = new Pelanggan(
                idPelanggan, nama, noTelepon, alamat
        );

        Servis servis = new Servis(
                idServis, tanggal, status, biaya,
                pelanggan, perangkat
        );

        if (servisDAO.tambahServis(servis)) {
            System.out.println("Data servis berhasil ditambahkan.");
        } else {
            System.out.println("Data servis gagal ditambahkan.");
        }
    }

    // READ
    public void tampilkanServis() {
        System.out.println("\n=== DAFTAR DATA SERVIS ===");
        ArrayList<Servis> daftarServis = servisDAO.tampilkanSemuaServis();

        if (daftarServis.isEmpty()) {
            System.out.println("Belum ada data servis.");
            return;
        }
        for (Servis servis : daftarServis) {
            servis.tampilkanInfo();
            System.out.println();
        }
    }

    // UPDATE
    public void ubahServis() {
        System.out.println("\n=== UBAH DATA SERVIS ===");

        String id = validasi.inputTeks("Masukkan ID Servis: ");
        Servis servis = servisDAO.cariServis(id);

        if (servis == null) {
            System.out.println("Data servis tidak ditemukan.");
            return;
        }
        System.out.println("\nData ditemukan:");
        servis.tampilkanInfo();
        System.out.println("\n--- UBAH DATA SERVIS ---");

        String tanggalBaru =
                validasi.inputTanggal("Tanggal baru (DD-MM-YYYY): ");
        String statusBaru = pilihStatus();
        int biayaBaru = validasi.inputBiaya("Biaya baru: Rp");

        servis.setTanggal(tanggalBaru);
        servis.setStatus(statusBaru);
        servis.setBiaya(biayaBaru);

        if (servisDAO.ubahServis(servis)) {
            System.out.println("Data servis berhasil diubah.");
        } else {
            System.out.println("Data servis gagal diubah.");
        }
    }

    // DELETE
    public void hapusServis() {
        System.out.println("\n=== HAPUS DATA SERVIS ===");

        String id = validasi.inputTeks("Masukkan ID Servis: ");
        Servis servis = servisDAO.cariServis(id);

        if (servis == null) {
            System.out.println("Data servis tidak ditemukan.");
            return;
        }

        System.out.println("\nData yang akan dihapus:");
        servis.tampilkanInfo();

        System.out.print("\nYakin ingin menghapus? (y/n): ");
        String pilihan = input.nextLine().trim();

        while (!pilihan.equalsIgnoreCase("y")
                && !pilihan.equalsIgnoreCase("n")) {
            System.out.println("Masukkan hanya y atau n!");
            System.out.print("Yakin ingin menghapus? (y/n): ");
            pilihan = input.nextLine().trim();
        }

        if (pilihan.equalsIgnoreCase("y")) {
            if (servisDAO.hapusServis(id)) {
                System.out.println("Data servis berhasil dihapus.");
            } else {
                System.out.println("Data servis gagal dihapus.");
            }
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    // SEARCH
    public void cariData() {
        System.out.println("\n=== CARI DATA SERVIS ===");

        String id = validasi.inputTeks("Masukkan ID Servis: ");
        Servis servis = servisDAO.cariServis(id);

        if (servis == null) {
            System.out.println("Data servis tidak ditemukan.");
        } else {
            System.out.println("\nData ditemukan:");
            servis.tampilkanInfo();
        }
    }

    // PILIH JENIS PERANGKAT
    private int pilihJenisPerangkat() {
        System.out.println("1. Laptop");
        System.out.println("2. Komputer");

        while (true) {
            int pilihan =
                    validasi.inputAngka("Pilih jenis perangkat: ");

            if (pilihan == 1 || pilihan == 2) {
                return pilihan;
            } else {
                System.out.println("Pilihan hanya 1 atau 2!");
            }
        }
    }

    // PILIH STATUS
    private String pilihStatus() {
        System.out.println("\nPilih Status Proses:");
        System.out.println("1. Menunggu");
        System.out.println("2. Diproses");
        System.out.println("3. Selesai");

        while (true) {
            int pilihan = validasi.inputAngka("Pilih status: ");

            if (pilihan == 1) {
                return "Menunggu";
            } else if (pilihan == 2) {
                return "Diproses";
            } else if (pilihan == 3) {
                return "Selesai";
            } else {
                System.out.println("Pilihan hanya 1, 2, atau 3!");
            }
        }
    }
}
