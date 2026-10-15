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

Program yang dibuat adalah Sistem Pengelolaan Servis Laptop. Program ini digunakan untuk membantu mencatat dan mengelola data pelanggan, data perangkat, serta data servis dalam satu sistem sederhana.

Program dijalankan melalui Command Line Interface (CLI) atau terminal. Melalui menu yang tersedia, pengguna dapat menambahkan data servis, melihat data yang sudah tersimpan, mengubah data servis, menghapus data servis, dan mencari data berdasarkan ID servis.

Pada pengembangan terbaru, perangkat yang dapat dipilih terdiri dari dua jenis, yaitu Laptop dan Komputer. Keduanya merupakan turunan dari class Perangkat.

Dalam pembuatannya, program menggunakan konsep Pemrograman Berorientasi Objek (PBO). Data dan proses program dibagi ke dalam beberapa class agar setiap class memiliki tugas yang lebih jelas.

Pada Mini Project 4, penyimpanan data dikembangkan menggunakan database MySQL melalui JDBC (Java Database Connectivity) dan pola DAO (Data Access Object). Dengan demikian, data pelanggan, perangkat, dan servis dapat disimpan secara permanen di database serta diakses kembali ketika program dijalankan ulang.

### Fitur Program

Program ini memiliki beberapa fitur utama, yaitu:

1.  **Tambah Data Servis**\
    Digunakan untuk memasukkan data pelanggan, data perangkat, dan
    informasi servis.

2.  **Tampilkan Data Servis**\
    Digunakan untuk melihat seluruh data servis yang sudah tersimpan.

3.  **Ubah Data Servis**\
    Digunakan untuk mengubah tanggal, status, dan biaya servis
    berdasarkan ID servis.

4.  **Hapus Data Servis**\
    Digunakan untuk menghapus data servis. Sebelum data dihapus,
    pengguna akan diminta melakukan konfirmasi.

5.  **Cari Data Servis**\
    Digunakan untuk mencari data servis berdasarkan ID servis.

6.  **Keluar**\
    Digunakan untuk mengakhiri penggunaan program.

Selain fitur tersebut, program juga memiliki validasi input untuk
mengurangi kesalahan ketika pengguna memasukkan data.

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

Class `ServisLaptop` digunakan sebagai titik awal ketika
program dijalankan. Class ini membuat object `MenuView` kemudian
menjalankan program.

<img width="154" height="27" alt="image" src="https://github.com/user-attachments/assets/9a9feb7e-6e22-4afb-9a71-e2f9d49eabb5" />

Dengan pembagian tersebut, setiap bagian program memiliki tugas yang
lebih jelas dan program menjadi lebih terorganisir.


------------------------------------------------------------------------

## 3. Struktur Class

### Class yang digunakan dalam program:

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

### Interface yang Digunakan dalam program:

-   **InformasiPerangkat** → interface untuk informasi perangkat.

Hubungan inheritance pada program dapat digambarkan sebagai berikut:

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

Atribut yang terdapat pada class `Perangkat` yaitu:

-   `idPerangkat`
-   `merk`
-   `tipe`
-   `kerusakan`

Contoh:

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

Class `Laptop` merupakan subclass dari `Perangkat`.

``` java
public class Laptop extends Perangkat {
```

Class `Laptop` memiliki atribut khusus `ukuranLayar` yang membedakannya
dari jenis perangkat lainnya.

Constructor `Laptop` menggunakan `super()` untuk memanggil constructor
dari class `Perangkat`.

``` java
super(idPerangkat, merk, tipe, kerusakan);
```

Class `Laptop` juga melakukan **method overriding** pada method
`tampilkanInfo()`.

``` java
@Override
public void tampilkanInfo() {
    System.out.println("Jenis        : Laptop");
    System.out.println("ID Laptop    : " + getIdPerangkat());
    System.out.println("Merk         : " + getMerk());
    System.out.println("Tipe         : " + getTipe());
    System.out.println("Kerusakan    : " + getKerusakan());
    System.out.println("Ukuran Layar (Inci) : " + ukuranLayar + " Inci");
}
```

<img width="639" height="324" alt="image" src="https://github.com/user-attachments/assets/c405db81-da7b-4ab6-a381-aa88d5ce1957" />


### 4.3 `Komputer`

Class `Komputer` merupakan subclass dari `Perangkat` dan memiliki atribut khusus `jenisCasing`. Class ini juga melakukan overriding pada method `tampilkanInfo()`.

``` java
public class Komputer extends Perangkat {
```

Class `Komputer` memiliki atribut khusus `jenisCasing`.

Class ini juga melakukan overriding terhadap method `tampilkanInfo()`.

``` java
@Override
public void tampilkanInfo() {
    System.out.println("Jenis        : Komputer");
    System.out.println("ID Komputer  : " + getIdPerangkat());
    System.out.println("Merk         : " + getMerk());
    System.out.println("Tipe         : " + getTipe());
    System.out.println("Kerusakan    : " + getKerusakan());
    System.out.println("Jenis Casing : " + jenisCasing);
}
```

<img width="637" height="326" alt="image" src="https://github.com/user-attachments/assets/4c00dd2a-038b-4e0f-abaf-ada823f7da4a" />

