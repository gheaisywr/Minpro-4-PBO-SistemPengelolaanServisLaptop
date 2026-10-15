# Sistem Pengelolaan Servis Laptop

------------------------------------------------------------------------

Program ini merupakan aplikasi berbasis **Command Line Interface (CLI)** yang dibuat menggunakan bahasa pemrograman **Java** dengan menerapkan konsep **Pemrograman Berorientasi Objek (PBO)**. Program ini dibuat untuk memenuhi tugas Praktikum **Mini Project 4 Pemrograman Berorientasi Objek** sebagai pengembangan dari Mini Project 3.

Pada Mini Project 4, program dikembangkan dengan menambahkan database MySQL menggunakan JDBC. Data pelanggan, perangkat, dan servis disimpan di database sehingga dapat diakses kembali meskipun program ditutup.

------------------------------------------------------------------------

## Identitas Mahasiswa

**Nama:** Ghea Aisyah Windraswari\
**NIM:** 2509115022\
**Program Studi:** Sistem Informasi\
**Instansi:** Universitas Mulawarman

------------------------------------------------------------------------

## 1. Studi Kasus

### Sistem Pengelolaan Servis Laptop

Program ini digunakan untuk membantu mencatat dan mengelola data pelanggan, perangkat, serta servis. Program dijalankan melalui terminal. Pengguna dapat menambah, menampilkan, mengubah, menghapus, dan mencari data servis berdasarkan ID servis.

Perangkat yang dapat dipilih terdiri dari dua jenis, yaitu **Laptop** dan **Komputer**. Keduanya merupakan turunan dari class `Perangkat`.

Pada Mini Project 3, data disimpan menggunakan `ArrayList`. Pada Mini Project 4, penyimpanan data dikembangkan menggunakan database MySQL dengan bantuan JDBC dan DAO.

### Fitur Program

1. **Tambah Data Servis** — memasukkan data pelanggan, perangkat, dan servis ke database.
2. **Tampilkan Data Servis** — melihat seluruh data servis yang tersimpan.
3. **Ubah Data Servis** — mengubah tanggal, status, dan biaya servis berdasarkan ID servis.
4. **Hapus Data Servis** — menghapus data servis setelah konfirmasi pengguna.
5. **Cari Data Servis** — mencari data berdasarkan ID servis.
6. **Keluar** — mengakhiri program.

Program juga memiliki validasi input untuk mengurangi kesalahan saat pengguna memasukkan data.

<img width="190" height="140" alt="image" src="https://github.com/user-attachments/assets/806f752d-7d52-4c09-8b11-2bf5b6e6707f" />


------------------------------------------------------------------------

## 2. Struktur Package dan MVC (Nilai Tambah)

Program menggunakan struktur **MVC (Model-View-Controller)** agar bagian data, tampilan, dan proses program dapat dipisahkan. Pada Mini Project 4, ditambahkan package `database` dan `dao` untuk mengelola koneksi serta akses data ke database MySQL.

Struktur package program adalah:

```text
ServisLaptop
│
├── model
│   ├── Pelanggan.java
│   ├── Perangkat.java
│   ├── Laptop.java
│   ├── Komputer.java
│   └── Servis.java
│
├── controller
│   └── ServisController.java
│
├── view
│   └── MenuView.java
│
├── ValidasiInput
│   └── ValidasiInput.java
│
├── interfaces
│   └── InformasiPerangkat.java
│
├── database
│   ├── KoneksiDatabase.java
│   └── TestKoneksi.java
│
├── dao
│   ├── PelangganDAO.java
│   ├── PerangkatDAO.java
│   └── ServisDAO.java
│
└── com.mycompany.servislaptop
    └── ServisLaptop.java
```

### Penjelasan Package

#### `model`

Package `model` berisi class yang merepresentasikan data dalam program:

