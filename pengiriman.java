import java.util.Scanner;

public class pengiriman {
    
    //Fungsi Riwayat Pengiriman
    static void tampilRiwayat (String [][] dataPengiriman, double [][] dataPaket, int b ,int k){
        boolean riwayatDitemukan = false;
        for (int i = 0; i < dataPengiriman.length; i++) {
            for (int j = 0; j < dataPengiriman[i].length; j++) {
        System.out.println("Nama Pengirim    : " + dataPengiriman[b][i]);
        System.out.println("No Hp Pengirim   : " + dataPengiriman[b + 1][i]);
        System.out.println("Nama Penerima    : " + dataPengiriman[b + 2][i]);
        System.out.println("No Hp Penerima   : " + dataPengiriman[b + 3][i]);
        System.out.println("Alamat Penerima  : " + dataPengiriman[b + 4][i]);
        System.out.println("No Resi          : " + dataPengiriman[b + 5][i]);
        System.out.println("Biaya Pengiriman : " + dataPaket[b][i]);
        System.out.println("Berat Paket      : " + dataPaket[b + 1][i]);
        System.out.println("Jarak Pengiriman : " + dataPaket[b + 2][i]);
        riwayatDitemukan = true;
         break;                     
        }
        if (riwayatDitemukan) {
        break;
        }
        } if (!riwayatDitemukan) {
        System.out.println("Riwayat tidak ditemukan.");
        }
        System.out.println();
    }
    //fungsi biaya pengiriman
    static double biayaPengiriman (double berat, double jarak, double panjang, double lebar, double tinggi, double layanan) {
        double dimensi, biayaPengiriman, diskon, total;
        biayaPengiriman = berat * 10 + jarak * 5 + panjang * 5 + lebar * 5 + tinggi * 5;
        dimensi = panjang *tinggi*lebar;
        diskon = 0;
        if (layanan == 1) {
            if (jarak > 1000) {
                if (berat < 2000) {
                    if (dimensi < 600) {
                        diskon = 3*0.05;
                    } else {
                        diskon = 2*0.05;
                    }
                } else {
                    diskon = 0.05;
                }
            }
            total = biayaPengiriman - (biayaPengiriman * diskon);

        } else {
            total = biayaPengiriman + (biayaPengiriman * (50/100));
        }
    return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // inisilisasi untuk riwayat
        int k = 0;
        int b = 0;
        
        // kumpulan array
        int maxData = 100;
        double [][] dataPaket = new double[4][maxData];
        String [][] dataPengiriman = new String[6][maxData];
        String  [] tempRiwayat = 
        {"Nama Pengirim       : " ,"No Hp Pengirim      : " ,"Nama Penerima       : " ,"No Hp Penerima      : " ,"Alamat Penerima     : " ,"No Resi             : " ,"Biaya Pengiriman    : " ,"Berat Paket         : " ,"Jarak Pengiriman    : "};
 
        // Login
        String[][] loginData = {
        {"admin1", "adm1"},
        {"admin2", "adm2"}
    };

        do {
            System.out.print("Masukkan nama pengguna (q untuk keluar): ");
            String user = scanner.nextLine();
            System.out.print("Masukkan kata sandi (q untuk keluar)   : ");
            String pass = scanner.nextLine();

            boolean loginBerhasil = false;
            if(user.equalsIgnoreCase("q")||pass.equalsIgnoreCase("q")){
                break;
            }
            for (int i = 0; i < loginData.length; i++) {
                String username = loginData [i][0];
                String password = loginData [i][1];

                if (user.equalsIgnoreCase(username) && pass.equals(password)) {
                    System.out.println("======================================");
                    System.out.println("Login berhasil!");
                    System.out.println("======================================");
                    loginBerhasil = true;
               
                    break;
                }
            }

            if (loginBerhasil) {
                while (true) {
                    System.out.println("Pilih tindakan:");
                    System.out.println("1. Mengirim paket");
                    System.out.println("2. Melacak paket");
                    System.out.println("3. Riwayat pembelian");
                    System.out.println("4. Keluar");
                    System.out.print("Pilihan Anda : ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    if (choice == 1) {
                    boolean button = true;
                    while (button) {
                        
                    // Pilihan 1: Mengirim paket
                    Scanner sc = new Scanner(System.in);

                    // Input data pengirim
                    System.out.println("======================================");
                    System.out.print("Masukkan nama pengirim    : ");
                    String namaPengirim = sc.nextLine();
                    System.out.print("Masukkan nama penerima    : ");
                    String namaPenerima = sc.nextLine();
                    System.out.print("Masukkan alamat pengirim  : ");
                    String alamatPengirim = sc.nextLine();
                    System.out.print("Masukkan alamat penerima  : ");
                    String alamatPenerima = sc.nextLine();
                    System.out.print("Masukkan no hp pengirim   : ");
                    String noHpPengirim = sc.nextLine();
                    System.out.print("Masukkan no hp penerima   : ");
                    String noHpPenerima = sc.nextLine();

                    // Proses penghitungan biaya pengiriman
                    double beratPaket;
                    System.out.print("Berat paket (gram)        : ");
                    beratPaket = sc.nextDouble();
                    double jarakPengiriman;
                    System.out.print("Jarak Pengiriman (km)     : ");
                    jarakPengiriman = sc.nextDouble();
                    double panjang, lebar, tinggi;
                    System.out.print("Panjang (cm)              : ");
                    panjang = sc.nextDouble();
                    System.out.print("Lebar (cm)                : ");
                    lebar = sc.nextDouble();
                    System.out.print("Tinggi (cm)               : ");
                    tinggi = sc.nextDouble();
                    
                    //Layanan Pengiriman
                    System.out.println("======================================");
                    System.out.println("Pilih layanan pengiriman yang digunakan");
                    System.out.println("1. Reguler");
                    System.out.println("2. Express");
                    System.out.print("Pilihan Anda : ");
                    int layanan = scanner.nextInt();
                    double layananDouble = (double) layanan;
                    double total = biayaPengiriman(beratPaket,jarakPengiriman, panjang, lebar, tinggi, layananDouble);
                    System.out.println("======================================");
                    System.out.println("Nama pengirim           : " + namaPengirim);
                    System.out.println("Nama penerima           : " + namaPenerima);
                    System.out.println("Alamat pengirim         : " + alamatPengirim);
                    System.out.println("Alamat penerima         : " + alamatPenerima);
                    System.out.println("Biaya pengiriman        : " + total );
                    //System.out.println("Diskon yang di dapat    : " + diskon);

                    System.out.println("======================================");
                    System.out.println("Apakah anda ingin melanjutkan pengiriman? \n 1. Iya \n 2. Tidak");
                    System.out.print("Pilihan Anda : ");
                    int lanjut = scanner.nextInt();
                    
                    if (lanjut==1) {
                        System.out.println("======================================");
                        System.out.println("Transaksi berhasil! ");
                        String resi;
                        

                        //Menampilkan Resi
                        if (layanan==1){
                            System.out.println("======================================");
                            System.out.println("Pengirim        : " + namaPengirim);
                            System.out.println("No Hp pengirim  : " + noHpPengirim);
                            System.out.println("Penerima        : " + namaPenerima);
                            System.out.println("No Hp Penerima  : " + noHpPenerima);
                            System.out.println("Tujuan          : " + alamatPenerima);
                            System.out.println("Keterangan      : " + beratPaket+" gram "+jarakPengiriman+" km");
                            System.out.println("Biaya           : " + total);

                            //format resi reguler
                            String rgl = "RGL01";
                            int isiResi1 = (int) jarakPengiriman;
                            int isiResi2 = (int) beratPaket;
                            resi = rgl+isiResi1*isiResi2;
                            System.out.println("No Resi        : " +resi);
                            
                        } else {
                            System.out.println("======================================");
                            System.out.println("Pengirim        : " + namaPengirim);
                            System.out.println("No Hp Pengirim  : " + noHpPengirim);
                            System.out.println("Penerima        : " + namaPenerima);
                            System.out.println("No Hp Penerima  : " + noHpPenerima);
                            System.out.println("Tujuan          : " + alamatPenerima);
                            System.out.println("Keterangan      : " + beratPaket+" gram "+ jarakPengiriman+" km");
                            System.out.println("Biaya           : " + total);
                            //format resi express
                            String exr = "EXR02";
                            int isiResi11 = (int) jarakPengiriman;
                            int isiResi22 = (int) beratPaket;
                            resi = exr+isiResi11*isiResi22;
                            System.out.println("No Resi         : "+resi);
                            
                        }

                    // memasukkan array 2 dimensi resi
                    dataPengiriman[b][k] = namaPengirim;
                    dataPengiriman[b+1][k] = noHpPengirim;
                    dataPengiriman[b+2][k] = namaPenerima;
                    dataPengiriman[b+3][k] = noHpPenerima;
                    dataPengiriman[b+4][k] = alamatPenerima;
                    dataPengiriman[b+5][k] = resi;
                    
                    dataPaket[b][k] = total;
                    dataPaket[b+1][k] = beratPaket;
                    dataPaket[b+2][k] = jarakPengiriman;
                    k++;
                    
                
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
                        while (true) {
                        // ... Bagian untuk riwayat pembelian ...
                        System.out.println("======================================");
                        System.out.println("1.Lewat nama pengirim  ");
                        System.out.println("2.Lewat no Hp pengirim  ");
                        System.out.println("3.Lewat nama penerima ");
                        System.out.println("4.Lewat no Hp penerima");
                        System.out.println("5.Lewat alamat penerima ");
                        System.out.println("6.Lewat no resi ");
                        System.out.println("7.Jumlah riwayat");
                        System.out.println("8.Menampilkan riwayat");
                        System.out.println("9.Kembali");
                        System.out.print("Pilihan Anda : ");
                        int pil = scanner.nextInt();

                        if (pil==1){
                            System.out.print("Masukan nama pengirim : ");
                            String namaPengirim = scanner.next();
                            System.out.println("======================================");
                            tampilRiwayat(dataPengiriman, dataPaket, b, k);
                            
                        } else if (pil == 2) {
                            System.out.print("Masukan no hp pengirim : ");
                            String nomorPengirim = scanner.next();
                            System.out.println("======================================");
                            tampilRiwayat(dataPengiriman, dataPaket, b, k);
                            

                        } else if (pil == 3) {
                            System.out.print("Masukan nama penerima : ");
                            String namaPenerima = scanner.next();
                            System.out.println("======================================");
                            tampilRiwayat(dataPengiriman, dataPaket, b, k);

                        } else if (pil == 4) {
                            System.out.print("Masukan no hp penerima : ");
                            String nomorPenerima = scanner.next();
                            System.out.println("======================================");
                            tampilRiwayat(dataPengiriman, dataPaket, b, k);

                        } else if (pil == 5) {
                            System.out.print("Masukan alamat penerima : ");
                            String alamatPenerima = scanner.next();
                            System.out.println("======================================");
                            tampilRiwayat(dataPengiriman, dataPaket, b, k);

                        } else if (pil == 6) {
                            System.out.print("Masukan no resi : ");
                            String noResi = scanner.next();
                            System.out.println("======================================");
                            tampilRiwayat(dataPengiriman, dataPaket, b, k);
                            

                        }else if (pil==7){
                            System.out.println("======================================");
                            System.err.println("Jumlah Transaksi : " + k);

                        }else if (pil==8){
                            System.out.println("======================================");
                            System.out.println("Menampilkan semua riwayat:");
                            for (int i = 0; i < k; i++) {
                                System.out.println("======================================");
                                System.out.println("Data pengiriman ke-" + (i+ 1) );
                                for (int j = 0; j < dataPengiriman.length; j++) {
                                        System.out.println(tempRiwayat[j] + dataPengiriman[j][i]);
                                    }
                                    System.out.println("Biaya Pengiriman    : " + dataPaket[b][i]);
                                    System.out.println("Berat Paket         : " + dataPaket[b+1][i]);
                                    System.out.println("Jarak Pengiriman    : " + dataPaket[b+2][i]);
                            }

                            }else if (pil==9){
                                System.out.println("======================================");
                                break;
                            }
                        }

                    } else if (choice == 4) {
                        System.out.println("Anda telah keluar ");
                        break;

                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }

            
                
            } else {
                System.out.println("Login anda gagal, Nama pengguna atau kata sandi salah!");
            }
        } while (true);
    }
}

