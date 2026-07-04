<<<<<<< HEAD
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
=======
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
>>>>>>> ad8d2e87a87f1a76f6d58c10f2f90c576dc5fb7a