- `Pelanggan` menyimpan informasi pelanggan.
- `Perangkat` merupakan abstract class untuk data umum perangkat.
- `Laptop` merepresentasikan perangkat laptop.
- `Komputer` merepresentasikan perangkat komputer.
- `Servis` menyimpan informasi servis.

<img width="118" height="86" alt="image" src="https://github.com/user-attachments/assets/ef223002-4c17-4be7-a925-5e0be43b97a7" />


#### `controller`

Package `controller` berisi `ServisController` yang mengatur proses tambah, tampil, ubah, hapus, dan cari data. Controller memanggil DAO untuk mengakses database serta menggunakan validasi input.

<img width="134" height="29" alt="image" src="https://github.com/user-attachments/assets/e865e312-5aa4-4eb3-b792-91eb8358058d" />

#### `ValidasiInput`

Package `ValidasiInput` berisi ValidasiInput menangani validasi teks, angka, nomor telepon, tanggal, biaya servis, dan pilihan menu.

<img width="122" height="29" alt="image" src="https://github.com/user-attachments/assets/a7bcd6a0-afe1-456d-a1d0-0b6b59e8603a" />

#### `interfaces`

Package `interfaces` berisi interface `InformasiPerangkat` dengan method `tampilkanInfo()`.

<img width="144" height="28" alt="image" src="https://github.com/user-attachments/assets/2790bf97-0956-460f-a25c-030237ea59f4" />

#### `view`

Package `view` berisi `MenuView` yang menampilkan menu utama dan menerima pilihan pengguna melalui terminal.

<img width="121" height="28" alt="image" src="https://github.com/user-attachments/assets/88fe3af2-d926-4851-8b95-69e499c8aa18" />

#### `database`

Package `database` berisi `KoneksiDatabase` untuk menghubungkan program Java dengan database MySQL.

<img width="146" height="43" alt="image" src="https://github.com/user-attachments/assets/9ddfe377-4378-45d2-81a8-d7080a01521f" />

#### `dao`

Package `dao` berisi class untuk mengakses database:

- `PelangganDAO` mengelola data pelanggan.
- `PerangkatDAO` mengelola data perangkat.
- `ServisDAO` mengelola data servis.

DAO (*Data Access Object*) memisahkan proses akses database dari controller agar kode lebih terorganisir.

<img width="137" height="55" alt="image" src="https://github.com/user-attachments/assets/d2bc4417-5fdd-4481-84b0-64df63b5e04e" />

#### Main Program

Class `ServisLaptop` merupakan titik awal ketika program dijalankan.

------------------------------------------------------------------------

## 3. Struktur Class

Class yang digunakan dalam program:

- **Perangkat** — superclass yang menyimpan data umum perangkat.
- **Laptop** — subclass dari `Perangkat` untuk laptop.
- **Komputer** — subclass dari `Perangkat` untuk komputer.
- **Pelanggan** — menyimpan informasi pelanggan.
- **Servis** — menyimpan informasi servis.
- **ServisController** — mengatur proses pengelolaan data.
- **ValidasiInput** — menangani validasi input.
- **InformasiPerangkat** — interface informasi perangkat.
- **MenuView** — menampilkan menu utama.
- **KoneksiDatabase** — membuat koneksi ke database.
- **PelangganDAO**, **PerangkatDAO**, dan **ServisDAO** — mengelola akses data.
- **ServisLaptop** — class utama program.

Hubungan inheritance:

```text
                 Perangkat
                Superclass
                /        \
               ▼          ▼
            Laptop     Komputer
            Subclass    Subclass
```

------------------------------------------------------------------------

## 4. Penjelasan Masing-Masing Class

### 4.1 `Perangkat`

Class `Perangkat` merupakan **abstract class** yang menjadi dasar bagi `Laptop` dan `Komputer`. Class ini menyimpan data umum seperti ID perangkat, merek, tipe, dan kerusakan, serta mengimplementasikan interface `InformasiPerangkat`.

