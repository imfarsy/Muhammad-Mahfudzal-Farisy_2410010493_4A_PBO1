package pendakian;

//inheritance
public class RegistrasiPendaki extends JalurPendakian {
    private String namaKetua;
    private int jumlahPendaki;

    //constructor child class
    public RegistrasiPendaki(String namaGunung, int ketinggian, String lokasi, double hargaSimaksi, String namaKetua, int jumlahPendaki) {
        super(namaGunung, ketinggian, lokasi, hargaSimaksi);
        this.namaKetua = namaKetua;
        this.jumlahPendaki = jumlahPendaki;
    }

    //getter and setter
    public String getNamaKetua() { return namaKetua; }
    public int getJumlahPendaki() { return jumlahPendaki; }

    //polymorphism
    @Override
    public double hitungTotalBiaya(int jumlahPendaki) {
        double biayaAsuransiWajib = 5000 * jumlahPendaki;
        return super.hitungTotalBiaya(jumlahPendaki) + biayaAsuransiWajib; 
    }
}
