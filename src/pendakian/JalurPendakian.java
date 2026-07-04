package pendakian;

public class JalurPendakian {

    //atribut(encapsulation)
    private String namaGunung;
    private int ketinggian;
    private String lokasi;
    private double hargaSimaksi;

    //constructor
    public JalurPendakian(String namaGunung, int ketinggian, String lokasi, double hargaSimaksi) {
        this.namaGunung = namaGunung;
        this.ketinggian = ketinggian;
        this.lokasi = lokasi;
        this.hargaSimaksi = hargaSimaksi;
    }

    //polimorfisme
    public double hitungTotalBiaya(int jumlahPendaki) {
        return this.hargaSimaksi * jumlahPendaki;
    }

    //method info gunung
    public void tampilInfo() {
        System.out.println("Nama Gunung/Bukit : " + namaGunung);
        System.out.println("Ketinggian        : " + ketinggian + " MDPL");
        System.out.println("Lokasi Kabupaten  : " + lokasi);
        System.out.println("Tarif SIMAKSI/org : Rp " + hargaSimaksi);
    }

    //getter dan setter (mutator and accessor)
    public String getNamaGunung() { return namaGunung; }
    public void setNamaGunung(String namaGunung) { this.namaGunung = namaGunung; }

    public int getKetinggian() { return ketinggian; }
    public void setKetinggian(int ketinggian) { this.ketinggian = ketinggian; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public double getHargaSimaksi() { return hargaSimaksi; }
    public void setHargaSimaksi(double hargaSimaksi) { this.hargaSimaksi = hargaSimaksi; }
}