Dengan adanya atribut khusus tersebut, `Laptop` dan `Komputer` memiliki
perbedaan yang jelas sebagai subclass dari `Perangkat`.

### 4.4 `Pelanggan`

Class `Pelanggan` menyimpan `idPelanggan`, `nama`, `noTelepon`, dan `alamat`. Pada MP4, data pelanggan disimpan ke tabel `pelanggan` melalui `PelangganDAO`.

Data yang disimpan terdiri dari:

-   `idPelanggan`
-   `nama`
-   `noTelepon`
-   `alamat`

Contoh:

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

Atribut yang digunakan yaitu:

-   `idServis`
-   `tanggal`
-   `status`
-   `biaya`
-   `pelanggan`
-   `perangkat`

Contoh:

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

Object `Pelanggan` dan `Perangkat` disimpan di dalam object `Servis`
sehingga satu data servis memiliki informasi pelanggan dan perangkat
yang berkaitan.

------------------------------------------------------------------------

## 5. Inheritance

Inheritance diterapkan dengan `Perangkat` sebagai superclass, sedangkan `Laptop` dan `Komputer` menjadi subclass. Data umum perangkat didefinisikan pada superclass, sedangkan setiap subclass memiliki atribut tambahan sesuai jenisnya.

Inheritance diterapkan dengan hubungan:

``` text
Perangkat
   ├── Laptop
   └── Komputer
```

Class `Perangkat` menjadi superclass:

``` java
public abstract class Perangkat implements InformasiPerangkat {
```

Kemudian `Laptop` menjadi subclass:

``` java
public class Laptop extends Perangkat {
```

Dan `Komputer` menjadi subclass:

``` java
public class Komputer extends Perangkat {
```

Dengan penerapan inheritance, data umum seperti ID perangkat, merk,
tipe, dan kerusakan cukup didefinisikan pada `Perangkat`.

------------------------------------------------------------------------

## 6. Polymorphism

Polymorphism diterapkan melalui **method overriding** dan **method
overloading**.

Overriding diterapkan pada `tampilkanInfo()` di class `Laptop` dan
`Komputer`, sedangkan overloading diterapkan pada class `Servis` melalui
dua method `tampilkanInfo()` dengan parameter yang berbeda.


### Method Overriding

Method `tampilkanInfo()` didefinisikan pada `Perangkat`, kemudian diimplementasikan oleh `Laptop` dan `Komputer`. Implementasi yang dijalankan menyesuaikan jenis object.
Method `tampilkanInfo()` didefinisikan sebagai abstract method pada
class `Perangkat`, kemudian diimplementasikan oleh `Laptop` dan
`Komputer`.

``` java
@Override
public void tampilkanInfo()
```

Pada saat program membuat perangkat, tipe object dapat berupa `Laptop`
atau `Komputer`.

Contohnya:

``` java
Perangkat perangkat;

if (pilihanJenis == 1) {

    String ukuranLayar =
            validasi.inputTeks("Ukuran Layar (Inci): ");

    perangkat = new Laptop(
        idPerangkat,
        merk,
        tipe,
        kerusakan,
        ukuranLayar
    );

} else {

    String jenisCasing =
            validasi.inputTeks("Jenis Casing: ");

    perangkat = new Komputer(
        idPerangkat,
        merk,
        tipe,
        kerusakan,
        jenisCasing
    );
}
```

<img width="392" height="127" alt="image" src="https://github.com/user-attachments/assets/1b5c560d-4118-46e4-a813-8c463dabfb1a" />
<img width="377" height="124" alt="image" src="https://github.com/user-attachments/assets/461cc812-f0db-4d0c-ad81-a16f5323f832" />


### Method Overloading

Class `Servis` memiliki dua method `tampilkanInfo()` dengan parameter berbeda. Perbedaan parameter tersebut merupakan penerapan method overloading.
Polymorphism melalui overloading diterapkan pada class `Servis`.

Class `Servis` memiliki dua method dengan nama yang sama, yaitu
`tampilkanInfo()`, tetapi memiliki parameter yang berbeda.

Method pertama:

``` java
public void tampilkanInfo() {
    tampilkanInfo(true);
}
```

Method kedua:

``` java
public void tampilkanInfo(boolean tampilkanPelanggan) {
    // isi method
}
```

Perbedaan parameter tersebut menunjukkan penerapan **method overloading**.
`Servis.java`


<img width="389" height="368" alt="Screenshot 2026-10-15 202227" src="https://github.com/user-attachments/assets/008f6181-4f9f-4207-8eb3-b087deba3949" />
<img width="186" height="59" alt="Screenshot 2026-10-15 202210" src="https://github.com/user-attachments/assets/5c2980d0-fbd0-47f3-a3e6-8487015e2d35" />


------------------------------------------------------------------------

## 7. Abstraction

Abstraction diterapkan menggunakan abstract class `Perangkat` dan abstract method `tampilkanInfo()`. Method tersebut wajib diimplementasikan oleh subclass.

### Abstract Class

Class `Perangkat` dibuat sebagai abstract class:

``` java
public abstract class Perangkat implements InformasiPerangkat
```

Class ini digunakan sebagai class dasar untuk `Laptop` dan `Komputer`.
Karena bersifat abstract, class `Perangkat` tidak dibuat menjadi object
secara langsung.

