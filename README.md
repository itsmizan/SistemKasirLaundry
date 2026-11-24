# Sistem Kasir Laundry

Aplikasi kasir laundry berbasis **Java Swing** dengan arsitektur sederhana: model, penyimpanan data, dan form GUI (NetBeans `.form`).

## Fitur

- Login admin
- Manajemen pelanggan (tambah, ubah, hapus)
- Manajemen layanan / harga cuci (tambah, ubah, hapus)
- Transaksi dengan detail layanan, berat, dan perhitungan total
- Menu utama dengan navigasi ke seluruh form

Login contoh: `admin` / `admin123`.

## Struktur

```
src/sistemkasirlaundry/
├── SistemKasirLaundry.java   # entry point
├── data/DataStore.java       # penyimpanan data di memori
├── model/                    # Admin, Pelanggan, Layanan, Transaksi, DetailTransaksi
└── view/                     # FormLogin, FormMenuUtama, FormPelanggan, FormLayanan, FormTransaksi
```

Data masih disimpan sementara di memori, jadi akan hilang saat aplikasi ditutup.

## Menjalankan

Butuh JDK 8 atau lebih baru.

```bash
javac -d out $(find src -name "*.java")
java -cp out sistemkasirlaundry.SistemKasirLaundry
```

Proyek ini juga bisa dibuka langsung di NetBeans IDE karena file `.form` disertakan.
