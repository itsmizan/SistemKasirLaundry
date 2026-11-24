package sistemkasirlaundry.model;

import java.util.List;
import sistemkasirlaundry.data.DataStore;

public class Layanan {
    private int idLayanan;
    private String namaLayanan;
    private double hargaPerKg;
    private int estimasiHari;

    public Layanan(int idLayanan, String namaLayanan, double hargaPerKg, int estimasiHari) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaPerKg = hargaPerKg;
        this.estimasiHari = estimasiHari;
    }

    public void tambahLayanan() {
        DataStore.getDaftarLayanan().add(this);
    }

    public void ubahLayanan() {
        List<Layanan> daftar = DataStore.getDaftarLayanan();
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getIdLayanan() == idLayanan) {
                daftar.set(i, this);
                return;
            }
        }
    }

    public void hapusLayanan() {
        DataStore.getDaftarLayanan().removeIf(l -> l.getIdLayanan() == idLayanan);
    }

    public int getIdLayanan() { return idLayanan; }
    public void setIdLayanan(int idLayanan) { this.idLayanan = idLayanan; }
    public String getNamaLayanan() { return namaLayanan; }
    public void setNamaLayanan(String namaLayanan) { this.namaLayanan = namaLayanan; }
    public double getHargaPerKg() { return hargaPerKg; }
    public void setHargaPerKg(double hargaPerKg) { this.hargaPerKg = hargaPerKg; }
    public int getEstimasiHari() { return estimasiHari; }
    public void setEstimasiHari(int estimasiHari) { this.estimasiHari = estimasiHari; }

    @Override
    public String toString() {
        return namaLayanan + " (Rp " + String.format("%,.0f", hargaPerKg) + "/kg)";
    }
}
