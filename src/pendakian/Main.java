package pendakian;

import java.util.Scanner;

public class Main {

    public static void kembaliKeMenu(Scanner input) {
        System.out.println("\n=========================================");
        System.out.print("Selesai melihat data. Tekan ENTER untuk kembali...");
        input.nextLine();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        JalurPendakian[] daftarGunung = {
            new JalurPendakian("Gunung Halau-Halau", 1901, "Hulu Sungai Tengah", 25000),
            new JalurPendakian("Gunung Hauk", 1325, "Balangan", 20000),
            new JalurPendakian("Gunung Kahung", 1456, "Kabupaten Banjar", 20000),
            new JalurPendakian("Gunung Karungkangan", 1686, "Hulu Sungai Tengah", 22000),
            new JalurPendakian("Bukit Langara", 400, "Hulu Sungai Selatan", 10000)
        };

        RegistrasiPendaki[] riwayatBooking = new RegistrasiPendaki[100];
        int jumlahTransaksi = 0;
        int pilihan = 0;

        do {
            System.out.println("\n=============================================");
            System.out.println("  SISTEM MANAJEMEN PENDAKIAN MERATUS KALSEL  ");
            System.out.println("=============================================");
            System.out.println("1. Lihat Daftar Gunung & Bukit Kalsel");
            System.out.println("2. Cari Gunung Berdasarkan Kabupaten");
            System.out.println("3. Registrasi / Booking Pendakian");
            System.out.println("4. Lihat Riwayat Transaksi Booking");
            System.out.println("5. Cek Rekomendasi Perlengkapan Standar");
            System.out.println("6. Keluar Aplikasi");
            System.out.print("Pilih Menu (1-6): ");

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka pilihan menu!");
                kembaliKeMenu(input);
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR JALUR PENDAKIAN POPULER KALSEL ---");
                    for (int i = 0; i < daftarGunung.length; i++) {
                        System.out.println("[" + (i + 1) + "]");
                        daftarGunung[i].tampilkanInfo();
                        System.out.println("-----------------------------------------");
                    }
                    kembaliKeMenu(input);
                    break;

                case 2:
                    System.out.println("\n--- CARI GUNUNG BERDASARKAN KABUPATEN ---");
                    System.out.print("Masukkan Nama Kabupaten (Contoh: Hulu Sungai Tengah / Balangan): ");
                    String cariLokasi = input.nextLine();
                    boolean ditemukan = false;

                    System.out.println("\nHasil Pencarian di Kabupaten '" + cariLokasi + "':");
                    for (int i = 0; i < daftarGunung.length; i++) {
                        if (daftarGunung[i].getLokasi().equalsIgnoreCase(cariLokasi)) {
                            daftarGunung[i].tampilkanInfo();
                            System.out.println("-----------------------------------------");
                            ditemukan = true;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Tidak ada gunung terdaftar di kabupaten tersebut.");
                    }
                    kembaliKeMenu(input);
                    break;

                case 3:
                    System.out.println("\n--- FORM REGISTRASI PENDAKIAN ---");
                    System.out.print("Masukkan Nama Ketua Kelompok: ");
                    String namaKetua = input.nextLine();

                    System.out.print("Pilih Nomor Gunung (1-" + daftarGunung.length + "): ");
                    int noGunung;
                    try {
                        noGunung = Integer.parseInt(input.nextLine()) - 1;
                        if (noGunung < 0 || noGunung >= daftarGunung.length) {
                            System.out.println("Nomor gunung tidak tersedia!");
                            kembaliKeMenu(input);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Nomor gunung harus berupa angka!");
                        kembaliKeMenu(input);
                        break;
                    }

                    System.out.print("Masukkan Jumlah Anggota Rombongan: ");
                    int jmlPendaki;
                    try {
                        jmlPendaki = Integer.parseInt(input.nextLine());
                        if (jmlPendaki <= 0) {
                            System.out.println("Jumlah pendaki minimal 1 orang!");
                            kembaliKeMenu(input);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Jumlah pendaki harus berupa angka!");
                        kembaliKeMenu(input);
                        break;
                    }

                    JalurPendakian gunungTerpilih = daftarGunung[noGunung];

                    RegistrasiPendaki bookingBaru = new RegistrasiPendaki(
                        gunungTerpilih.getNamaGunung(),
                        gunungTerpilih.getKetinggian(),
                        gunungTerpilih.getLokasi(),
                        gunungTerpilih.getHargaSimaksi(),
                        namaKetua,
                        jmlPendaki
                    );

                    riwayatBooking[jumlahTransaksi] = bookingBaru;
                    jumlahTransaksi++;

                    System.out.println("\n>>> REGISTRASI BERHASIL <<<");
                    System.out.println("Ketua Kelompok : " + bookingBaru.getNamaKetua());
                    System.out.println("Tujuan Pendakian: " + bookingBaru.getNamaGunung());
                    System.out.println("Total Biaya    : Rp " + bookingBaru.hitungTotalBiaya(jmlPendaki) + " (Termasuk Asuransi Wajib)");
                    kembaliKeMenu(input);
                    break;

                case 4:
                    System.out.println("\n--- RIWAYAT TRANSAKSI BOOKING PENDAKIAN ---");
                    if (jumlahTransaksi == 0) {
                        System.out.println("Belum ada transaksi booking saat ini.");
                    } else {
                        for (int i = 0; i < jumlahTransaksi; i++) {
                            System.out.println("Transaksi Ke-" + (i + 1));
                            System.out.println("Nama Ketua     : " + riwayatBooking[i].getNamaKetua());
                            System.out.println("Tujuan Gunung  : " + riwayatBooking[i].getNamaGunung() + " (" + riwayatBooking[i].getLokasi() + ")");
                            System.out.println("Jumlah Rombongan: " + riwayatBooking[i].getJumlahPendaki() + " Orang");
                            System.out.println("Total Bayar    : Rp " + riwayatBooking[i].hitungTotalBiaya(riwayatBooking[i].getJumlahPendaki()));
                            System.out.println("-----------------------------------------");
                        }
                    }
                    kembaliKeMenu(input);
                    break;

                case 5:
                    System.out.println("\n--- CEK REKOMENDASI PERLENGKAPAN STANDAR ---");
                    System.out.print("Masukkan Nama Gunung/Bukit untuk dicek treknya: ");
                    String namaCek = input.nextLine().toLowerCase();
                    boolean gunungValid = false;

                    for (int i = 0; i < daftarGunung.length; i++) {
                        if (daftarGunung[i].getNamaGunung().toLowerCase().contains(namaCek)) {
                            gunungValid = true;
                            System.out.println("\nAnalisis Ketinggian untuk " + daftarGunung[i].getNamaGunung() + ":");
                            
                            if (daftarGunung[i].getKetinggian() > 1500) {
                                System.out.println("Kategori: Trek Ekstrem / Gunung Tinggi (> 1500 mdpl)");
                                System.out.println("Rekomendasi Wajib: Jaket Gunung Tebal (Suhu dingin), Sepatu Tracking Grid Kuat, Tenda Double Layer, Logistik Minimal untuk 3 Hari.");
                            } else if (daftarGunung[i].getKetinggian() > 1000) {
                                System.out.println("Kategori: Trek Sedang (1000 - 1500 mdpl)");
                                System.out.println("Rekomendasi Wajib: Carrier 45L, Jaket Windbreaker, Sepatu Gunung Standard, Logistik 2 Hari.");
                            } else {
                                System.out.println("Kategori: Pendakian Pendek / Wisata Bukit (< 1000 mdpl)");
                                System.out.println("Rekomendasi Wajib: Daypack Kecil, Air Minum Cukup, Pakaian Santai, Alas Kaki Nyaman.");
                            }
                        }
                    }
                    if (!gunungValid) {
                        System.out.println("Nama gunung tidak terdaftar di database sistem.");
                    }
                    break;

                case 6:
                    System.out.println("\nTerima kasih! Salam Lestari, Jaga Kebersihan Gunung Kalsel!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka antara 1 sampai 6.");
                    kembaliKeMenu(input);
            }

        } while (pilihan != 6);

        input.close(); 
    }
}