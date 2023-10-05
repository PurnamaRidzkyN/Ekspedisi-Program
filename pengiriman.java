import java.util.Scanner;

public class pengiriman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        // Proses login
        System.out.print("Masukkan nama pengguna: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan kata sandi: ");
        String password = scanner.nextLine();

        if (username.equals("purnama") && password.equals("saya bos")) {
            System.out.println("Login berhasil!");

            // Menampilkan pilihan setelah login berhasil
            System.out.println("Pilih tindakan:");
            System.out.println("1. Mengirim paket");
            System.out.println("2. Melacak paket");
            System.out.println("3. Riwayat pembelian");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            

            switch (choice) {
                case 1:
                    // Pilihan 1: Mengirim paket
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
                    System.out.println("Berat paket (gram): ");
                    beratPaket = sc.nextDouble();
                    double jarakPengiriman;
                    System.out.println("Jarak Pengiriman (km): ");
                    jarakPengiriman = sc.nextDouble();
                    double panjang, lebar, tinggi;
                    System.out.println("Panjang (cm): ");
                    panjang = sc.nextDouble();
                    System.out.println("Lebar (cm): ");
                    lebar = sc.nextDouble();
                    System.out.println("Tinggi (cm): ");
                    tinggi = sc.nextDouble();
                    double biayaPengiriman = beratPaket * 10 + jarakPengiriman * 5 + panjang * 5 + lebar * 5 + tinggi * 5;

                    //Layanan Pengiriman
                    System.out.println("Pilih layanan pengiriman yang digunakan");
                    System.out.println("1. Reguler");
                    System.out.println("2. Express");
                    System.out.println("Pilih dengan memasukan angka sesuai pilihan");
                    int layanan = scanner.nextInt();
                    double dimensi = panjang * lebar * tinggi;
                    double diskon = 0;

                    
                    if (layanan==1){
                    if (jarakPengiriman > 1000) {
                        if (beratPaket < 2000) {
                            if (dimensi < 600) {
                                diskon = 3*0.05;
                            } else {
                                diskon = 2*0.05;
                            }
                        } else {
                            diskon = 0.05;
                        }
                    } 
                    } else {
                        biayaPengiriman = biayaPengiriman + biayaPengiriman * 50/100;
                    } 
                    biayaPengiriman = biayaPengiriman - (biayaPengiriman * diskon);
                    System.out.println("Nama pengirim: " + namaPengirim);
                    System.out.println("Nama penerima: " + namaPenerima);
                    System.out.println("Alamat pengirim: " + alamatPengirim);
                    System.out.println("Alamat penerima: " + alamatPenerima);
                    System.out.println("Biaya pengiriman: " + biayaPengiriman );
                    System.out.println("Diskon yang di dapat : " + diskon);

                    System.out.println("Apakah anda ingin melanjutkan pengiriman? \n 1. Iya \n 2.Tidak");
                    int lanjut = scanner.nextInt();
                    
                    if (lanjut==1) {
                        System.out.println("Transaksi berhasil ");

                        //Menampilkan Resi
                        if (layanan==1){
                            System.out.println("Pengirim : " + namaPengirim);
                            System.out.println("Penerima : " + namaPenerima);
                            System.out.println("Tujuan : " + alamatPenerima);
                            System.out.println("Keterangan : " +beratPaket+" gram "+jarakPengiriman+" km");
                            System.out.println("Biaya : " + biayaPengiriman);
                            System.out.println("No Resi : RGL01"+jarakPengiriman+beratPaket );
                            
                        } else {
                            double biayaPengiriman1 = biayaPengiriman + biayaPengiriman * 50/100;
                            System.out.println("Pengirim : " + namaPengirim);
                            System.out.println("Penerima : " + namaPenerima);
                            System.out.println("Tujuan : " + alamatPenerima);
                            System.out.println("Keterangan : " +beratPaket+" gram "+jarakPengiriman+" km");
                            System.out.println("Biaya : " + biayaPengiriman1);
                            System.out.println("No Resi : EXR02"+jarakPengiriman+beratPaket );
                        }
                        
                    } else {
                        System.out.println("Transaksi gagal");
                    }
                    break;
                    
                case 2:
                    
                  
                
                    break;
                case 3:
                    // Pilihan 3: Riwayat pembelian
                    
                    
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } else {
            System.out.println("Login gagal. Nama pengguna atau kata sandi salah.");
        }
    }
}