### Abstract Method

Class `Perangkat` memiliki abstract method:

``` java
public abstract void tampilkanInfo();
```

Method tersebut tidak memiliki isi pada class `Perangkat` dan wajib
diimplementasikan oleh subclass.

Class `Laptop` dan `Komputer` kemudian memberikan implementasi masing-
masing melalui method overriding.

`Perangkat.java`

<img width="532" height="167" alt="image" src="https://github.com/user-attachments/assets/39a6c226-6990-42d5-aefc-d84098cf404b" />


------------------------------------------------------------------------

## 8. Interface

Interface `InformasiPerangkat` memiliki method `tampilkanInfo()` dan diimplementasikan oleh abstract class `Perangkat`. Class turunannya memberikan implementasi sesuai jenis perangkat.

``` java
package interfaces;

public interface InformasiPerangkat {

    void tampilkanInfo();
}
```

Interface tersebut kemudian diterapkan oleh abstract class `Perangkat`:

``` java
public abstract class Perangkat implements InformasiPerangkat
```

Dengan penerapan tersebut, `Perangkat` memiliki aturan untuk menyediakan
method `tampilkanInfo()` yang kemudian diimplementasikan oleh subclass.

`InformasiPerangkat.java`

<img width="249" height="83" alt="image" src="https://github.com/user-attachments/assets/e874b2f6-3f81-4c5f-84af-9e440321c3c2" />

`Perangkat.java`

<img width="389" height="31" alt="image" src="https://github.com/user-attachments/assets/3d7e279a-8f6c-4a2f-aaa1-2821d58b64a7" />


------------------------------------------------------------------------

## 9. Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut. Data diakses atau diubah melalui method yang tersedia, seperti getter dan setter apabila diperlukan.

Contohnya:

``` java
private final String idPerangkat;
private String merk;
private String tipe;
private String kerusakan;
```

Dengan menggunakan `private`, atribut tidak dapat diakses secara
langsung dari luar class.

Untuk mengakses data tersebut, program menggunakan getter.

Contohnya:

``` java
public String getMerk() {
    return merk;
}
```

Sedangkan untuk mengubah data yang memang dapat diubah, program
menggunakan setter.

Contohnya pada class `Servis`:

``` java
public void setStatus(String status) {
    this.status = status;
}
```

Setter tersebut digunakan ketika proses ubah data servis.


------------------------------------------------------------------------
## 10. Access Modifier

Program menerapkan beberapa access modifier, yaitu `private` dan
`public`.

### `private`

Digunakan pada atribut agar data tidak dapat diakses secara langsung
dari luar class.

Contohnya:

``` java
private String nama;
private String noTelepon;
private String alamat;
```

### `public`

Digunakan pada class, constructor, getter, setter, dan method yang perlu
digunakan oleh bagian program lainnya.

Contohnya:

``` java
public void tambahServis()
```

Penggunaan access modifier mendukung penerapan encapsulation pada
program.

------------------------------------------------------------------------

## 11. Constructor dan Object

Constructor memberikan nilai awal ketika object dibuat. Program menggunakan object `Pelanggan`, `Laptop` atau `Komputer`, serta `Servis`. Pada MP4, data yang diperlukan kemudian diproses melalui controller dan DAO untuk disimpan atau diambil dari database.

------------------------------------------------------------------------

## 12. Database MySQL

Program menggunakan database MySQL bernama **`db_servis_laptop`**. Database dikelola melalui Laragon dan digunakan untuk menyimpan data pelanggan, perangkat, dan servis.

<img width="245" height="28" alt="Screenshot 2026-10-10 225403" src="https://github.com/user-attachments/assets/5619ca7a-9934-4cd7-aa21-dbae05135ca5" />

### 12.1 Tabel `pelanggan`

| Kolom | Keterangan |
|---|---|
| `id_pelanggan` | ID unik pelanggan |
| `nama` | Nama pelanggan |
| `no_telepon` | Nomor telepon pelanggan |
| `alamat` | Alamat pelanggan |

### 12.2 Tabel `perangkat`

| Kolom | Keterangan |
|---|---|
| `id_perangkat` | ID unik perangkat |
| `jenis_perangkat` | Jenis perangkat |
| `merk` | Merek perangkat |
| `tipe` | Tipe perangkat |
| `kerusakan` | Informasi kerusakan |
| `ukuran_layar` | Ukuran layar laptop |
| `jenis_casing` | Jenis casing komputer |

### 12.3 Tabel `servis`

| Kolom | Keterangan |
|---|---|
| `id_servis` | ID unik servis |
| `tanggal` | Tanggal servis |
| `status` | Status pengerjaan |
| `biaya` | Biaya servis |
| `id_pelanggan` | ID pelanggan terkait |
| `id_perangkat` | ID perangkat terkait |

Status servis yang digunakan adalah `Menunggu`, `Diproses`, dan `Selesai`.


<img width="421" height="161" alt="Screenshot 2026-10-10 225437" src="https://github.com/user-attachments/assets/44c7861b-8662-4662-87d7-a1a2fea1cda4" />

<img width="269" height="86" alt="Screenshot 2026-10-10 225420" src="https://github.com/user-attachments/assets/739e5f84-5faa-44af-8742-2c6e121af786" />

