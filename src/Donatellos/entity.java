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
  protected int jumlah;
  protected double harga;
  public Transaksi(int jumlah, double harga, String tanggal) {
    setJumlah(jumlah);
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
  public double getharga() {
    return harga;
  }
  public String getTanggal() {
    return tanggal;
  }
  protected void setJumlah(int jumlah) {
    this.jumlah = jumlah;
  }
  protected abstract void setharga(double harga);
  protected void setTanggal() { // mendapatkan tanggal hari ini lalu set
    LocalDate waktuSekarang = LocalDate.now();
    DateTimeFormatter tanggal = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String waktuTerformat = waktuSekarang.format(tanggal);
    this.tanggal = waktuTerformat;
  }
}

class Pembelian extends Transaksi{
  protected String barang;
  public Pembelian(String barang, int jumlah, double harga, String tanggal) {
    super(jumlah, harga, tanggal);
    setBarang(barang);
    setharga(harga);
  }
  @Override
  protected void setharga(double harga) {
    this.harga = harga;
  }
  public String getBarang() {
    return barang;
  }
  protected void setBarang(String barang) {
    this.barang = barang;
  }
  public void updateBarang(String barang, int jumlah, double harga, String tanggal){
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
  protected double diskon;
  public Penjualan(String namaProduk, int jumlah, double harga, double diskon, String tanggal) {
    super(jumlah, harga, tanggal);
    setDiskon(diskon);
    setNamaProduk(namaProduk);
    setharga(harga, diskon);
  }
  @Override
  protected void setharga(double harga) {
    this.harga = harga;
  }

  protected void setDiskon(double diskon){
    this.diskon = diskon;
  }

  protected void setharga(double harga, double diskon) {
    this.harga = harga - (harga*(diskon/100));
  }
  public String getNamaProduk() {
    return namaProduk;
  }
  protected void setNamaProduk(String namaProduk) {
    this.namaProduk = namaProduk;
  }
  protected double getDiskon(){
    return diskon;
  }
  public void updateProduk(String barang, int jumlah, double harga, String tanggal){
    setNamaProduk(barang);
    setJumlah(jumlah);
    setharga(harga);
    if (tanggal.equals("0")) { setTanggal();
    } else { this.tanggal = tanggal;
    }
  }
}