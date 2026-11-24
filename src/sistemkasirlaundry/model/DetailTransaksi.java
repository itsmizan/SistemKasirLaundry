package sistemkasirlaundry.model;

public class DetailTransaksi {
    private int idDetail;
    private Layanan layanan;
    private double berat;
    private double subtotal;

    public DetailTransaksi(int idDetail, Layanan layanan, double berat) {
        this.idDetail = idDetail;
        this.layanan = layanan;
        this.berat = berat;
        hitungSubtotal();
    }

    public double hitungSubtotal() {
        subtotal = layanan.getHargaPerKg() * berat;
        return subtotal;
    }

    public int getIdDetail() { return idDetail; }
    public void setIdDetail(int idDetail) { this.idDetail = idDetail; }
    public Layanan getLayanan() { return layanan; }
    public void setLayanan(Layanan layanan) { this.layanan = layanan; hitungSubtotal(); }
    public double getBerat() { return berat; }
    public void setBerat(double berat) { this.berat = berat; hitungSubtotal(); }
    public double getSubtotal() { return subtotal; }
}