```java
package model;

import interfaces.InformasiPerangkat;
public abstract class Perangkat implements InformasiPerangkat {

    private final String idPerangkat;
    private String merk;
    private String tipe;
    private String kerusakan;

    public Perangkat(String idPerangkat, String merk, String tipe, String kerusakan) {
        this.idPerangkat = idPerangkat;
        this.merk = merk;
        this.tipe = tipe;
        this.kerusakan = kerusakan;
    }
    public String getIdPerangkat() {
        return idPerangkat;
    }
    public String getMerk() {
        return merk;
    }
    public void setMerk(String merk) {
        this.merk = merk;
    }
    public String getTipe() {
        return tipe;
    }
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    public String getKerusakan() {
        return kerusakan;
    }
    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }
    @Override
    public abstract void tampilkanInfo();
}
```

### 4.2 `Laptop`

Class `Laptop` merupakan subclass dari `Perangkat` dan memiliki atribut khusus `ukuranLayar`. Constructor menggunakan `super()` untuk memanggil constructor dari `Perangkat`. Class ini melakukan overriding pada method `tampilkanInfo()`.

<img width="639" height="324" alt="image" src="https://github.com/user-attachments/assets/c405db81-da7b-4ab6-a381-aa88d5ce1957" />


### 4.3 `Komputer`

Class `Komputer` merupakan subclass dari `Perangkat` dan memiliki atribut khusus `jenisCasing`. Class ini juga melakukan overriding pada method `tampilkanInfo()`.

<img width="637" height="326" alt="image" src="https://github.com/user-attachments/assets/4c00dd2a-038b-4e0f-abaf-ada823f7da4a" />

### 4.4 `Pelanggan`

Class `Pelanggan` menyimpan `idPelanggan`, `nama`, `noTelepon`, dan `alamat`. Pada MP4, data pelanggan disimpan ke tabel `pelanggan` melalui `PelangganDAO`.

```java
package model;

public class Pelanggan {

    private final String idPelanggan;
    private String nama;
    private String noTelepon;
    private String alamat;

    public Pelanggan(String idPelanggan, String nama, String noTelepon, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }
    public String getIdPelanggan() {
        return idPelanggan;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNoTelepon() {
        return noTelepon;
    }
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
```

### 4.5 `Servis`

Class `Servis` menyimpan `idServis`, `tanggal`, `status`, `biaya`, `pelanggan`, dan `perangkat`. Data servis disimpan ke tabel `servis` dan dihubungkan dengan data pelanggan serta perangkat.

```java
package model;

public class Servis {
    private final String idServis;
    private String tanggal;
    private String status;
    private int biaya;
    private Pelanggan pelanggan;
    private Perangkat perangkat;
    
    public Servis(String idServis, String tanggal,
            String status, int biaya,
            Pelanggan pelanggan, Perangkat perangkat) {

        this.idServis = idServis;
        this.tanggal = tanggal;
        this.status = status;
        this.biaya = biaya;
        this.pelanggan = pelanggan;
        this.perangkat = perangkat;
    }
    public String getIdServis() {
        return idServis;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getStatus() {
        return status;
    }
    public int getBiaya() {
        return biaya;
    }
    public Pelanggan getPelanggan() {
        return pelanggan;
    }
    public Perangkat getPerangkat() {
        return perangkat;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
    
    //OVERLOADING 1
    public void tampilkanInfo(){
        tampilkanInfo(true);
    }
    //OVERLOADING 2
    public void tampilkanInfo(boolean tampilkanPelanggan) {
        System.out.println("================================");
        System.out.println("           DATA SERVIS");
        System.out.println("================================");

        if (tampilkanPelanggan) {
            System.out.println();
            System.out.println("ID Pelanggan : "
                    + pelanggan.getIdPelanggan());
            System.out.println("Nama         : "
                    + pelanggan.getNama());
            System.out.println("No Telepon   : "
                    + pelanggan.getNoTelepon());
            System.out.println("Alamat       : "
                    + pelanggan.getAlamat());
        }
        System.out.println();
        perangkat.tampilkanInfo();
        System.out.println();
        System.out.println("ID Servis    : " + idServis);
        System.out.println("Tanggal      : " + tanggal);
        System.out.println("Status       : " + status);
        System.out.println("Biaya        : Rp" + biaya);
        System.out.println("================================");
    }
}
```