<img width="275" height="124" alt="Screenshot 2026-10-10 225428" src="https://github.com/user-attachments/assets/655cd7ad-8fb3-4d19-b87a-e26fd8b96b59" />

```text
mysql> DESC pelanggan;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| id_pelanggan | varchar(10)  | NO   | PRI | NULL    |       |
| nama         | varchar(100) | NO   |     | NULL    |       |
| no_telepon   | varchar(15)  | NO   |     | NULL    |       |
| alamat       | varchar(200) | NO   |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
4 rows in set (0.01 sec)

mysql> DESC perangkat;
+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| id_perangkat    | varchar(10)  | NO   | PRI | NULL    |       |
| jenis_perangkat | varchar(20)  | NO   |     | NULL    |       |
| merk            | varchar(50)  | NO   |     | NULL    |       |
| tipe            | varchar(100) | NO   |     | NULL    |       |
| kerusakan       | varchar(200) | NO   |     | NULL    |       |
| ukuran_layar    | varchar(30)  | YES  |     | NULL    |       |
| jenis_casing    | varchar(30)  | YES  |     | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+
7 rows in set (0.00 sec)

mysql> DESC servis;
+--------------+---------------------------------------+------+-----+---------+-------+
| Field        | Type                                  | Null | Key | Default | Extra |
+--------------+---------------------------------------+------+-----+---------+-------+
| id_servis    | varchar(10)                           | NO   | PRI | NULL    |       |
| tanggal      | date                                  | NO   |     | NULL    |       |
| status       | enum('menunggu','diproses','selesai') | NO   |     | NULL    |       |
| biaya        | int                                   | NO   |     | NULL    |       |
| id_pelanggan | varchar(10)                           | NO   | MUL | NULL    |       |
| id_perangkat | varchar(10)                           | NO   | MUL | NULL    |       |
+--------------+---------------------------------------+------+-----+---------+-------+
6 rows in set (0.00 sec)
```

### 12.4 Relasi Antar Tabel

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

### 11.5 Dummy Data

Dummy data dimasukkan melalui file SQL, bukan ditulis langsung di kode Java. Data awal mencakup pelanggan, perangkat, dan servis yang saling berhubungan untuk membantu pengujian program.

<img width="463" height="63" alt="Screenshot 2026-10-10 225902" src="https://github.com/user-attachments/assets/35381e68-1910-45a2-b17d-3e78e49d3775" />

<img width="724" height="59" alt="Screenshot 2026-10-10 230540" src="https://github.com/user-attachments/assets/e6218248-b0dd-48da-9233-cee2ca49bdcb" />

<img width="590" height="63" alt="Screenshot 2026-10-10 231052" src="https://github.com/user-attachments/assets/9962c790-e373-4609-8737-56ba4d4f46c4" />

```text
mysql> SELECT * FROM pelanggan;
+--------------+--------------+--------------+-------------+
| id_pelanggan | nama         | no_telepon   | alamat      |
+--------------+--------------+--------------+-------------+
| P001         | James Chao   | 081234567890 | Samarinda   |
| P002         | Andi Pratama | 082345678901 | Balikpapan  |
| P003         | Ghea         | 0895704176685| Jl. Pramuka |
+--------------+--------------+--------------+-------------+
3 rows in set (0.02 sec)

mysql> SELECT * FROM perangkat;
+--------------+-----------------+--------+-------------+------------------------------------------+--------------+--------------+
| id_perangkat | jenis_perangkat | merk   | tipe        | kerusakan                                | ukuran_layar | jenis_casing |
+--------------+-----------------+--------+-------------+------------------------------------------+--------------+--------------+
| K001         | Komputer        | Lenovo | ThinkCentre | Komputer tidak dapat menyala             | NULL         | Tower        |
| L001         | Laptop          | ASUS   | VivoBook 14 | Keyboard beberapa tombol tidak berfungsi | 14 inci      | NULL         |
| L002         | Laptop          | LENOVO | ThinkPad    | Overheating                              | 14 inci      | NULL         |
+--------------+-----------------+--------+-------------+------------------------------------------+--------------+--------------+
3 rows in set (0.01 sec)

mysql> SELECT * FROM servis;
+-----------+------------+----------+--------+--------------+--------------+
| id_servis | tanggal    | status   | biaya  | id_pelanggan | id_perangkat |
+-----------+------------+----------+--------+--------------+--------------+
| S001      | 2026-09-09 | diproses | 250000 | P001         | L001         |
| S002      | 2026-09-10 | menunggu | 150000 | P002         | K001         |
| S003      | 2026-08-16 | diproses | 58000  | P003         | L002         |
+-----------+------------+----------+--------+--------------+--------------+
3 rows in set (0.01 sec)
```

```java
package com.mycompany.servislaptop;

import controller.ServisController;
import java.util.Scanner;
import view.MenuView;
import dao.PelangganDAO;

public class ServisLaptop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ServisController controller = new ServisController();
        MenuView menu = new MenuView(input, controller);

        menu.tampilkanMenu();
        input.close();

        PelangganDAO pelangganDAO = new PelangganDAO();
        pelangganDAO.tampilkanSemuaPelanggan();
    }
}
```

