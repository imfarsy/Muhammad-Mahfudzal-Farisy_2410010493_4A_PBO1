# Proyek Akhir Pemrograman Berorientasi Objek 1

# MeratusHiking
## Sistem Registrasi & Booking Jalur Pendakian Gunung Berbasis Java

---

# Deskripsi Proyek
MeratusHiking adalah aplikasi berbasis Java (console) yang dibuat sebagai Proyek Akhir mata kuliah Pemrograman Berorientasi Objek 1 (PBO1). Aplikasi ini mensimulasikan proses manajemen registrasi izin masuk (SIMAKSI) untuk rombongan yang ingin mendaki gunung atau bukit populer di kawasan Pegunungan Meratus, Kalimantan Selatan.

# Latar Belakang
Banyak pendaki kelompok atau rombongan membutuhkan pendataan izin masuk yang rapi serta kalkulasi biaya jaminan asuransi otomatis sebelum mendaki. Berdasarkan studi kasus tersebut dibuat aplikasi sederhana untuk mengelola proses pendaftaran sekaligus menerapkan konsep-konsep Pemrograman Berorientasi Objek.

# Tujuan
- Menerapkan seluruh konsep dasar PBO.
- Membuat aplikasi registrasi pendakian sederhana.
- Memenuhi tugas UAS PBO1.

# Fitur
- Melihat data jalur pendakian dan bukit di Kalsel.
- Mencari gunung berdasarkan wilayah kabupaten.
- Melakukan booking/registrasi pendakian kelompok.
- Menghitung total biaya pendaftaran otomatis (termasuk asuransi).
- Menampilkan riwayat transaksi pendaftaran.
- Memberikan rekomendasi alat standar berdasarkan tinggi mdpl secara fleksibel.
- Error handling input menu dan angka.

# Struktur Class
```text
muhammad_mahfudzal_farisy_2410010493_4a_pbo1
├── JalurPendakian.java
├── RegistrasiPendaki.java
└── Main.java
```

# Penjelasan Setiap Class

## JalurPendakian.java
Class induk (parent class) yang menyimpan data dasar gunung meliputi namaGunung, ketinggian, lokasi, dan hargaSimaksi. Class ini menerapkan encapsulation melalui atribut private, constructor, getter, setter, serta polymorphism dasar method hitungTotalBiaya().
```java
public class JalurPendakian {
    private String namaGunung;
    private int ketinggian;
    private String lokasi;
    private double hargaSimaksi;
    
    public double hitungTotalBiaya(int jumlahPendaki) {
        return this.hargaSimaksi * jumlahPendaki;
    }
}
```

## RegistrasiPendaki.java
Merupakan turunan dari JalurPendakian menggunakan keyword extends (Inheritance). Menambahkan atribut namaKetua dan jumlahPendaki, serta melakukan overriding terhadap method hitungTotalBiaya() untuk menambahkan kalkulasi asuransi kelompok secara otomatis.
```java
public class RegistrasiPendaki extends JalurPendakian {
    private String namaKetua;
    private int jumlahPendaki;

    @Override
    public double hitungTotalBiaya(int jumlahPendaki) {
        double biayaAsuransiWajib = 5000 * jumlahPendaki;
        return super.hitungTotalBiaya(jumlahPendaki) + biayaAsuransiWajib;
    }
}
```

## Main.java
Berisi menu utama aplikasi, penampung objek array, Scanner input-output, seleksi percabangan, perulangan do-while, logika filter teks dinamis (.contains), dan penanganan error handling try-catch.
```java
public class Main {
    public static void main(String[] args) {
        JalurPendakian[] daftarGunung = { ... };
        RegistrasiPendaki[] riwayatBooking = new RegistrasiPendaki[100];
        // Perulangan do-while & Switch Case Menu
    }
}
```

# Implementasi Konsep PBO

## 1. Class
Project terdiri dari tiga class utama: JalurPendakian, RegistrasiPendaki, dan Main.

## 2. Object
```java
RegistrasiPendaki bookingBaru = new RegistrasiPendaki(...);
```
Object digunakan untuk memproses data transaksi booking pendakian yang baru diinput.

## 3. Attribute
```java
private String namaGunung;
private int ketinggian;
private String lokasi;
private double hargaSimaksi;
```
Atribut digunakan untuk menyimpan spesifikasi data dari setiap objek gunung/jalur.

## 4. Constructor
```java
public JalurPendakian(String namaGunung, int ketinggian, String lokasi, double hargaSimaksi){ ... }
```
Constructor menginisialisasi nilai awal setiap objek saat dimasukkan ke dalam sistem.

## 5. Mutator
```java
public void setNamaGunung(String namaGunung){ this.namaGunung = namaGunung; }
```
Digunakan untuk mengubah nilai atribut private dari luar class.

## 6. Accessor
```java
public String getNamaGunung(){ return namaGunung; }
public int getKetinggian(){ return ketinggian; }
```
Digunakan untuk mengambil atau membaca nilai atribut private.

## 7. Encapsulation
Seluruh atribut pada class data dibuat `private` sehingga keamanan datanya terjaga dan hanya bisa diakses via getter/setter.

## 8. Inheritance
```java
public class RegistrasiPendaki extends JalurPendakian
```
Class RegistrasiPendaki mewarisi seluruh atribut dan method publik dari class JalurPendakian.

## 9. Polymorphism
```java
@Override
public double hitungTotalBiaya(int jumlahPendaki){ ... }
```
Method hitungTotalBiaya() dioverride pada subclass untuk membedakan rumus perhitungan biaya antara SIMAKSI standar dan yang sudah ditambah asuransi wajib.

## 10. Seleksi
Menggunakan `switch-case` untuk kontrol menu utama, `if-else` untuk filter pencarian wilayah kabupaten, serta validasi string input pada rekomendasi alat standar.

## 11. Perulangan
Menggunakan `for` untuk menjelajahi isi data array master/transaksi dan `do-while` untuk menjaga agar menu utama terus berjalan.

## 12. Input Output
Menggunakan `Scanner` untuk menangkap ketikan dari user dan `System.out.println()` untuk mencetak output ke console.

## 13. Array
```java
JalurPendakian[] daftarGunung;
RegistrasiPendaki[] riwayatBooking;
```
Array objek digunakan untuk menyimpan database list gunung di Kalsel serta menampung list riwayat pendaftaran.

## 14. Error Handling
```java
try {
    pilihan = Integer.parseInt(input.nextLine());
} catch (NumberFormatException e) { ... }
```
Menangani kesalahan input tipe data (misal input huruf pada menu angka) agar program tidak mengalami crash.

# Cara Menjalankan
1. Buka project di NetBeans.
2. Pastikan susunan package sesuai.
3. Jalankan Main.java.
4. Gunakan menu console aplikasi (1-6).

# Usulan Nilai

| No | Konsep | Nilai |
|---:|-------------------------|:----:|
|1|Class|5|
|2|Object|5|
|3|Attribute|5|
|4|Constructor|5|
|5|Mutator|5|
|6|Accessor|5|
|7|Encapsulation|5|
|8|Inheritance|5|
|9|Polymorphism|10|
|10|Seleksi|5|
|11|Perulangan|5|
|12|Input Output|10|
|13|Array|15|
|14|Error Handling|15|
| |**Total**|**100**|

# Identitas Pembuat

- **Nama** : Muhammad Mahfudzal Farisy
- **NPM** : 2410010493
- **Kelas** : TI 4A Reg. Banjarbaru
