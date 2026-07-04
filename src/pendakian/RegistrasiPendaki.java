package pendakian;

//inheritance
public class RegistrasiPendaki extends JalurPendakian {

    private String namaKetua;
    private int jumlahPendaki;
    private final double ASURANSI_PER_ORANG = 5000.0;

    //constructor
    public RegistrasiPendaki(String namaGunung, int ketinggian, String lokasi, double hargaSimaksi, 
                             String namaKetua, int jumlahPendaki) {
        super(namaGunung, ketinggian, lokasi, hargaSimaksi);
        this.namaKetua = namaKetua;
        this.jumlahPendaki = jumlahPendaki;
    }

    //overriding
    @Override
    public double hitungTotalBiaya(int jumlahPendaki) {
        double biayaSimaksiMurni = super.hitungTotalBiaya(jumlahPendaki);
        double totalAsuransi = ASURANSI_PER_ORANG * jumlahPendaki;
        return biayaSimaksiMurni + totalAsuransi;
    }

    // overriding tampilInfo()
    @Override
    public void tampilInfo() {
        System.out.println("==========================================");
        System.out.println("       NOTA REGISTRASI SIMAKSI MERATUS    ");
        System.out.println("==========================================");
        System.out.println("Nama Ketua Kelompok : " + namaKetua);
        System.out.println("Jumlah Anggota/Grup : " + jumlahPendaki + " orang");
        super.tampilInfo();
        System.out.println("Tambahan Asuransi   : Rp " + (ASURANSI_PER_ORANG * jumlahPendaki) + " (Rp 5.000 / org)");
        System.out.println("------------------------------------------");
        System.out.println("TOTAL BAYAR SIMAKSI : Rp " + hitungTotalBiaya(this.jumlahPendaki));
        
        System.out.print("Rekomendasi Alat    : ");
        if (getKetinggian() >= 1000) {
            System.out.println("Wajib membawa Tenda Dome, Carrier min 60L, Sleeping Bag tebal, & Jaket Windproof.");
        } else {
            System.out.println("Cukup membawa Tenda Kapasitas Kecil, Daypack, Masker Debu, & Sepatu Grip Standar.");
        }
        System.out.println("==========================================\n");
    }

    //getter dan setter
    public String getNamaKetua() { return namaKetua; }
    public void setNamaKetua(String namaKetua) { this.namaKetua = namaKetua; }

    public int getJumlahPendaki() { return jumlahPendaki; }
    public void setJumlahPendaki(int jumlahPendaki) { this.jumlahPendaki = jumlahPendaki; }
}