<img width="406" height="176" alt="Screenshot 2026-10-10 233503" src="https://github.com/user-attachments/assets/25ce7f79-9adf-47d0-9475-228fce8c852d" />

<img width="291" height="180" alt="Screenshot 2026-10-10 233846" src="https://github.com/user-attachments/assets/169c776d-a1bb-4a6d-8c68-048f5129a2c1" />

<img width="169" height="229" alt="Screenshot 2026-10-10 234039" src="https://github.com/user-attachments/assets/5385c73b-f7f7-4cf6-a326-ec8c7e672d28" />


------------------------------------------------------------------------

## 13. Implementasi JDBC dan DAO

### 13.1 JDBC

JDBC (*Java Database Connectivity*) digunakan untuk menghubungkan program Java dengan database MySQL serta menjalankan perintah SQL.

### 13.2 Koneksi Database

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

### 13.3 PreparedStatement

`PreparedStatement` digunakan untuk menjalankan perintah SQL dengan parameter. Parameter ditandai dengan tanda tanya (`?`) dan diisi menggunakan method seperti `setString()` atau `setInt()`.

Penggunaan `PreparedStatement` membantu memisahkan query dari nilai input dan mengurangi risiko SQL injection.

```java
try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
```

### 13.4 Data Access Object (DAO)

DAO memisahkan proses akses database dari bagian program lainnya. `PelangganDAO` mengelola pelanggan, `PerangkatDAO` mengelola perangkat, dan `ServisDAO` mengelola servis.
`PelangganDAO.java`
```java
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
```

`PerangkatDAO.java`
```java
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
```
`ServisDAO.java`
```java
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
```


### 13.5 ResultSet

`ResultSet` digunakan untuk membaca hasil query dari database, misalnya saat program menampilkan data servis.

### 13.6 Try-with-resources

Program menggunakan try-with-resources untuk membantu menutup `Connection`, `PreparedStatement`, dan `ResultSet` setelah selesai digunakan.

### 13.7 Transaksi Database

Pada proses penambahan data servis, `ServisDAO` menggunakan transaksi database. Jika proses berhasil, perubahan disimpan menggunakan `commit()`. Jika terjadi kesalahan, perubahan dibatalkan menggunakan `rollback()`.

------------------------------------------------------------------------

## 14. Proses Tambah Data Servis

Proses tambah data dijalankan ketika pengguna memilih menu **1. Tambah
Data Servis**.

### Data Pelanggan

Pengguna memasukkan:

-   ID Pelanggan
-   Nama
-   Nomor Telepon
-   Alamat

### Data Perangkat

Pengguna terlebih dahulu memilih jenis perangkat:

``` text
1. Laptop
2. Komputer
```

Kemudian memasukkan:

-   ID Perangkat
-   Merk
-   Tipe
-   Kerusakan

Jika memilih **Laptop**, pengguna juga memasukkan:

-   Ukuran Layar (Inci)

Jika memilih **Komputer**, pengguna juga memasukkan:

-   Jenis Casing

### Data Servis

Selanjutnya pengguna memasukkan:

-   ID Servis
-   Tanggal
-   Status
-   Biaya

Status servis terdiri dari:

``` text
1. Menunggu
2. Diproses
3. Selesai
```

Setelah semua data dinyatakan valid, program membuat object `Pelanggan`,
`Perangkat`, dan `Servis`.


Pengguna memilih menu **1. Tambah Data Servis**, lalu memasukkan data pelanggan, memilih jenis perangkat, memasukkan data perangkat, dan mengisi informasi servis.

Status servis yang tersedia:

```text
1. Menunggu
2. Diproses
3. Selesai
```

Setelah input divalidasi, controller memanggil DAO untuk menyimpan data ke database. `ServisDAO` menangani penambahan data yang saling berhubungan menggunakan transaksi database.

<img width="191" height="394" alt="image" src="https://github.com/user-attachments/assets/d711d56f-a4f0-4a17-bd79-cdca68fb4167" />

------------------------------------------------------------------------

## 15. Proses Menampilkan Data

Menu **2. Tampilkan Data Servis** digunakan untuk menampilkan data yang tersimpan di database. Program mengambil data melalui `ServisDAO`, membaca hasil query menggunakan `ResultSet`, lalu menampilkan informasi melalui terminal.

Informasi yang ditampilkan meliputi data pelanggan, perangkat, dan servis.

Program melakukan perulangan terhadap `daftarServis`.

``` java
for (Servis servis : daftarServis) {

    servis.tampilkanInfo();

}
```

Informasi yang ditampilkan meliputi:

-   ID Pelanggan
-   Nama
-   Nomor Telepon
-   Alamat
-   Jenis Perangkat
-   ID Perangkat
-   Merk
-   Tipe
-   Kerusakan
-   ID Servis
-   Tanggal
-   Status
-   Biaya

Karena terdapat dummy data, data servis sudah langsung tampil ketika
fitur read dijalankan.

