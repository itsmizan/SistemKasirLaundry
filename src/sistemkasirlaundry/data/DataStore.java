package sistemkasirlaundry.data;

import java.util.ArrayList;
import java.util.List;
import sistemkasirlaundry.model.Admin;
import sistemkasirlaundry.model.Layanan;
import sistemkasirlaundry.model.Pelanggan;
import sistemkasirlaundry.model.Transaksi;

/**
 * Penyimpanan data sementara di memori (hilang saat aplikasi ditutup).
 * Nantinya bisa diganti dengan koneksi database MySQL.
 */
public class DataStore {
    private static final List<Admin> daftarAdmin = new ArrayList<>();
    private static final List<Pelanggan> daftarPelanggan = new ArrayList<>();
    private static final List<Layanan> daftarLayanan = new ArrayList<>();
    private static final List<Transaksi> daftarTransaksi = new ArrayList<>();
    private static Admin adminAktif;

    static {
        daftarAdmin.add(new Admin(1, "Administrator", "admin", "admin123"));
        daftarLayanan.add(new Layanan(1, "Cuci Kering", 6000, 2));
        daftarLayanan.add(new Layanan(2, "Cuci Setrika", 8000, 3));
        daftarLayanan.add(new Layanan(3, "Setrika Saja", 5000, 1));
        daftarPelanggan.add(new Pelanggan(1, "Budi Santoso", "081234567890", "Jl. Merdeka No. 10"));
    }

    public static List<Admin> getDaftarAdmin() { return daftarAdmin; }
    public static List<Pelanggan> getDaftarPelanggan() { return daftarPelanggan; }
    public static List<Layanan> getDaftarLayanan() { return daftarLayanan; }
    public static List<Transaksi> getDaftarTransaksi() { return daftarTransaksi; }
    public static Admin getAdminAktif() { return adminAktif; }
    public static void setAdminAktif(Admin admin) { adminAktif = admin; }

    public static int idPelangganBaru() {
        int max = 0;
        for (Pelanggan p : daftarPelanggan) max = Math.max(max, p.getIdPelanggan());
        return max + 1;
    }

    public static int idLayananBaru() {
        int max = 0;
        for (Layanan l : daftarLayanan) max = Math.max(max, l.getIdLayanan());
        return max + 1;
    }

    public static int idTransaksiBaru() {
        return daftarTransaksi.size() + 1;
    }
}
