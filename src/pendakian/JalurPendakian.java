package pendakian;

public class JalurPendakian {

    //atribut (encapsulation)
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

    //mutator
    public void setNamaGunung(String namaGunung) { this.namaGunung = namaGunung; }
    public void setKetinggian(int ketinggian) { this.ketinggian = ketinggian; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public void setHargaSimaksi(double hargaSimaksi) { this.hargaSimaksi = hargaSimaksi; }

    //accessor
    public String getNamaGunung() { return namaGunung; }
    public int getKetinggian() { return ketinggian; }
    public String getLokasi() { return lokasi; }
    public double getHargaSimaksi() { return hargaSimaksi; }

    //polymorphism
    public double hitungTotalBiaya(int jumlahPendaki) {
        return this.hargaSimaksi * jumlahPendaki;
    }
    
    //metode info gunung
    public void tampilkanInfo() {
        System.out.println("Gunung/Bukit : " + namaGunung + " (" + ketinggian + " mdpl)");
        System.out.println("Lokasi       : " + lokasi);
        System.out.println("Tarif SIMAKSI: Rp " + hargaSimaksi + " /orang");
    }
}