```text
Pilih menu: 2

=== DAFTAR DATA SERVIS ===
================================
           DATA SERVIS
================================

ID Pelanggan : P001
Nama         : James Chao
No Telepon   : 081234567890
Alamat       : Samarinda

Jenis        : Laptop
ID Laptop    : L001
Merk         : ASUS
Tipe         : VivoBook 14
Kerusakan    : Keyboard beberapa tombol tidak berfungsi
Ukuran Layar (Inci) : 14 inci

ID Servis    : S001
Tanggal      : 09-09-2026
Status       : Diproses
Biaya        : Rp250000
================================

================================
           DATA SERVIS
================================

ID Pelanggan : P002
Nama         : Andi Pratama
No Telepon   : 082345678901
Alamat       : Balikpapan

Jenis        : Komputer
ID Komputer  : K001
Merk         : Lenovo
Tipe         : ThinkCentre
Kerusakan    : Komputer tidak dapat menyala
Jenis Casing : Tower

ID Servis    : S002
Tanggal      : 10-09-2026
Status       : Menunggu
Biaya        : Rp150000
================================

================================
           DATA SERVIS
================================

ID Pelanggan : P003
Nama         : Ghea
No Telepon   : 0895704176685
Alamat       : Jl. Pramuka

Jenis        : Laptop
ID Laptop    : L002
Merk         : LENOVO
Tipe         : ThinkPad
Kerusakan    : Overheating
Ukuran Layar (Inci) : 14 inci

ID Servis    : S003
Tanggal      : 15-08-2026
Status       : Menunggu
Biaya        : Rp50000
================================
```

------------------------------------------------------------------------

## 16. Proses Mengubah Data

Menu **3. Ubah Data Servis** digunakan untuk mengubah tanggal, status, dan biaya servis berdasarkan ID servis. Setelah input divalidasi, `ServisDAO` menjalankan perintah SQL untuk memperbarui data pada database.

Jika ID tidak ditemukan, program menampilkan pesan bahwa data tidak tersedia.

Pengguna memasukkan ID servis terlebih dahulu.

``` text
Masukkan ID Servis: S005
```

Jika data ditemukan, program akan menampilkan data tersebut.

Data yang dapat diubah adalah:

-   Tanggal
-   Status
-   Biaya

Status dapat dipilih kembali melalui pilihan:

``` text
1. Menunggu
2. Diproses
3. Selesai
```

Setter digunakan untuk menyimpan perubahan.

``` java
servis.setTanggal(tanggalBaru);
servis.setStatus(statusBaru);
servis.setBiaya(biayaBaru);
```

Jika ID servis tidak ditemukan, program akan menampilkan:

``` text
Data servis tidak ditemukan.
```

```text
Pilih menu: 3

=== UBAH DATA SERVIS ===
Masukkan ID Servis: S003

Data ditemukan:
================================
           DATA SERVIS
================================

ID Pelanggan : P003
Nama         : Ghea
No Telepon   : 0895704176685
Alamat       : Jl. Pramuka

Jenis        : Laptop
ID Laptop    : L002
Merk         : LENOVO
Tipe         : ThinkPad
Kerusakan    : Overheating
Ukuran Layar (Inci) : 14 inci

ID Servis    : S003
Tanggal      : 15-08-2026
Status       : Menunggu
Biaya        : Rp50000
================================

--- UBAH DATA SERVIS ---
Tanggal baru (DD-MM-YYYY): 16-08-2026

Pilih Status Proses:
1. Menunggu
2. Diproses
3. Selesai
Pilih status: 2
Biaya baru: Rp58000
Data servis berhasil diubah.
```

------------------------------------------------------------------------

## 17. Proses Menghapus Data

Menu **4. Hapus Data Servis** digunakan untuk menghapus data servis berdasarkan ID servis. Sebelum penghapusan, program meminta konfirmasi:

Program terlebih dahulu mencari data berdasarkan ID.

Jika data ditemukan, data tersebut ditampilkan dan pengguna diminta
melakukan konfirmasi.

``` text
Yakin ingin menghapus? (y/n):
```

Jika pengguna memilih `y`, data akan dihapus:

``` java
daftarServis.remove(servis);
```

Jika pengguna memilih `n`, penghapusan dibatalkan.

Program juga melakukan validasi agar pengguna hanya memasukkan `y` atau
`n`.

```text
Yakin ingin menghapus? (y/n):
```

Jika pengguna memilih `y`, DAO menghapus data dari database. Jika memilih `n`, penghapusan dibatalkan.

```text
Pilih menu: 4

=== HAPUS DATA SERVIS ===
Masukkan ID Servis: S003

Data yang akan dihapus:
================================
           DATA SERVIS
================================

ID Pelanggan : P003
Nama         : Ghea
No Telepon   : 0895704176685
Alamat       : Jl. Pramuka

Jenis        : Laptop
ID Laptop    : L002
Merk         : LENOVO
Tipe         : ThinkPad
Kerusakan    : Overheating
Ukuran Layar (Inci) : 14 inci

ID Servis    : S003
Tanggal      : 16-08-2026
Status       : Diproses
Biaya        : Rp58000
================================

Yakin ingin menghapus? (y/n): n
Penghapusan dibatalkan.
```

```text
Yakin ingin menghapus? (y/n): y
Data servis berhasil dihapus.
```

------------------------------------------------------------------------

## 18. Proses Pencarian Data

Menu **5. Cari Data Servis** digunakan untuk mencari data berdasarkan ID servis. DAO menjalankan query pencarian pada database. Jika data ditemukan, informasi servis ditampilkan.

Mengguna memasukkan ID servis:

``` text
Masukkan ID Servis: S005
```

Program kemudian melakukan pencarian pada `daftarServis`.

Jika data ditemukan, informasi servis akan ditampilkan.


```text
Pilih menu: 5

=== CARI DATA SERVIS ===
Masukkan ID Servis: S001

Data ditemukan:
================================
           DATA SERVIS
================================

ID Pelanggan : P001
Nama         : James Chao
No Telepon   : 081234567890
Alamat       : Samarinda

Jenis        : Laptop
ID Laptop    : L001
Merk         : ASUS
Tipe         : VivoBook 14
Kerusakan    : Keyboard beberapa tombol tidak berfungsi
Ukuran Layar (Inci) : 14 inci

ID Servis    : S001
Tanggal      : 09-09-2026
Status       : Diproses
Biaya        : Rp250000
================================
```

Jika data tidak ditemukan, program menampilkan:

```text
Data servis tidak ditemukan.
```

------------------------------------------------------------------------

## 19. Validasi Input

Program menerapkan validasi untuk mengurangi kesalahan input.

### Validasi Input Kosong

Validasi input kosong digunakan untuk memastikan pengguna tidak sengaja mengosongkan pengisian data.

Program juga menolak input yang kosong.

Contohnya:

``` text
Tanggal (DD-MM-YYYY):
Tanggal tidak boleh kosong!
```

<img width="184" height="26" alt="kosong" src="https://github.com/user-attachments/assets/b8ad9abf-1157-409d-a7b5-f3d6de88445d" />

Fitur ini membantu pengguna menemukan data tertentu tanpa harus melihat
seluruh data servis.

### Validasi Nomor Telepon

Validasi nomor telepon digunakan untuk memastikan pengguna telah menginput angka untuk nomor telepon dan bukan menginput huruf ataupun simbol.
Selain itu, memastikan pengguna menginput nomor telepon sebanyak 10-13 digit dan tidak kurang dari 10 digit.

Ketika pengguna memasukkan huruf:

``` text
No Telepon: fhuiah
Nomor telepon hanya boleh berisi angka!
```

<img width="229" height="52" alt="Screenshot 2026-09-24 073552" src="https://github.com/user-attachments/assets/722e3fe4-98c2-471d-9b91-8badeeafa7e6" />


Ketika nomor kurang dari 10 digit:

``` text
No Telepon: 0493204
Nomor telepon harus 10-13 digit!
```

<img width="186" height="28" alt="Screenshot 2026-09-24 073607" src="https://github.com/user-attachments/assets/a300417f-1fa1-4ca6-9eee-adf3cfc493d9" />

### Validasi Jenis Perangkat

Validasi jenis perangkat digunakan untuk memastikan pengguna menginput pilihan yang tersedia di menu dan tidak menginput pilihan lain selain itu.

Ketika pengguna memasukkan pilihan `3`:

``` text
Pilih jenis perangkat: 3
Pilihan hanya 1 atau 2!
```

<img width="144" height="62" alt="Screenshot 2026-09-24 073640" src="https://github.com/user-attachments/assets/89cf593f-e6eb-4047-997d-847ea6bdd29b" />

### Validasi Status

Status servis hanya dapat dipilih dari `Menunggu`, `Diproses`, atau `Selesai`.

```text
Pilih Status Proses:
1. Menunggu
2. Diproses
3. Selesai
Pilih status: 4
Pilihan hanya 1, 2, atau 3!
```

<img width="154" height="78" alt="image" src="https://github.com/user-attachments/assets/0f2631a3-e5aa-4c1e-b5ed-5f59d508dccc" />

### Validasi Tanggal

Validasi tanggal digunakan untuk memastikan pengguna menginput tanggal servis sesuai dengan format yang sudah ditentukan oleh program. Database MySQL menyimpan tanggal dengan tipe `DATE`, sehingga program melakukan konversi format tanggal. Selain itu, program memastikan pengguna untuk menginput bulan yang benar yaitu antara bulan 01-12 saja.

Program menggunakan format:

``` text
DD-MM-YYYY
```

Ketika pengguna memasukkan:

``` text
04/06/2026
```

program menampilkan:

``` text
Format tanggal harus DD-MM-YYYY!
```

<img width="184" height="26" alt="format " src="https://github.com/user-attachments/assets/b8bd2c87-1f71-4deb-b837-9ed8a95df164" />


Program juga memeriksa bulan.

Contohnya:

``` text
20-13-2026
Bulan harus 01-12!
```

<img width="184" height="26" alt="bulan" src="https://github.com/user-attachments/assets/c160ea79-f2c7-4ff8-a969-d012e4d2f324" />

### Validasi Biaya

Validasi biaya digunakan untuk memastikan biaya servis yang dimasukkan oleh pengguna berupa angka dan sesuai dengan ketentuan yang telah ditentukan. Jika pengguna memasukkan huruf, sistem akan menampilkan pesan bahwa biaya harus berupa angka.

Selain itu, biaya servis yang dimasukkan harus memiliki nilai minimal Rp50.000. Jika biaya yang dimasukkan kurang dari batas tersebut, sistem akan meminta pengguna memasukkan biaya kembali.

Ketika pengguna memasukkan huruf pada biaya:

