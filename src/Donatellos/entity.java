package Donatellos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// Kelas Manage menerapkan Enkapsulasi
class Produk {
  private String namaProduk;
  private int harga;
  public Produk(String namaProduk, int harga) {
    setNamaProduk(namaProduk);
    setHarga(harga);
  }
  public String getNamaProduk() {
    return namaProduk;
  }
  public int getHarga() {
    return harga;
  }
  private void setNamaProduk(String namaProduk) {
    this.namaProduk = namaProduk;
  }
  private void setHarga(int harga) {
    this.harga = harga;
  }
}

abstract class Transaksi {
  protected String tanggal;
  protected int jumlah, harga;
  public Transaksi(int jumlah, int harga, String tanggal) {
    setJumlah(jumlah);
    setharga(harga);
    // jika isi tanggal = 0 maka set tanggal menjadi hari ini
    if (tanggal.equals("0")) {
      setTanggal();
    } else { // jika tidak maka set tanggal menjadi tanggal masukan
      this.tanggal = tanggal;
    }
  }
  public int getJumlah() {
    return jumlah;
  }
  public int getharga() {
    return harga;
  }
  public String getTanggal() {
    return tanggal;
  }
  protected void setJumlah(int jumlah) {
    this.jumlah = jumlah;
  }
  protected void setharga(int harga) {
    this.harga = harga;
  }
  protected void setTanggal() { // mendapatkan tanggal hari ini lalu set
    LocalDate waktuSekarang = LocalDate.now();
    DateTimeFormatter tanggal = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String waktuTerformat = waktuSekarang.format(tanggal);
    this.tanggal = waktuTerformat;
  }
}

class Pembelian extends Transaksi{
  protected String barang;
  public Pembelian(String barang, int jumlah, int harga, String tanggal) {
    super(jumlah, harga, tanggal);
    setBarang(barang);
  }
  public String getBarang() {
    return barang;
  }
  protected void setBarang(String barang) {
    this.barang = barang;
  }
  public void updateBarang(String barang, int jumlah, int harga, String tanggal){
    setBarang(barang);
    setJumlah(jumlah);
    setharga(harga);
    if (tanggal.equals("0")) { setTanggal();
    } else { this.tanggal = tanggal;
    }
  }
}

class Penjualan extends Transaksi{
  protected String namaProduk;
  public Penjualan(String namaProduk, int jumlah, int harga, String tanggal) {
    super(jumlah, harga, tanggal);
    setNamaProduk(namaProduk);
  }
  public String getNamaProduk() {
    return namaProduk;
  }
  protected void setNamaProduk(String namaProduk) {
    this.namaProduk = namaProduk;
  }
  public void updateProduk(String barang, int jumlah, int harga, String tanggal){
    setNamaProduk(barang);
    setJumlah(jumlah);
    setharga(harga);
    if (tanggal.equals("0")) { setTanggal();
    } else { this.tanggal = tanggal;
    }
  }
}
