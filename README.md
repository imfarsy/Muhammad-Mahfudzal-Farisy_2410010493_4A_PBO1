
# Proyek Akhir Pemrograman Berorientasi Objek 1

# SummitRent
## Sistem Penyewaan Alat Pendakian Gunung Berbasis Java

---

# Deskripsi Proyek
SummitRent adalah aplikasi berbasis Java (console) yang dibuat sebagai Proyek Akhir mata kuliah Pemrograman Berorientasi Objek 1 (PBO1). Aplikasi ini mensimulasikan proses penyewaan alat pendakian gunung mulai dari melihat data alat, melakukan penyewaan, hingga menampilkan transaksi.

# Latar Belakang
Banyak pendaki tidak memiliki seluruh perlengkapan sehingga memilih menyewa alat. Berdasarkan studi kasus tersebut dibuat aplikasi sederhana untuk mengelola proses penyewaan sekaligus menerapkan konsep-konsep Pemrograman Berorientasi Objek.

# Tujuan
- Menerapkan seluruh konsep dasar PBO.
- Membuat aplikasi penyewaan sederhana.
- Memenuhi tugas UAS PBO1.

# Fitur
- Melihat data alat.
- Menyewa alat.
- Menghitung total biaya sewa.
- Menampilkan transaksi.
- Validasi stok.
- Validasi lama sewa.
- Error handling.

# Struktur Class
```text
summitrent
├── Alat.java
├── Tenda.java
├── Carrier.java
├── Penyewa.java
├── Transaksi.java
└── Main.java
```

# Penjelasan Setiap Class

## Alat.java
Class induk yang menyimpan atribut kodeAlat, namaAlat, hargaSewa, dan stok. Class ini menerapkan encapsulation melalui atribut private, constructor, getter, setter, serta method tampilInfo().

## Tenda.java
Merupakan turunan dari Alat menggunakan keyword extends. Menambahkan atribut kapasitas dan melakukan overriding terhadap method tampilInfo().

## Carrier.java
Turunan dari Alat dengan atribut volume serta overriding method tampilInfo().

## Penyewa.java
Digunakan untuk menyimpan data penyewa berupa id, nama, dan nomor HP.

## Transaksi.java
Menghubungkan object Penyewa dan Alat, menghitung total pembayaran berdasarkan harga sewa × lama sewa.

## Main.java
Berisi menu aplikasi, Scanner, array object, seleksi, perulangan, object, dan error handling.

# Implementasi Konsep PBO

## 1. Class
Project terdiri dari enam class: Alat, Tenda, Carrier, Penyewa, Transaksi, dan Main.

## 2. Object
```java
Tenda tenda = new Tenda(...);
Carrier carrier = new Carrier(...);
Penyewa penyewa = new Penyewa(...);
Transaksi transaksi = new Transaksi(...);
```
Object digunakan untuk menjalankan proses penyewaan.

## 3. Attribute
```java
private String kodeAlat;
private String namaAlat;
private double hargaSewa;
private int stok;
```
Atribut digunakan untuk menyimpan data setiap objek.

## 4. Constructor
```java
public Alat(String kodeAlat,String namaAlat,double hargaSewa,int stok){ ... }
```
Constructor menginisialisasi nilai awal object.

## 5. Mutator
```java
public void setStok(int stok){ this.stok = stok; }
```
Digunakan untuk mengubah nilai atribut.

## 6. Accessor
```java
public int getStok(){ return stok; }
public double getHargaSewa(){ return hargaSewa; }
```
Digunakan untuk mengambil nilai atribut.

## 7. Encapsulation
Seluruh atribut dibuat `private` sehingga hanya dapat diakses melalui getter dan setter.

## 8. Inheritance
```java
public class Tenda extends Alat
public class Carrier extends Alat
```
Tenda dan Carrier mewarisi atribut dan method dari Alat.

## 9. Polymorphism
```java
@Override
public void tampilInfo(){ ... }
```
Method tampilInfo() dioverride agar informasi setiap alat berbeda.

## 10. Seleksi
Menggunakan `if` untuk validasi stok alat dan lama sewa.

## 11. Perulangan
Menggunakan `for` untuk menampilkan data dan `do-while` untuk menu.

## 12. Input Output
Menggunakan `Scanner` dan `System.out.println()`.

## 13. Array
```java
Alat[] daftarAlat;
Transaksi[] daftarTransaksi;
```
Array digunakan untuk menyimpan banyak object.

## 14. Error Handling
```java
try{
   ...
}catch(Exception e){
   ...
}
```
Menangani kesalahan input agar program tidak berhenti.

# Cara Menjalankan
1. Buka project di NetBeans.
2. Clean and Build.
3. Jalankan Main.java.
4. Gunakan menu aplikasi.

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

- **Nama** : Muhammad Hilman Akhyar
- **NPM** : 2410010155
- **Kelas** : TI 4A Reg. Banjarbaru