``` text
Biaya: Rpabcde
Biaya harus berupa angka!
```

<img width="149" height="53" alt="Screenshot 2026-09-24 074104" src="https://github.com/user-attachments/assets/0dc400a2-8a8b-4d89-9de3-9ea7f5bd134a" />

Ketika pengguna memasukkan biaya servis yang kurang dari nominal Rp 50.000:

<img width="131" height="38" alt="image" src="https://github.com/user-attachments/assets/6595e88a-f159-4f1b-bda9-b71a3c2df7e5" />

### Validasi ID

Program memeriksa ID agar tidak terjadi penggunaan ID yang sama pada data baru.

```text
--- DATA SERVIS ---
ID Servis: s001
ID Servis sudah digunakan!
```

<img width="152" height="44" alt="image" src="https://github.com/user-attachments/assets/c0645e80-1400-4b1f-9211-b4da69d5384c" />

------------------------------------------------------------------------

## 20. Perulangan Program

Program menggunakan perulangan pada menu utama agar pengguna dapat menjalankan beberapa fitur tanpa menjalankan ulang program setiap kali selesai melakukan satu proses. Menu terus ditampilkan sampai pengguna memilih **6. Keluar**.

Perulangan juga digunakan dalam proses validasi agar pengguna dapat memasukkan kembali data jika input tidak sesuai.

Program menggunakan beberapa jenis perulangan.

### `while`

Digunakan pada menu utama agar program terus berjalan sampai pengguna
memilih menu 6.

``` java
while (true) {
    // menampilkan menu
    // menerima pilihan
    // memproses pilihan menu
}
```

### `for`

Digunakan untuk membaca data yang terdapat dalam `ArrayList`.

``` java
for (Servis servis : daftarServis) {
    servis.tampilkanInfo();
}
```

### `while`

Digunakan pada proses validasi input.

``` java
while (true) {
    // meminta input
    // memeriksa input
}
```

Jika input salah, program akan meminta pengguna memasukkan data kembali.


------------------------------------------------------------------------

## 21. Percabangan `if-else` dan `switch-case`

Program menggunakan `switch-case` untuk memproses pilihan menu. Setiap pilihan menjalankan fitur yang sesuai.

`if-else` digunakan untuk menentukan kondisi tertentu, misalnya saat pengguna memilih jenis perangkat laptop atau komputer dan saat program memeriksa hasil pencarian data.

Selain `switch-case`, program juga menggunakan `if-else` untuk
menentukan kondisi tertentu.

Contohnya pada pemilihan jenis perangkat:

``` java
if (pilihanJenis == 1) {

    perangkat = new Laptop(
        idPerangkat,
        merk,
        tipe,
        kerusakan,
        ukuranLayar
    );

} else {

    perangkat = new Komputer(
        idPerangkat,
        merk,
        tipe,
        kerusakan,
        jenisCasing
    );
}
```

`if-else` juga digunakan pada proses validasi, pencarian data, dan
pengecekan kondisi lainnya.


------------------------------------------------------------------------

## 22. Koneksi Database

Pengujian dilakukan untuk memastikan program dapat terhubung ke database MySQL.

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

------------------------------------------------------------------------

## 23. Penerapan Konsep PBO

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

## 24. Alur Program

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

## 25. Teknologi yang Digunakan

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

## 26. Cara Menjalankan Program

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

## 27. Kesimpulan

**Sistem Pengelolaan Servis Laptop** dapat digunakan untuk membantu proses pencatatan dan pengelolaan data pelanggan, perangkat, serta servis melalui terminal.

Program menyediakan fitur tambah, tampil, ubah, hapus, dan cari data servis. Pada pengembangan terbaru, penyimpanan data beralih menggunakan **database MySQL** melalui **JDBC (Java Database Connectivity)** dan pola **DAO (Data Access Object)**, sehingga data dapat tersimpan secara permanen dan diakses kembali ketika program dijalankan ulang.

Dalam pengembangannya, program tetap menerapkan konsep Pemrograman Berorientasi Objek seperti *class, object, constructor, encapsulation, access modifier, getter*, dan *setter*.

Program juga menerapkan **inheritance** dengan `Perangkat` sebagai *superclass* dan `Laptop` serta `Komputer` sebagai *subclass*.

Selain itu, program menerapkan **polymorphism melalui method overriding dan overloading**. Overriding diterapkan pada `Laptop` dan `Komputer` melalui method `tampilkanInfo()`, sedangkan overloading diterapkan pada class terkait dengan parameter yang berbeda.

Program juga menerapkan **abstraction** melalui abstract class `Perangkat` dan abstract method `tampilkanInfo()`, serta mengimplementasikan interface `InformasiPerangkat`.

Program menggunakan struktur **MVC (Model-View-Controller)** yang memisahkan bagian model, controller, dan view agar arsitektur kode lebih bersih dan terorganisir.

Untuk mengurangi kesalahan input, program dilengkapi dengan berbagai validasi seperti validasi input kosong, nomor telepon, jenis perangkat, status, tanggal, biaya, dan ID servis.

Dengan penerapan konsep PBO, struktur MVC, serta integrasi database MySQL menggunakan DAO dan JDBC, program menjadi lebih terorganisir, profesional, dan handal dalam mengelola data servis secara *real-time*.