------------------------------------------------------------------------

## 5. Inheritance

Inheritance diterapkan dengan `Perangkat` sebagai superclass, sedangkan `Laptop` dan `Komputer` menjadi subclass. Data umum perangkat didefinisikan pada superclass, sedangkan setiap subclass memiliki atribut tambahan sesuai jenisnya.

------------------------------------------------------------------------

## 6. Polymorphism

Program menerapkan polymorphism melalui **method overriding** dan **method overloading**.

### Method Overriding

Method `tampilkanInfo()` didefinisikan pada `Perangkat`, kemudian diimplementasikan oleh `Laptop` dan `Komputer`. Implementasi yang dijalankan menyesuaikan jenis object.

<img width="392" height="127" alt="image" src="https://github.com/user-attachments/assets/1b5c560d-4118-46e4-a813-8c463dabfb1a" />
<img width="377" height="124" alt="image" src="https://github.com/user-attachments/assets/461cc812-f0db-4d0c-ad81-a16f5323f832" />


### Method Overloading

Class `Servis` memiliki dua method `tampilkanInfo()` dengan parameter berbeda. Perbedaan parameter tersebut merupakan penerapan method overloading.

<img width="389" height="368" alt="Screenshot 2026-10-15 202227" src="https://github.com/user-attachments/assets/008f6181-4f9f-4207-8eb3-b087deba3949" />
<img width="186" height="59" alt="Screenshot 2026-10-15 202210" src="https://github.com/user-attachments/assets/5c2980d0-fbd0-47f3-a3e6-8487015e2d35" />


------------------------------------------------------------------------

## 7. Abstraction

Abstraction diterapkan menggunakan abstract class `Perangkat` dan abstract method `tampilkanInfo()`. Method tersebut wajib diimplementasikan oleh subclass.

------------------------------------------------------------------------

## 8. Interface

Interface `InformasiPerangkat` memiliki method `tampilkanInfo()` dan diimplementasikan oleh abstract class `Perangkat`. Class turunannya memberikan implementasi sesuai jenis perangkat.

------------------------------------------------------------------------

## 9. Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut. Data diakses atau diubah melalui method yang tersedia, seperti getter dan setter apabila diperlukan.

------------------------------------------------------------------------

## 10. Constructor dan Object

Constructor memberikan nilai awal ketika object dibuat. Program menggunakan object `Pelanggan`, `Laptop` atau `Komputer`, serta `Servis`. Pada MP4, data yang diperlukan kemudian diproses melalui controller dan DAO untuk disimpan atau diambil dari database.

------------------------------------------------------------------------

## 11. Database MySQL

Program menggunakan database MySQL bernama **`db_servis_laptop`**. Database dikelola melalui Laragon dan digunakan untuk menyimpan data pelanggan, perangkat, dan servis.

### 11.1 Tabel `pelanggan`

| Kolom | Keterangan |
|---|---|
| `id_pelanggan` | ID unik pelanggan |
| `nama` | Nama pelanggan |
| `no_telepon` | Nomor telepon pelanggan |
| `alamat` | Alamat pelanggan |

### 11.2 Tabel `perangkat`

| Kolom | Keterangan |
|---|---|
| `id_perangkat` | ID unik perangkat |
| `jenis_perangkat` | Jenis perangkat |
| `merk` | Merek perangkat |
| `tipe` | Tipe perangkat |
| `kerusakan` | Informasi kerusakan |
| `ukuran_layar` | Ukuran layar laptop |
| `jenis_casing` | Jenis casing komputer |

