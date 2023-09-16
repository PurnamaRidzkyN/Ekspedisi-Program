import java.util.Scanner;

public class pengiriman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input data pengirim
        System.out.print("Masukkan nama pengirim: ");
        String namaPengirim = sc.nextLine();
        System.out.print("Masukkan nama penerima: ");
        String namaPenerima = sc.nextLine();
        System.out.print("Masukkan alamat pengirim: ");
        String alamatPengirim = sc.nextLine();    
        System.out.print("Masukkan alamat penerima: ");
        String alamatPenerima = sc.nextLine();
        

        // Proses penghitungan biaya pengiriman
        double beratPaket;
        System.out.println("Berat paket =");
        beratPaket = sc.nextDouble();

        double jarakPengiriman;

        System.out.println("Jarak Pengiriman =");
        jarakPengiriman = sc.nextDouble();
        double biayaPengiriman = beratPaket * 12000 + jarakPengiriman * 5000; 

        // Output hasil pengiriman
        System.out.println("Nama pengirim: " + namaPengirim);
        System.out.println("Nama penerima: " + namaPenerima);
        System.out.println("Alamat pengirim: " + alamatPengirim);
        System.out.println("Alamat penerima: " + alamatPenerima);
        System.out.println("Biaya pengiriman: " + biayaPengiriman);
        System.out.println("Apakah anda ingin melanjukan pengiriman?");

    }

}



