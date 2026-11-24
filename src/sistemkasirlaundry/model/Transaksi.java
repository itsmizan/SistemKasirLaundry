package sistemkasirlaundry.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sistemkasirlaundry.data.DataStore;

public class Transaksi {
    private int idTransaksi;
    private Date tanggalMasuk;
    private Date tanggalSelesai;
    private double totalBayar;
    private String statusBayar;
    private Admin admin;
    private Pelanggan pelanggan;
    private final List<DetailTransaksi> daftarDetail = new ArrayList<>();

    public Transaksi(int idTransaksi, Admin admin, Pelanggan pelanggan) {
        this.idTransaksi = idTransaksi;
        this.admin = admin;
        this.pelanggan = pelanggan;
        this.tanggalMasuk = new Date();
        this.statusBayar = "Belum Lunas";
    }

    public void tambahDetail(DetailTransaksi detail) {
        daftarDetail.add(detail);
        hitungTotal();
    }

    public void hapusDetail(DetailTransaksi detail) {
        daftarDetail.remove(detail);
        hitungTotal();
    }

    /** Menjumlahkan subtotal dan menghitung tanggal selesai dari estimasi layanan terlama. */
    public double hitungTotal() {
        totalBayar = 0;
        int estimasiTerlama = 0;
        for (DetailTransaksi d : daftarDetail) {
            totalBayar += d.getSubtotal();
            estimasiTerlama = Math.max(estimasiTerlama, d.getLayanan().getEstimasiHari());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(tanggalMasuk);
        cal.add(Calendar.DAY_OF_MONTH, estimasiTerlama);
        tanggalSelesai = cal.getTime();
        return totalBayar;
    }

    public void simpanTransaksi() {
        hitungTotal();
        DataStore.getDaftarTransaksi().add(this);
    }

    /** Membuat teks nota yang siap ditampilkan atau dicetak. */
    public String cetakNota() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("========= NOTA LAUNDRY =========\n");
        sb.append("No. Transaksi : ").append(idTransaksi).append('\n');
        sb.append("Pelanggan     : ").append(pelanggan.getNama()).append('\n');
        sb.append("Kasir         : ").append(admin.getNama()).append('\n');
        sb.append("Tgl Masuk     : ").append(fmt.format(tanggalMasuk)).append('\n');
        sb.append("Tgl Selesai   : ").append(fmt.format(tanggalSelesai)).append('\n');
        sb.append("--------------------------------\n");
        for (DetailTransaksi d : daftarDetail) {
            sb.append(String.format("%-16s %5.1f kg%n", d.getLayanan().getNamaLayanan(), d.getBerat()));
            sb.append(String.format("%32s%n", "Rp " + String.format("%,.0f", d.getSubtotal())));
        }
        sb.append("--------------------------------\n");
        sb.append(String.format("TOTAL  : Rp %,.0f%n", totalBayar));
        sb.append("Status : ").append(statusBayar).append('\n');
        sb.append("================================");
        return sb.toString();
    }

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public Date getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(Date tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
    public Date getTanggalSelesai() { return tanggalSelesai; }
    public double getTotalBayar() { return totalBayar; }
    public String getStatusBayar() { return statusBayar; }
    public void setStatusBayar(String statusBayar) { this.statusBayar = statusBayar; }
    public Admin getAdmin() { return admin; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }
    public List<DetailTransaksi> getDaftarDetail() { return daftarDetail; }
}