### 11.3 Tabel `servis`

| Kolom | Keterangan |
|---|---|
| `id_servis` | ID unik servis |
| `tanggal` | Tanggal servis |
| `status` | Status pengerjaan |
| `biaya` | Biaya servis |
| `id_pelanggan` | ID pelanggan terkait |
| `id_perangkat` | ID perangkat terkait |

Status servis yang digunakan adalah `Menunggu`, `Diproses`, dan `Selesai`.

<img width="245" height="28" alt="Screenshot 2026-10-10 225403" src="https://github.com/user-attachments/assets/5619ca7a-9934-4cd7-aa21-dbae05135ca5" />

<img width="421" height="161" alt="Screenshot 2026-10-10 225437" src="https://github.com/user-attachments/assets/44c7861b-8662-4662-87d7-a1a2fea1cda4" />

<img width="463" height="63" alt="Screenshot 2026-10-10 225902" src="https://github.com/user-attachments/assets/0cac2d26-dd3f-4f3b-9c59-b067d7525193" />

<img width="724" height="59" alt="Screenshot 2026-10-10 230540" src="https://github.com/user-attachments/assets/dec295f0-bb6f-4610-8bc5-fb850acbd42e" />

<img width="590" height="63" alt="Screenshot 2026-10-10 231052" src="https://github.com/user-attachments/assets/f53489aa-1c4d-4ede-94a5-4f0d6f390e52" />


### 11.4 Relasi Antar Tabel

Tabel `servis` terhubung dengan tabel `pelanggan` melalui `id_pelanggan` dan tabel `perangkat` melalui `id_perangkat`.

```text
pelanggan
    |
    | id_pelanggan
    ▼
  servis
    ▲
    | id_perangkat
    |
 perangkat
```

<img width="173" height="26" alt="Screenshot 2026-10-10 225412" src="https://github.com/user-attachments/assets/3dff77ee-4639-49b4-b5f6-9970b9c5351d" />

<img width="269" height="86" alt="Screenshot 2026-10-10 225420" src="https://github.com/user-attachments/assets/739e5f84-5faa-44af-8742-2c6e121af786" />

<img width="275" height="124" alt="Screenshot 2026-10-10 225428" src="https://github.com/user-attachments/assets/655cd7ad-8fb3-4d19-b87a-e26fd8b96b59" />


### 11.5 Dummy Data

Dummy data dimasukkan melalui file SQL, bukan ditulis langsung di kode Java. Data awal mencakup pelanggan, perangkat, dan servis yang saling berhubungan untuk membantu pengujian program.

<img width="365" height="291" alt="Screenshot 2026-10-10 233336" src="https://github.com/user-attachments/assets/2411835a-1b2a-4f16-969b-bd6f848e3501" />

<img width="406" height="176" alt="Screenshot 2026-10-10 233503" src="https://github.com/user-attachments/assets/25ce7f79-9adf-47d0-9475-228fce8c852d" />

<img width="291" height="180" alt="Screenshot 2026-10-10 233846" src="https://github.com/user-attachments/assets/169c776d-a1bb-4a6d-8c68-048f5129a2c1" />

<img width="169" height="229" alt="Screenshot 2026-10-10 234039" src="https://github.com/user-attachments/assets/5385c73b-f7f7-4cf6-a326-ec8c7e672d28" />


------------------------------------------------------------------------

## 12. Implementasi JDBC dan DAO

### 12.1 JDBC

JDBC (*Java Database Connectivity*) digunakan untuk menghubungkan program Java dengan database MySQL serta menjalankan perintah SQL.

### 12.2 Koneksi Database

Class `KoneksiDatabase` menggunakan `DriverManager.getConnection()` untuk membuka koneksi ke database `db_servis_laptop`. Class DAO menggunakan koneksi tersebut ketika menjalankan query.

