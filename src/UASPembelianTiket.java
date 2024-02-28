//Deandra Falih Andito
//NIM = V3421032
//Kelas = TIB
//Program = Pembelian Tiket Bioskop

import java.util.Scanner;
public class UASPembelianTiket {
    static Scanner data = new Scanner(System.in);
    public static void main(String[] abc) {
        
        //Variabel
        int kodeT, i, jumlahTransaksi = 0;
        double totalHarga = 0, bayar, kembalian;
        char konfirmasi;
        
        String[] Film = { "Spider-Man", "Real Steel 2", "Pacific Rim 3", "Fast Furious 10", "Dr. Strange" };
        int[] kodeFilm = { 0, 1, 2, 3, 4 };
        double[] hargaTiket = { 40000, 40000, 40000, 40000, 40000 };
        int[] stokKursi = { 30, 20, 25, 10, 15 };
        int[] jumlahBeli = new int[255];
        
        
        //List Film
        System.out.println("============================");
        System.out.println("Selamat Datang di Cinema VVI");
        System.out.println("============================");
        for (i = 0; i < kodeFilm.length; i++) {
            System.out.println(Film[i]);
            System.out.println("Kode Film = " + kodeFilm[i]);
            System.out.println("Harga = " + hargaTiket[i]);
            System.out.println("Sisa Kursi = " + stokKursi[i]);
            System.out.println("     ");
        }
        
        //Transaksi
        i = 0;
        do {
            //Input
            System.out.println("Silahkan Pilih Kode Film yang akan Anda Lihat");
            System.out.print("Masukkan Kode Film = ");
            kodeT = data.nextInt();
            data.nextLine();
            if (kodeT == 1 || kodeT == 2 || kodeT == 3 || kodeT == 0 || kodeT == 4) {
                System.out.print("Jumlah Tiket = ");
                jumlahBeli[i] = data.nextInt();
                data.nextLine();
                
                //Cek Stok Tiket
                if (jumlahBeli[i] <= stokKursi[kodeT]) {
                    stokKursi[kodeT] = stokKursi[kodeT] - jumlahBeli[i];
                    
                    //Proses Hitung Transaksi
                    Film[i] = Film[kodeT];
                    hargaTiket[i] = hargaTiket[kodeT];
                    totalHarga = totalHarga + (hargaTiket[i] * jumlahBeli[i]);
                    jumlahTransaksi++;
                } else {
                    System.out.println("Maaf, jumlah pembelian Anda melebihi stok tiket.");
                }
            } else {
                System.out.println("Maaf kode film yang Anda masukkan salah!");
            }
            //Konfirmasi
            System.out.print("Apakah Anda Ingin Membeli lagi? (ya/tidak) = ");
            konfirmasi = data.next().charAt(0);
            data.nextLine();
            i++;
        } while (konfirmasi == 'y');
        
        // Cetak Struk Pembayaran
        System.out.println("    ");
        System.out.println("=====================================");
        System.out.println("============= Cinema VVI ============");
        System.out.println("=====================================");
        for (i = 0; i <= jumlahTransaksi; i++) {
            if (Film[i] != null && hargaTiket[i] != 0 && jumlahBeli[i] != 0) {
                System.out.println(Film[i] + " : Rp " + hargaTiket[i] + " x " + jumlahBeli[i] + " = Rp "
                        + (hargaTiket[i] * jumlahBeli[i]));
            }
        }
        System.out.println("Total : Rp " + totalHarga);
        
        // Pembayaran
        System.out.print("Pembayaran : Rp ");
        bayar = data.nextDouble();
        data.nextLine();
        if (bayar < totalHarga) {
            System.out.println("Maaf uang Anda kurang!");
        } else {
            kembalian = bayar - totalHarga;
            System.out.println("Kembali : Rp " + kembalian);
        }
        System.out.println("  ");
        System.out.println("Terima Kasih atas Pembelian Anda dan Selamat Menonton!");
        System.out.println("  ");
    }
}