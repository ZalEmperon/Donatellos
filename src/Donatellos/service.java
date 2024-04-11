package Donatellos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class service {
  // Menampung Produk Donat
  ArrayList<Produk> produkDonat = new ArrayList<>();
  // Menampung Data catatan penjualan donat
  ArrayList<Penjualan> catatJual = new ArrayList<>();
  // Menampung Data catatan pembelian donat
  ArrayList<Pembelian> catatBeli = new ArrayList<>();
  Scanner input = new Scanner(System.in);
  int inputan, harga, jumlah, i, total, waktu;
  String namaProduk, barang, tanggal;

  private Boolean cariTanggal(int tipe, int tanggal1, String tanggal2) {
    // pemformatan dan penyusunan
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate tanggalProduk = LocalDate.parse(tanggal2, format);
    // mendapatkan hari, bulan, tahun dari tanggal yang terformat
    int hari = tanggalProduk.getDayOfMonth();
    int bulan = tanggalProduk.getMonthValue();
    int tahun = tanggalProduk.getYear();
    if (tipe == 1) { // hari
      if (tanggal1 == hari) {
        return true;
      }
    } else if (tipe == 2) { // bulan
      if (tanggal1 == bulan) {
        return true;
      }
    } else if (tipe == 3) { // tahun
      if (tanggal1 == tahun) {
        return true;
      }
    }
    return false;
  }

  public void HitungPenjualan() {
    tampilProduk();
    System.out.print("Pilih Nama Produk   : ");
    inputan = input.nextInt();
    Produk produkDicari = produkDonat.get(inputan - 1);
    namaProduk = produkDicari.getNamaProduk();
    System.out.print("Masukan Jumlah Produk  : ");
    jumlah = input.nextInt();
    input.nextLine();
    System.out.print("Masukan Tanggal Produk [dd-mm-yyyy]\n(0 untuk hari ini) : ");
    tanggal = input.nextLine();
    harga = produkDicari.getHarga() * jumlah;
    // menambah objek Penjualan ke arraylist
    catatJual.add(new Penjualan(namaProduk, jumlah, harga, tanggal));
  }

  public void HitungPembelian() {
    input.nextLine();
    System.out.print("Masukan Nama barang         : ");
    barang = input.nextLine();
    System.out.print("Masukan Jumlah Produk       : ");
    jumlah = input.nextInt();
    System.out.print("Masukan Harga Satuan Produk : ");
    harga = input.nextInt() * jumlah;
    input.nextLine();
    System.out.print("Masukan Tanggal Produk [dd-mm-yyyy]\n(0 untuk hari ini) : ");
    tanggal = input.nextLine();
    // menambah objek Pembelian ke arraylist
    catatBeli.add(new Pembelian(barang, jumlah, harga, tanggal));
  }

  public void cetakPenjualan() {
    total = 0;
    inputan = tipeTanggal();
    System.out.println(inputan);
    if(inputan != 0) {
      System.out.print("Pada Waktu apa : ");
      waktu = input.nextInt();
      System.out.println("== Data Penjualan ==");
      System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Produk", "Jumlah", "Harga", "Tanggal");
      for (Penjualan produkJual : catatJual) { // loop isi objek dari arraylist
        if (cariTanggal(inputan, waktu, produkJual.getTanggal())) {
          System.out.printf("%-15s %-10d %-10d %-10s\n", produkJual.getNamaProduk(),
              produkJual.getJumlah(), produkJual.getharga(), produkJual.getTanggal());
          total += produkJual.getharga();
        }
      }
      System.out.println("Total Harga : Rp " + total);
    }
  }

  public void cetakPembelian() {
    total = 0;
    inputan = tipeTanggal();
    System.out.println(inputan);
    if(inputan != 0) {
      System.out.print("Pada Waktu apa : ");
      waktu = input.nextInt();
      System.out.println("== Data Pembelian ==");
      System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama barang", "Jumlah", "Harga", "Tanggal");
      for (Pembelian barangBeli : catatBeli) { // loop isi objek dari arraylist
        if (cariTanggal(inputan, waktu, barangBeli.getTanggal())) {
          System.out.printf("%-15s %-10d %-10d %-10s\n", barangBeli.getBarang(),
              barangBeli.getJumlah(), barangBeli.getharga(), barangBeli.getTanggal());
          total += barangBeli.getharga();
        }
      }
      System.out.println("Total Harga : Rp " + total);
    }
  }

  public void updatePenjualan(){
    i = 1;
    for (Penjualan produkJual : catatJual){
      System.out.println(i +") "+produkJual.getNamaProduk() +" , "+ produkJual.getJumlah() +" , "+ produkJual.getharga() +" , "+ produkJual.getTanggal());
      i++;
    }
    System.out.print("Pilih Data Produk   : ");
    int inputanan = input.nextInt() - 1;
    input.nextLine();
    tampilProduk();
    System.out.print("Pilih Nama Produk   : ");
    inputan = input.nextInt();
    Produk produkDicari = produkDonat.get(inputan - 1);
    namaProduk = produkDicari.getNamaProduk();
    System.out.print("Masukan Jumlah Produk  : ");
    jumlah = input.nextInt();
    input.nextLine();
    System.out.print("Masukan Tanggal Produk [dd-mm-yyyy]\n(0 untuk hari ini) : ");
    tanggal = input.nextLine();
    harga = produkDicari.getHarga() * jumlah;
    catatJual.get(inputanan).updateProduk(namaProduk, jumlah, harga, tanggal);
  }

  public void updatePembelian(){
    i = 1;
    for (Pembelian barangBeli : catatBeli) {
      System.out.print(i +") "+barangBeli.getBarang() +" , "+ barangBeli.getJumlah() +" , "+ barangBeli.getharga() +" , "+ barangBeli.getTanggal());
      i++;
    }
    System.out.print("Pilih Data Produk   : ");
    int inputanan = input.nextInt() - 1;
    input.nextLine();
    System.out.print("Masukan Nama barang   : ");
    barang = input.nextLine();
    System.out.print("Masukan Jumlah Produk  : ");
    jumlah = input.nextInt();
    System.out.print("Masukan Harga Produk  : ");
    harga = input.nextInt() * jumlah;
    input.nextLine();
    System.out.print("Masukan Tanggal Produk [dd-mm-yyyy]\n(0 untuk hari ini) : ");
    tanggal = input.nextLine();
    catatBeli.get(inputanan).updateBarang(barang, jumlah, harga, tanggal);
  }

  private void tampilProduk(){
    int i = 1;
    for (Produk donat : produkDonat) {
      System.out.println(i + ") " + donat.getNamaProduk());
      i++;
    }
  }
  private int tipeTanggal(){
    System.out.println("1) Harian");
    System.out.println("2) Bulanan");
    System.out.println("3) Tahunan");
    System.out.print("Opsi : ");
    inputan = input.nextInt();
    input.nextLine();
    if (inputan > 3 || inputan < 1) {
      System.out.println("Opsi tidak tersedia!");
    }else{
      return inputan;
    }
    return 0;
  }
}

// interface Innerservice {
//   void HitungPembelian();
//   void HitungPenjualan();
//   void updateProduk();
//   void updateBarang();
//   void cetakPenjualan();
//   void cetakPembelian();
// }