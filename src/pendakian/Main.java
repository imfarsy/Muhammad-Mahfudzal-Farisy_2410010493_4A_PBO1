package pendakian;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        //array objek data gunung
        JalurPendakian[] daftarGunung = {
            new JalurPendakian("Gunung Halau-Halau", 1901, "Hulu Sungai Tengah", 25000),
            new JalurPendakian("Gunung Kahung", 1246, "Banjar", 20000),
            new JalurPendakian("Bukit Batu", 150, "Banjar", 10000),
            new JalurPendakian("Bukit Birah", 320, "Tanah Laut", 10000),
            new JalurPendakian("Bukit Matang Kaladan", 120, "Banjar", 15000)
        };

        //array transaksi
        RegistrasiPendaki[] riwayatBooking = new RegistrasiPendaki[100];
        int jumlahTransaksi = 0;

        int pilihan = 0;

        //perulangan
        do {
            System.out.println("=== SISTEM REGISTRASI PENDAKIAN MERATUS HIKING ===");
            System.out.println("1. Lihat Daftar Jalur & Gunung (Kalsel)");
            System.out.println("2. Cari Gunung Berdasarkan Kabupaten");
            System.out.println("3. Booking Jalur/Registrasi Kelompok");
            System.out.println("4. Lihat Riwayat Pendaftaran");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih Menu (1-5): ");

            //error handling
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka valid!\n");
                continue;
            }

            System.out.println();

            //strutktur seleksi
            switch (pilihan) {
                case 1:
                    System.out.println("--- DAFTAR JALUR PENDAKIAN MASTER DATA ---");
                    for (int i = 0; i < daftarGunung.length; i++) {
                        System.out.println("[" + (i + 1) + "]");
                        daftarGunung[i].tampilInfo();
                        System.out.println("------------------------------------------");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama Kabupaten di Kalsel (contoh: Banjar/Tanah Laut): ");
                    String cariLokasi = input.nextLine();
                    System.out.println("\nHasil Pencarian Gunung di Wilayah: " + cariLokasi);
                    boolean ditemukan = false;

                    for (JalurPendakian g : daftarGunung) {
                        if (g.getLokasi().equalsIgnoreCase(cariLokasi) || g.getLokasi().toLowerCase().contains(cariLokasi.toLowerCase())) {
                            g.tampilInfo();
                            System.out.println("------------------------------------------");
                            ditemukan = true;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Maaf, belum ada data jalur pendakian terdaftar di kabupaten tersebut.");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("--- FORM REGISTRASI BOOKING GRUP ---");
                    System.out.print("Masukkan Nama Ketua Kelompok : ");
                    String namaKetua = input.nextLine();

                    int jmlGrup = 0;
                    //loop jmlh anggota
                    while (true) {
                        System.out.print("Masukkan Jumlah Anggota Rombongan: ");
                        try {
                            jmlGrup = Integer.parseInt(input.nextLine());
                            if (jmlGrup <= 0) {
                                System.out.println("[!] Jumlah pendaki harus minimal 1 orang.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("[ERROR] Harap masukkan input angka kuantitas yang benar!");
                        }
                    }

                    System.out.println("\nPilih Gunung Tujuan Pendaftaran:");
                    for (int i = 0; i < daftarGunung.length; i++) {
                        System.out.println((i + 1) + ". " + daftarGunung[i].getNamaGunung() + " (" + daftarGunung[i].getKetinggian() + " MDPL)");
                    }
                    
                    int nomorGunung = 0;
                    while (true) {
                        System.out.print("Pilih Nomor Gunung (1-" + daftarGunung.length + "): ");
                        try {
                            nomorGunung = Integer.parseInt(input.nextLine());
                            if (nomorGunung < 1 || nomorGunung > daftarGunung.length) {
                                System.out.println("[!] Nomor pilihan di luar rentang daftar.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("[ERROR] Masukkan angka pilihan yang valid!");
                        }
                    }

                    //data objek gunung
                    JalurPendakian terpilih = daftarGunung[nomorGunung - 1];

                    //instansiasi
                    riwayatBooking[jumlahTransaksi] = new RegistrasiPendaki(
                        terpilih.getNamaGunung(),
                        terpilih.getKetinggian(),
                        terpilih.getLokasi(),
                        terpilih.getHargaSimaksi(),
                        namaKetua,
                        jmlGrup
                    );

                    System.out.println("\n[SUKSES] Registrasi pendakian berhasil dibuat!");
                    riwayatBooking[jumlahTransaksi].tampilInfo();
                    jumlahTransaksi++;
                    break;

                case 4:
                    System.out.println("--- RIWAYAT SELURUH TRANSAKSI BOOKING ---");
                    if (jumlahTransaksi == 0) {
                        System.out.println("Belum ada data pendaftaran yang tersimpan di sesi ini.\n");
                    } else {
                        for (int i = 0; i < jumlahTransaksi; i++) {
                            System.out.println("No. Antrian Transaksi: #" + (i + 1001));
                            riwayatBooking[i].tampilInfo();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem MeratusHiking. Salam Lestari!");
                    break;

                default:
                    System.out.println("[!] Menu pilihan tidak tersedia. Silakan ulangi.\n");
            }

        } while (pilihan != 5);
        
        input.close();
    }
}