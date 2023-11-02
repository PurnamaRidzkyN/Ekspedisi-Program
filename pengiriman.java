import java.util.Scanner;

public class pengiriman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;

        // Array dalam Login
        String[] username = {"admin", "adm"};
        String[] password = {"oke", "betul"};

        do {
            System.out.println("Akun yang Anda masukkan akan menampilkan pekerjaan Anda");
            System.out.print("Masukkan nama pengguna: ");
            String user = scanner.nextLine();
            System.out.print("Masukkan kata sandi: ");
            String pass = scanner.nextLine();

            boolean loginBerhasil = false;

            for (int i = 0; i < username.length; i++) {
                if (user.equalsIgnoreCase(username[i]) && pass.equals(password[i])) {
                    System.out.println("Login berhasil!");
                    loginBerhasil = true;
                    break;
                }
            }

            if (loginBerhasil) {
                while (true) {
                 double [][] dataPaket = new double[4][];
                 String [][] dataPengiriman = new String[7][]; 

                    System.out.println("Pilih tindakan:");
                    System.out.println("1. Mengirim paket");
                    System.out.println("2. Melacak paket");
                    System.out.println("3. Riwayat pembelian");
                    System.out.println("4. Keluar");
                    System.out.print("Pilihan Anda: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 
                    int i = 0;
                    int j = 0;

                    if (choice == 1) {
                    boolean button = true;
                    while (button) {
                        
                    // Pilihan 1: Mengirim paket
                    Scanner sc = new Scanner(System.in);

                    // Input data pengirim
                    System.out.print("Masukkan nama pengirim    : ");
                    String namaPengirim = sc.nextLine();
                    System.out.print("Masukkan nama penerima    : ");
                    String namaPenerima = sc.nextLine();
                    System.out.print("Masukkan alamat pengirim  : ");
                    String alamatPengirim = sc.nextLine();
                    System.out.print("Masukkan alamat penerima  : ");
                    String alamatPenerima = sc.nextLine();
                    System.out.print("Masukkan no hp pengirim   :");
                    String noHpPengirim = sc.nextLine();
                    System.out.print("Masukkan no hp penerima   :");
                    String noHpPenerima = sc.nextLine();

                    // Proses penghitungan biaya pengiriman
                    double beratPaket;
                    System.out.println("Berat paket (gram)        : ");
                    beratPaket = sc.nextDouble();
                    double jarakPengiriman;
                    System.out.println("Jarak Pengiriman (km)     : ");
                    jarakPengiriman = sc.nextDouble();
                    double panjang, lebar, tinggi;
                    System.out.println("Panjang (cm)              : ");
                    panjang = sc.nextDouble();
                    System.out.println("Lebar (cm)                : ");
                    lebar = sc.nextDouble();
                    System.out.println("Tinggi (cm)               : ");
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
                    double biayaPengiriman1 = biayaPengiriman - (biayaPengiriman * diskon);
                    System.out.println("Nama pengirim           : " + namaPengirim);
                    System.out.println("Nama penerima           : " + namaPenerima);
                    System.out.println("Alamat pengirim         : " + alamatPengirim);
                    System.out.println("Alamat penerima         : " + alamatPenerima);
                    System.out.println("Biaya pengiriman        : " + biayaPengiriman1);
                    System.out.println("Diskon yang di dapat    : " + diskon);

                    System.out.println("Apakah anda ingin melanjutkan pengiriman? \n 1. Iya \n 2. Tidak");
                    int lanjut = scanner.nextInt();
                    
                    if (lanjut==1) {
                        System.out.println("Transaksi berhasil ");

                        //Menampilkan Resi
                        if (layanan==1){
                            System.out.println("Pengirim        : " + namaPengirim);
                            System.out.println("No Hp pengirim  : " + noHpPengirim);
                            System.out.println("Penerima        : " + namaPenerima);
                            System.out.println("No Hp Penerima  : " + noHpPenerima);
                            System.out.println("Tujuan          : " + alamatPenerima);
                            System.out.println("Keterangan      : " +beratPaket+" gram "+jarakPengiriman+" km");
                            System.out.println("Biaya           : " + biayaPengiriman);

                            //format resi reguler
                            String rgl = "RGL01";
                            int isiResi1 = (int) jarakPengiriman;
                            int isiResi2 = (int) beratPaket;
                            String resiRGL = rgl+isiResi1*isiResi2;
                            System.out.println("No Resi     : " +resiRGL);
                            
                            
                        } else {
                            double biayaPengiriman2 = biayaPengiriman + biayaPengiriman * 50/100;
                            System.out.println("Pengirim        : " + namaPengirim);
                            System.out.println("No Hp Pengirim  : " +noHpPengirim);
                            System.out.println("Penerima        : " + namaPenerima);
                            System.out.println("No Hp Penerima  : "+noHpPenerima);
                            System.out.println("Tujuan          : " + alamatPenerima);
                            System.out.println("Keterangan      : " +beratPaket+" gram "+jarakPengiriman+" km");
                            System.out.println("Biaya           : " + biayaPengiriman2);
                            //format resi express
                            String exr = "EXR02";
                            int isiResi11 = (int) jarakPengiriman;
                            int isiResi22 = (int) beratPaket;
                            String resiExpres = exr+isiResi11 + isiResi22;
                            System.out.println("No Resi     : "+resiExpres);
                            
                            
                        }
                    // memasukkan array 2 dimensi
                    dataPengiriman[i][j] = namaPengirim;
                    dataPengiriman[i+1][j] = noHpPengirim;
                    dataPengiriman[i+2][j] = namaPenerima;
                    dataPengiriman[i+3][j] = noHpPenerima;
                    dataPengiriman[i+4][j] = alamatPenerima;
                    dataPengiriman[i+5][j] = resiExpres;
                    dataPengiriman[i+6][j] = resiRGL;
                    dataPaket[i][j] = biayaPengiriman;
                    dataPaket[i+1][j] = biayaPengiriman1;
                    dataPaket[i+2][j] = beratPaket;
                    dataPaket[i+3][j] = jarakPengiriman;

                
                    } else {
                        System.out.println("Transaksi gagal");
                        
                        
                    }
                     System.out.print("Mau buat pengiriman baru (y/n)? ");
                            String kirim = sc.next();
                            if (kirim.equalsIgnoreCase("y")){
                                button = true;
                            }else {
                                button = false;
                                break;
                            }
                }
                
        
                    } else if (choice == 2) {
                        // ... Bagian untuk melacak paket ...
                    } else if (choice == 3) {
                        // ... Bagian untuk riwayat pembelian ...
                    } else if (choice == 4) {
                        System.out.println("Anda telah keluar ");
                        break;

                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }

              
                
            } else {
                System.out.println("Login gagal. Nama pengguna atau kata sandi salah.");
            }
        } while (on);
    }
}
