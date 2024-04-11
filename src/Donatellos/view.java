package Donatellos;

import java.util.Scanner;

public class view {
  private service fungsiProduct;
  public view(service LayananMain) {
    this.fungsiProduct = LayananMain;
  }
  // Nilai Default objek untuk produk donat
  public void viewStart() {
    fungsiProduct.produkDonat.add(new Produk("Donat Cokelat", 6000));
    fungsiProduct.produkDonat.add(new Produk("Donat Matcha", 8000));
    fungsiProduct.produkDonat.add(new Produk("Donat Keju", 7000));
    Scanner input = new Scanner(System.in);
    int inputan;
    do {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("== Menu Donatan ==");
      System.out.println("1) Masukan Data Penjualan");
      System.out.println("2) Masukan Data Pembelian");
      System.out.println("3) Update Data Penjualan");
      System.out.println("4) Update Data Pembelian");
      System.out.println("5) Lihat Penjualan");
      System.out.println("6) Lihat Pembelian");
      System.out.println("0) Keluar");
      System.out.print("Opsi : ");
      inputan = input.nextInt();
      input.nextLine();
      switch (inputan) {
        case 1: fungsiProduct.HitungPenjualan(); break;
        case 2: fungsiProduct.HitungPembelian(); break;
        case 3: fungsiProduct.updatePenjualan(); break;
        case 4: fungsiProduct.updatePembelian(); break;
        case 5: fungsiProduct.cetakPenjualan(); break;
        case 6:fungsiProduct.cetakPembelian(); break;
        default:
          System.out.println("Bye Bye");
          System.exit(0);
      }
      System.out.print("Masukan 1 untuk mengulang... ");
      inputan = input.nextInt();
    } while (inputan != 0);
    input.close();
  }
}
