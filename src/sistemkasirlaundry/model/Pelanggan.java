package sistemkasirlaundry.model;

import java.util.ArrayList;
import java.util.List;
import sistemkasirlaundry.data.DataStore;

public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String noHp;
    private String alamat;

    public Pelanggan(int idPelanggan, String nama, String noHp, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public void tambahPelanggan() {
        DataStore.getDaftarPelanggan().add(this);
    }

    /** Mengganti data pelanggan yang ID-nya sama dengan objek ini. */
    public void ubahPelanggan() {
        List<Pelanggan> daftar = DataStore.getDaftarPelanggan();
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getIdPelanggan() == idPelanggan) {
                daftar.set(i, this);
                return;
            }
        }
    }

    public void hapusPelanggan() {
        DataStore.getDaftarPelanggan().removeIf(p -> p.getIdPelanggan() == idPelanggan);
    }

    /** Mencari pelanggan berdasarkan nama atau nomor HP. */
    public static List<Pelanggan> cariPelanggan(String keyword) {
        List<Pelanggan> hasil = new ArrayList<>();
        String kunci = keyword.toLowerCase();
        for (Pelanggan p : DataStore.getDaftarPelanggan()) {
            if (p.getNama().toLowerCase().contains(kunci) || p.getNoHp().contains(kunci)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public int getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(int idPelanggan) { this.idPelanggan = idPelanggan; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    @Override
    public String toString() {
        return idPelanggan + " - " + nama;
    }
}