```java
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {

    private static final String URL =
            "jdbc:mysql://localhost:3306/db_servis_laptop";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection(
                URL, USER, PASSWORD
        );
    }
}
```

### 12.3 PreparedStatement

`PreparedStatement` digunakan untuk menjalankan perintah SQL dengan parameter. Parameter ditandai dengan tanda tanya (`?`) dan diisi menggunakan method seperti `setString()` atau `setInt()`.

Penggunaan `PreparedStatement` membantu memisahkan query dari nilai input dan mengurangi risiko SQL injection.

```java
try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
```

### 12.4 Data Access Object (DAO)

DAO memisahkan proses akses database dari bagian program lainnya. `PelangganDAO` mengelola pelanggan, `PerangkatDAO` mengelola perangkat, dan `ServisDAO` mengelola servis.

### 12.5 ResultSet

`ResultSet` digunakan untuk membaca hasil query dari database, misalnya saat program menampilkan data servis.

### 12.6 Try-with-resources

Program menggunakan try-with-resources untuk membantu menutup `Connection`, `PreparedStatement`, dan `ResultSet` setelah selesai digunakan.

### 12.7 Transaksi Database

Pada proses penambahan data servis, `ServisDAO` menggunakan transaksi database. Jika proses berhasil, perubahan disimpan menggunakan `commit()`. Jika terjadi kesalahan, perubahan dibatalkan menggunakan `rollback()`.

------------------------------------------------------------------------

## 13. Proses Tambah Data Servis

Pengguna memilih menu **1. Tambah Data Servis**, lalu memasukkan data pelanggan, memilih jenis perangkat, memasukkan data perangkat, dan mengisi informasi servis.

Status servis yang tersedia:

```text
1. Menunggu
2. Diproses
3. Selesai
```

Setelah input divalidasi, controller memanggil DAO untuk menyimpan data ke database. `ServisDAO` menangani penambahan data yang saling berhubungan menggunakan transaksi database.

[TAMBAHKAN GAMBAR DI SINI: Screenshot proses tambah data servis yang berhasil]

------------------------------------------------------------------------

## 14. Proses Menampilkan Data

Menu **2. Tampilkan Data Servis** digunakan untuk menampilkan data yang tersimpan di database. Program mengambil data melalui `ServisDAO`, membaca hasil query menggunakan `ResultSet`, lalu menampilkan informasi melalui terminal.

Informasi yang ditampilkan meliputi data pelanggan, perangkat, dan servis.

[TAMBAHKAN GAMBAR DI SINI: Screenshot hasil tampil data servis]

------------------------------------------------------------------------

## 15. Proses Mengubah Data

Menu **3. Ubah Data Servis** digunakan untuk mengubah tanggal, status, dan biaya servis berdasarkan ID servis. Setelah input divalidasi, `ServisDAO` menjalankan perintah SQL untuk memperbarui data pada database.

Jika ID tidak ditemukan, program menampilkan pesan bahwa data tidak tersedia.

[TAMBAHKAN GAMBAR DI SINI: Screenshot proses ubah data dan hasil perubahan]

------------------------------------------------------------------------

## 16. Proses Menghapus Data

Menu **4. Hapus Data Servis** digunakan untuk menghapus data servis berdasarkan ID servis. Sebelum penghapusan, program meminta konfirmasi:

```text
Yakin ingin menghapus? (y/n):
```

Jika pengguna memilih `y`, DAO menghapus data dari database. Jika memilih `n`, penghapusan dibatalkan.

[TAMBAHKAN GAMBAR DI SINI: Screenshot konfirmasi dan hasil penghapusan data servis]

------------------------------------------------------------------------

## 17. Proses Pencarian Data

Menu **5. Cari Data Servis** digunakan untuk mencari data berdasarkan ID servis. DAO menjalankan query pencarian pada database. Jika data ditemukan, informasi servis ditampilkan.

Jika data tidak ditemukan, program menampilkan:

```text
Data servis tidak ditemukan.
```

[TAMBAHKAN GAMBAR DI SINI: Screenshot hasil pencarian data servis]

------------------------------------------------------------------------

## 18. Validasi Input

Program menerapkan validasi untuk mengurangi kesalahan input.

### Validasi Teks

Input teks diperiksa agar tidak kosong dan sesuai kebutuhan program.

### Validasi Nomor Telepon

Nomor telepon diperiksa agar hanya berisi angka dan memiliki panjang sesuai ketentuan program.

### Validasi Jenis Perangkat

Jenis perangkat hanya dapat dipilih melalui pilihan laptop atau komputer.

### Validasi Status

Status servis hanya dapat dipilih dari `Menunggu`, `Diproses`, atau `Selesai`.

### Validasi Tanggal

Format tanggal yang digunakan pada input dan tampilan adalah `DD-MM-YYYY`. Database MySQL menyimpan tanggal dengan tipe `DATE`, sehingga program melakukan konversi format tanggal.

### Validasi Biaya

Biaya servis harus berupa angka dan memenuhi batas minimum yang ditetapkan program.

### Validasi ID

Program memeriksa ID agar tidak terjadi penggunaan ID yang sama pada data baru.

[TAMBAHKAN GAMBAR DI SINI: Screenshot validasi input pada terminal]

------------------------------------------------------------------------

## 19. Perulangan Program

Program menggunakan perulangan pada menu utama agar pengguna dapat menjalankan beberapa fitur tanpa menjalankan ulang program setiap kali selesai melakukan satu proses. Menu terus ditampilkan sampai pengguna memilih **6. Keluar**.

Perulangan juga digunakan dalam proses validasi agar pengguna dapat memasukkan kembali data jika input tidak sesuai.

------------------------------------------------------------------------

## 20. Percabangan `if-else` dan `switch-case`

Program menggunakan `switch-case` untuk memproses pilihan menu. Setiap pilihan menjalankan fitur yang sesuai.

`if-else` digunakan untuk menentukan kondisi tertentu, misalnya saat pengguna memilih jenis perangkat laptop atau komputer dan saat program memeriksa hasil pencarian data.

------------------------------------------------------------------------

## 21. Dokumentasi Output Program

### 21.1 Koneksi Database

Pengujian dilakukan untuk memastikan program dapat terhubung ke database MySQL.

[TAMBAHKAN GAMBAR DI SINI: Screenshot program yang berhasil mengakses database]

### 21.2 Tambah Data Servis

Data pelanggan, perangkat, dan servis dimasukkan melalui menu tambah data lalu disimpan ke database.

[TAMBAHKAN GAMBAR DI SINI: Screenshot proses tambah data dan pesan keberhasilan]

### 21.3 Tampilkan Data Servis

Program mengambil data dari database dan menampilkan hasilnya melalui terminal.

[TAMBAHKAN GAMBAR DI SINI: Screenshot hasil tampil data servis]

### 21.4 Ubah Data Servis

Pengguna mengubah tanggal, status, atau biaya servis berdasarkan ID servis.

[TAMBAHKAN GAMBAR DI SINI: Screenshot hasil perubahan data servis]

### 21.5 Cari Data Servis

Program mencari data berdasarkan ID servis dan menampilkan informasi jika ditemukan.

[TAMBAHKAN GAMBAR DI SINI: Screenshot hasil pencarian data servis]

### 21.6 Hapus Data Servis

Program meminta konfirmasi sebelum menghapus data servis dari database.

[TAMBAHKAN GAMBAR DI SINI: Screenshot konfirmasi dan hasil penghapusan data servis]

------------------------------------------------------------------------

## 22. Penerapan Konsep PBO

### 1. Class

Program memiliki class seperti `Pelanggan`, `Perangkat`, `Laptop`, `Komputer`, `Servis`, `ServisController`, dan `MenuView`.

### 2. Object

Object dibuat menggunakan keyword `new` untuk merepresentasikan pelanggan, perangkat, dan servis.

### 3. Constructor

Constructor memberikan nilai awal ketika object dibuat.

### 4. Encapsulation

Atribut dibuat menggunakan `private` dan diakses melalui method yang tersedia.

### 5. Access Modifier

Program menggunakan `private` dan `public` untuk mengatur hak akses.

### 6. Inheritance

Inheritance diterapkan melalui `Perangkat` sebagai superclass serta `Laptop` dan `Komputer` sebagai subclass.

### 7. Polymorphism

Polymorphism diterapkan melalui method overriding pada `Laptop` dan `Komputer`, serta method overloading pada `Servis`.

### 8. Abstraction

Abstraction diterapkan melalui abstract class `Perangkat` dan abstract method `tampilkanInfo()`.

### 9. Interface

Interface `InformasiPerangkat` menjadi aturan method yang diimplementasikan oleh `Perangkat`.

### 10. Validasi Input

Validasi digunakan untuk memeriksa input sebelum data diproses atau disimpan.

------------------------------------------------------------------------

## 23. Alur Program

```text
                    MULAI
                      |
                      v
                Tampilkan Menu
                      |
                      v
              Pilih Menu 1 - 6
                      |
                      v
                  MenuView
                      |
                      v
              ServisController
                      |
                      v
                     DAO
                      |
                      v
                 JDBC / SQL
                      |
                      v
                Database MySQL
                      |
                      v
                Tampilkan Hasil
                      |
                      v
                Kembali ke Menu
                      |
                      v
                Pilih Menu 6
                      |
                      v
                   SELESAI
```

Program akan terus menampilkan menu sampai pengguna memilih **6. Keluar**.

------------------------------------------------------------------------

## 24. Teknologi yang Digunakan

- **Bahasa Pemrograman:** Java
- **IDE:** NetBeans
- **Database:** MySQL
- **Pengelolaan Database:** Laragon
- **Koneksi Database:** JDBC
- **Pengolahan Query:** `PreparedStatement`
- **Pengelolaan Akses Data:** DAO
- **Arsitektur Program:** MVC
- **Antarmuka:** Command Line Interface (CLI)

------------------------------------------------------------------------

## 25. Cara Menjalankan Program

1. Pastikan Java dan NetBeans sudah terpasang.
2. Jalankan Laragon dan pastikan layanan MySQL aktif.
3. Buat database `db_servis_laptop`.
4. Jalankan file SQL yang berisi struktur tabel dan dummy data.
5. Pastikan konfigurasi koneksi pada `KoneksiDatabase.java` sesuai dengan pengaturan MySQL.
6. Buka proyek Mini Project 4 melalui NetBeans.
7. Pastikan dependency JDBC MySQL tersedia pada proyek.
8. Jalankan class utama `ServisLaptop`.
9. Gunakan menu yang tersedia untuk mengelola data servis.

Nama database, port, username, dan password pada konfigurasi koneksi harus sesuai dengan pengaturan MySQL yang digunakan.

------------------------------------------------------------------------

## 26. Kesimpulan

**Sistem Pengelolaan Servis Laptop** dapat digunakan untuk membantu proses pencatatan dan pengelolaan data pelanggan, perangkat, serta servis melalui terminal.

Program menyediakan fitur tambah, tampil, ubah, hapus, dan cari data servis. Pada Mini Project 4, data disimpan ke database MySQL sehingga dapat diakses kembali ketika program dijalankan.

Program tetap menerapkan konsep PBO seperti class, object, constructor, encapsulation, inheritance, polymorphism, abstraction, dan interface. Struktur MVC memisahkan bagian model, controller, dan view, sedangkan JDBC dan DAO digunakan untuk mengelola akses database.

Dengan pengembangan tersebut, program menjadi lebih terorganisir dan dapat mengelola data servis menggunakan database MySQL.
