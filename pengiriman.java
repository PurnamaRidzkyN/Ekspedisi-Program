import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class pengiriman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        // Login
        String[][] loginManajer = {
                { "Manajer", "manage" }
        };
        String[][] loginAdmin = {
                { "admin1", "adm1" },
                { "admin2", "adm2" },
        };
        String[][] loginKurir = {
                { "Kurir1", "kr1" },
                { "Kurir2", "kr1" }
        };
        String[][] loginPelanggan = {
                { "Pelanggan", "aku" }
        };

        // kumpulan array
        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        int b = 0;
        ;
        int maxData = 100;
        double[][] dataPaket1 = new double[4][maxData];
        String[][] dataPengiriman1 = new String[6][maxData];
        double[][] dataPaket2 = new double[4][maxData];
        String[][] dataPengiriman2 = new String[6][maxData];
        double[][] dataPaket3 = new double[4][maxData];
        String[][] dataPengiriman3 = new String[6][maxData];
        String[] lokasi = { "Surabaya", "Blitar", "Kediri", "Madiun", "Malang", "Batu", "Mojokerto", "Pasuruan",
                "Probolinggo" };
        int[][] jarak = {
                { 0, 162, 123, 164, 95, 104, 51, 69, 106 }, // surabaya indeks 0
                { 162, 0, 40, 133, 76, 75, 101, 153, 190 }, // Blitar
                { 123, 40, 0, 94, 103, 86, 80, 167, 203 }, // Kediri
                { 164, 134, 94, 0, 234, 165, 121, 208, 245 }, // Madiun
                { 94, 79, 103, 232, 0, 17, 92, 75, 112 }, // Malang
                { 105, 74, 86, 163, 17, 0, 60, 85, 123 }, // Batu
                { 59, 101, 80, 121, 121, 60, 0, 66, 132 }, // Mojokerto
                { 70, 54, 167, 208, 55, 64, 66, 0, 46 }, // Pasuruan
                { 106, 193, 203, 244, 112, 123, 132, 46, 0 } // Probolinggo indeks 8
        };
        String[] sampai1 = new String[maxData];
        String[] sampai2 = new String[maxData];
        String[] sampai3 = new String[maxData];
        double jarakPengiriman;
        boolean keluar= false;

        while (true) {
            System.out.println("============================================");
            System.out.println(" SELAMAT DATANG DI PROGRAM EKSPEDISI DINPUR");
            System.out.println("============================================");
            System.out.println("Masuk sebagai siapa?");
            System.out.println("1.Manajer");
            System.out.println("2.Admin");
            System.out.println("3.Kurir");
            System.out.println("4.Pelanggan");
            System.out.println("5.Ubah bahasa");
            System.out.println("6.Keluar program");
            System.out.println("============================================");
            System.out.print("Masukan pilihan anda: ");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    while (true) {
                        int login = login(loginManajer);
                        if (login == 1) {
                            boolean islogin = true;
                            manajer(dataPaket1, dataPengiriman1, k1, b, islogin, dataPaket2, dataPengiriman2, k2, dataPengiriman3, dataPaket3, k3);
                            break;
                        } else {
                            System.out.print("Masukan ulang (y/n): ");
                            String pil = input.next();
                            if (pil.equalsIgnoreCase("y")) {

                            } else {
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    boolean on = true;
                    while (on) {
                        boolean loginBerhasil = false;
                        int login = login(loginAdmin);
                        if (login == 1) {
                            loginBerhasil = true;
                        } else if (login == 2) {
                            loginBerhasil = true;
                        } else {
                            System.out.print("Masukan ulang (y/n): ");
                            String pil = input.next();
                            if (pil.equalsIgnoreCase("y")) {

                            } else {
                                break;
                            }
                        }
                        Scanner scanner = new Scanner(System.in);
                        if (loginBerhasil) {
                            while (true) {
                                System.out.println(" _________________________");
                                System.out.println("|                         |");
                                System.out.println("|Pilih tindakan:          |");
                                System.out.println("|1. Mengirim paket        |");
                                System.out.println("|2. Melacak paket         |");
                                System.out.println("|3. Riwayat pembelian     |");
                                System.out.println("|4. Menampilkan Laporan   |");
                                System.out.println("|5. Keluar                |");
                                System.out.println("|_________________________|");
                                System.out.print("Pilihan Anda : ");
                                int choice = scanner.nextInt();
                                scanner.nextLine();

                                if (choice == 1) {
                                    boolean button = true;
                                    while (button) {
                                        // Pilihan 1: Mengirim paket
                                        Scanner sc = new Scanner(System.in);
                                        String alamatPenerima;
                                        // Input data pengirim
                                        System.out.println("======================================");
                                        System.out.print("Masukkan nama pengirim    : ");
                                        String namaPengirim = sc.nextLine();
                                        System.out.print("Masukkan nama penerima    : ");
                                        String namaPenerima = sc.nextLine();
                                        System.out.println("Pilih lokasi Pengirim : ");
                                        System.out.println("1. Surabaya");
                                        System.out.println("2. Blitar");
                                        System.out.println("3. Kediri");
                                        System.out.println("4. Madiun");
                                        System.out.println("5. Malang");
                                        System.out.println("6. Batu");
                                        System.out.println("7. Mojokerto");
                                        System.out.println("8. Pasuruan");
                                        System.out.println("9. Probolinggo");
                                        System.out.println("10. lokasi tidak ada");
                                        System.out.print("Pilihan anda : ");
                                        int ALpengirim = sc.nextInt();
                                        String alamatPengirim;
                                        if (ALpengirim == 10) {
                                            System.out.println("Masukan alamat pengirim : ");
                                            alamatPengirim = sc.next();
                                        }
                                        System.out.println("Pilih lokasi Penerima : ");
                                        System.out.println("1. Surabaya");
                                        System.out.println("2. Blitar");
                                        System.out.println("3. Kediri");
                                        System.out.println("4. Madiun");
                                        System.out.println("5. Malang");
                                        System.out.println("6. Batu");
                                        System.out.println("7. Mojokerto");
                                        System.out.println("8. Pasuruan");
                                        System.out.println("9. Probolinggo");
                                        System.out.println("10. lokasi tidak ada");
                                        System.out.print("Pilihan anda : ");
                                        int ALpenerima = sc.nextInt();
                                        if ((ALpengirim == 10) || (ALpenerima == 10)) {

                                            System.out.println("Masukan alamat pengirim : ");
                                            alamatPenerima = sc.next();
                                            System.out.println("Masukan jarak : ");
                                            jarakPengiriman = sc.nextDouble();
                                        }else{
                                            alamatPenerima = lokasi[ALpenerima - 1];
                                            jarakPengiriman = jarak[ALpengirim][ALpenerima];
                                        }

                                        System.out.print("Masukkan no hp pengirim   : ");
                                        String noHpPengirim = sc.next();
                                        System.out.print("Masukkan no hp penerima   : ");
                                        String noHpPenerima = sc.next();

                                        // Proses penghitungan biaya pengiriman
                  
                                        System.out.println(jarakPengiriman);
                                        double beratPaket;
                                        System.out.print("Berat paket (gram)        : ");
                                        beratPaket = sc.nextDouble();
                                        double panjang, lebar, tinggi;
                                        System.out.print("Panjang (cm)              : ");
                                        panjang = sc.nextDouble();
                                        System.out.print("Lebar (cm)                : ");
                                        lebar = sc.nextDouble();
                                        System.out.print("Tinggi (cm)               : ");
                                        tinggi = sc.nextDouble();

                                        // Layanan Pengiriman
                                        System.out.println("======================================");
                                        System.out.println("Pilih layanan pengiriman yang digunakan");
                                        System.out.println("1. Reguler");
                                        System.out.println("2. Express");
                                        System.out.print("Pilihan Anda : ");
                                        int layanan = scanner.nextInt();
                                        double layananDouble = (double) layanan;
                                        double total = biayaPengiriman(beratPaket, jarakPengiriman, panjang, lebar,
                                                tinggi, layananDouble);
                                        System.out.println("======================================");
                                        System.out.println("Nama pengirim           : " + namaPengirim);
                                        System.out.println("Nama penerima           : " + namaPenerima);
                                        System.out.println("Alamat penerima         : " + alamatPenerima);
                                        System.out.println("Biaya pengiriman        : " + total);
                                        System.out.println("Waktu                   : " + today);
                                        System.out.println("                          " + time);
                                        // System.out.println("Diskon yang di dapat : " + diskon);

                                        System.out.println("======================================");
                                        System.out.println(
                                                "Apakah anda ingin melanjutkan pengiriman? \n 1. Iya \n 2. Tidak");
                                        System.out.print("Pilihan Anda : ");
                                        int lanjut = scanner.nextInt();

                                        if (lanjut == 1) {
                                            while (lanjut == 1) {
                                                System.out.println("======================================");
                                                System.out.println("Masukkan Pembayaran ");
                                                System.out.println("1. Transfer");
                                                System.out.println("2. Tunai");
                                                System.out.println("======================================");
                                                int bayar = scanner.nextInt();
                                                double kembalian = pembayaran(bayar, total);

                                                if (kembalian >= 0) {
                                                    System.out.println("======================================");
                                                    System.out.println("Transaksi berhasil!");
                                                    System.out.println("Kembalian :" + kembalian);
                                                } else {
                                                    System.out.println("======================================");
                                                    System.out.println("Transaksi gagal! Pembayaran tidak mencukupi.");
                                                }
                                                break;
                                            }
                                            String resi;

                                            // Menampilkan Resi
                                            if (layanan == 1) {
                                                System.out.println("======================================");
                                                System.out.println(" ______________________________________________");
                                                System.out.println("|                                     |        |");
                                                System.out.println("|       EKSPEDISI DINPUR              |   RGL  |");
                                                System.out.println("|_____________________________________|________|");
                                                System.out.printf("|Pengirim        : %-28s|\n", namaPengirim);
                                                System.out.printf("|No Hp pengirim  : %-28s|\n", noHpPengirim);
                                                System.out.printf("|Penerima        : %-28s|\n", namaPenerima);
                                                System.out.printf("|No Hp Penerima  : %-28s|\n", noHpPenerima);
                                                System.out.printf("|Tujuan          : %-28s|\n", alamatPenerima);
                                                System.out.printf("|Keterangan      : %-23sgram |\n", beratPaket);
                                                System.out.printf("|                  %-25skm |\n", jarakPengiriman);
                                                System.out.printf("|Waktu           : %-28s|\n", today);
                                                System.out.printf("|                  %-28s|\n", time);
                                                System.out.printf("|Biaya           : %-28s|\n", total);

                                                // format resi reguler
                                                String rgl = "RGL01";
                                                int isiResi1 = (int) jarakPengiriman;
                                                int isiResi2 = (int) beratPaket;
                                                resi = rgl + isiResi1 * isiResi2;
                                                System.out.printf("|No Resi         : %-28s|\n", resi);
                                                System.out.println("|______________________________________________|");
                                                System.out.println("Cetak Resi dan tempel pada paket !");

                                            } else {
                                                System.out.println("======================================");
                                                System.out.println(" ______________________________________________");
                                                System.out.println("|                                     |        |");
                                                System.out.println("|       EKSPEDISI DINPUR              |   EXR  |");
                                                System.out.println("|_____________________________________|________|");
                                                System.out.printf("|Pengirim        : %-28s|\n", namaPengirim);
                                                System.out.printf("|No Hp pengirim  : %-28s|\n", noHpPengirim);
                                                System.out.printf("|Penerima        : %-28s|\n", namaPenerima);
                                                System.out.printf("|No Hp Penerima  : %-28s|\n", noHpPenerima);
                                                System.out.printf("|Tujuan          : %-28s|\n", alamatPenerima);
                                                System.out.printf("|Keterangan      : %-23sgram |\n", beratPaket);
                                                System.out.printf("|                  %-25skm |\n", jarakPengiriman);
                                                System.out.printf("|Waktu           : %-28s|\n", today);
                                                System.out.printf("|                  %-28s|\n", time);
                                                System.out.printf("|Biaya           : %-28s|\n", total);
                                                // format resi express
                                                String exr = "EXR02";
                                                int isiResi11 = (int) jarakPengiriman;
                                                int isiResi22 = (int) beratPaket;
                                                resi = exr + isiResi11 * isiResi22;
                                                System.out.printf("|No Resi         : %-28s|\n", resi);
                                                System.out.println("|______________________________________________|");
                                                System.out.println("Cetak Resi dan tempel pada paket !");

                                            }

                                            // memasukkan array 2 dimensi resi
                                            if (login == 1) {
                                                dataPengiriman1[b][k1] = namaPengirim;
                                                dataPengiriman1[b + 1][k1] = noHpPengirim;
                                                dataPengiriman1[b + 2][k1] = namaPenerima;
                                                dataPengiriman1[b + 3][k1] = noHpPenerima;
                                                dataPengiriman1[b + 4][k1] = alamatPenerima;
                                                dataPengiriman1[b + 5][k1] = resi;

                                                dataPaket1[b][k1] = total;
                                                dataPaket1[b + 1][k1] = beratPaket;
                                                dataPaket1[b + 2][k1] = jarakPengiriman;
                                                k1++;

                                            } else if (login == 2) {
                                                dataPengiriman2[b][k2] = namaPengirim;
                                                dataPengiriman2[b + 1][k2] = noHpPengirim;
                                                dataPengiriman2[b + 2][k2] = namaPenerima;
                                                dataPengiriman2[b + 3][k2] = noHpPenerima;
                                                dataPengiriman2[b + 4][k2] = alamatPenerima;
                                                dataPengiriman2[b + 5][k2] = resi;

                                                dataPaket2[b][k2] = total;
                                                dataPaket2[b + 1][k2] = beratPaket;
                                                dataPaket2[b + 2][k2] = jarakPengiriman;
                                                k2++;
                                            }
                                        } else {
                                            System.out.println("Transaksi gagal");
                                        }
                                        System.out.print("Mau buat pengiriman baru (y/n)? ");
                                        String kirim = sc.next();
                                        if (kirim.equalsIgnoreCase("y")) {
                                            button = true;
                                        } else {
                                            button = false;
                                            break;
                                        }
                                    }
                                } else if (choice == 2) {
                                    // Melacak Paket
                                    if (login == 1) {
                                        melacakPaket(dataPengiriman1, k1, sampai1);
                                    } else if (login == 2) {
                                        melacakPaket(dataPengiriman2, k2, sampai2);
                                    }

                                } else if (choice == 3) {
                                    if (login == 1) {
                                        pencarianRiwayat(scanner, dataPengiriman1, dataPaket1, k1);
                                    } else if (login == 2) {
                                        pencarianRiwayat(scanner, dataPengiriman2, dataPaket2, k2);
                                    }

                                } else if (choice == 4) {
                                if (login == 1) {
                                    laporanAdmin(dataPengiriman1, dataPaket1, k1);
                                } else if (login == 2) {
                                    laporanAdmin(dataPengiriman2, dataPaket2, k2);
                                }

                                } else if (choice == 5) {
                                    System.out.println("Anda telah keluar ");
                                    on = false;
                                    break;

                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    int masukKurir = login(loginKurir);
                    if (masukKurir == 1) {
                        System.out.println("Selamat datang, Kurir!");
                        while (true) {
                            System.out.println("Pilihan Kurir:");
                            System.out.println("1. Lihat data paket yang akan dikirim");
                            System.out.println("2. Lihat perjalanan paket");
                            System.out.println("3. Konfirmasi paket");
                            System.out.println("4. Keluar");
                            System.out.print("Pilihan Anda: ");
                            int pilihanKurir = input.nextInt();

                            if (pilihanKurir == 1) {
                                System.out.println("Data paket yang harus dikirim: ");
                                if (k1 > 0) {
                                    // Menampilkan data paket yang akan dikirim oleh kurir
                                    for (int i = 0; i < k1; i++) {
                                        System.out.println("======================================");
                                        System.out.println("Data paket ke-" + (i + 1));
                                        System.out.println("______________________________________________");
                                        System.out.printf("Pengirim        : %-28s\n", dataPengiriman1[0][i]);
                                        System.out.printf("No Hp pengirim  : %-28s\n", dataPengiriman1[1][i]);
                                        System.out.printf("Penerima        : %-28s\n", dataPengiriman1[2][i]);
                                        System.out.printf("No Hp Penerima  : %-28s\n", dataPengiriman1[3][i]);
                                        System.out.printf("Tujuan          : %-28s\n", dataPengiriman1[4][i]);
                                        System.out.printf("Keterangan      : %-23sgram \n", dataPaket1[1][i]);
                                        System.out.printf("                  %-25skm \n", dataPaket1[2][i]);
                                        System.out.printf("Biaya           : %-28s\n", dataPaket1[0][i]);
                                        System.out.printf("No Resi         : %-28s\n", dataPengiriman1[5][i]);
                                        System.out.println("______________________________________________");
                                    }
                                } else {
                                    System.out.println("Tidak ada paket yang akan dikirim.");
                                }
                            } else if (pilihanKurir == 2) {
                                System.out.println("Pilih pesanan dari : ");
                                System.out.println("1. Admin 1");
                                System.out.println("2. Admin 2");
                                System.out.println("3. Pelanggan");
                                int pilihan = input.nextInt();
                                if (pilihan == 1) {
                                    melacakPaket(dataPengiriman1, k1, sampai1);
                                } else if (pilihan == 2) {
                                    melacakPaket(dataPengiriman2, k2, sampai2);
                                } else if (pilihan == 3) {
                                    melacakPaket(dataPengiriman3, k3, sampai3);
                                }
                            } else if (pilihanKurir == 3) {
                                System.out.println("Pilih pesanan dari : ");
                                System.out.println("1. Admin 1");
                                System.out.println("2. Admin 2");
                                System.out.println("3. Pelanggan");
                                System.out.println("Pilihan anda : ");
                                int pilihan = input.nextInt();

                                    if (pilihan == 1) {
                                        System.out.println("Masukkan no resi yang ingin di konfirmasi: ");
                                        String noResi = input.next(); 
                                        for (int i=0; i<k1; i++) {
                                            if(noResi.equalsIgnoreCase(dataPengiriman1[5][i])){
                                            sampai1[i] = dataPengiriman1[5][i];
                                            System.out.println("Paket dengan no resi ini telah sampai.");
                                            }
                                        }
                                    } else if (pilihan == 2) {
                                        System.out.println("Masukkan no resi yang ingin di konfirmasi: ");
                                        String noResi = input.next();
                                        for (int i=0; i<k2; i++) {
                                            if(noResi.equalsIgnoreCase(dataPengiriman2[5][i])) {
                                                sampai2[i] = dataPengiriman2[5][i];
                                                System.out.println("Paket dengan no resi ini telah sampai.");
                                            }
                                        }
                                    } else if (pilihan == 3) {
                                        System.out.println("Masukkan no resi yang ingin di konfirmasi: ");
                                        String noResi = input.next();
                                        for (int i=0; i<k3; i++) {
                                            if(noResi.equalsIgnoreCase(dataPengiriman3[5][i])) {
                                                sampai3[i] = dataPengiriman3[5][i];
                                                System.out.println("Paket dengan no resi ini telah sampai.");
                                            }
                                        }
                                    }

                                    
                                }else {
                                    break;
                                }
                                
                            }
                        }
                        break;

                case 4:
                    while (true) {
                        int login = login(loginPelanggan);
                        if (login == 1) {
                            boolean islogin = true;
                            Scanner scanner = new Scanner(System.in);
                            String alamatPenerima;
                            while (true) {
                                System.out.println(" _________________________");
                                System.out.println("|                         |");
                                System.out.println("|Pilih tindakan:          |");
                                System.out.println("|1. Mengirim paket        |");
                                System.out.println("|2. Riwayat pembelian     |");
                                System.out.println("|3. Melacak paket         |");
                                System.out.println("|4. Keluar                |");
                                System.out.println("|_________________________|");
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
                                        System.out.println("Pilih lokasi Pengirim : ");
                                        System.out.println("1. Surabaya");
                                        System.out.println("2. Blitar");
                                        System.out.println("3. Kediri");
                                        System.out.println("4. Madiun");
                                        System.out.println("5. Malang");
                                        System.out.println("6. Batu");
                                        System.out.println("7. Mojokerto");
                                        System.out.println("8. Pasuruan");
                                        System.out.println("9. Probolinggo");
                                        System.out.println("10. lokasi tidak ada");
                                        System.out.print("Pilihan anda : ");
                                        int ALpengirim = sc.nextInt();
                                        String alamatPengirim;
                                        if (ALpengirim == 10) {
                                            System.out.println("Masukan alamat pengirim : ");
                                            alamatPengirim = sc.next();
                                        }
                                        System.out.println("Pilih lokasi Penerima : ");
                                        System.out.println("1. Surabaya");
                                        System.out.println("2. Blitar");
                                        System.out.println("3. Kediri");
                                        System.out.println("4. Madiun");
                                        System.out.println("5. Malang");
                                        System.out.println("6. Batu");
                                        System.out.println("7. Mojokerto");
                                        System.out.println("8. Pasuruan");
                                        System.out.println("9. Probolinggo");
                                        System.out.println("10. lokasi tidak ada");
                                        System.out.print("Pilihan anda : ");
                                        int ALpenerima = sc.nextInt();
                                        if ((ALpengirim == 10) || (ALpenerima == 10)) {

                                            System.out.println("Masukan alamat pengirim : ");
                                            alamatPenerima = sc.next();
                                            System.out.println("Masukan jarak : ");
                                            jarakPengiriman = sc.nextDouble();
                                        }else{
                                            alamatPenerima = lokasi[ALpenerima - 1];
                                            jarakPengiriman = jarak[ALpengirim][ALpenerima];
                                        }

                                        System.out.println("Masukkan no hp pengirim   : ");
                                        String noHpPengirim = sc.next();
                                        System.out.println("Masukkan no hp penerima   : ");
                                        String noHpPenerima = sc.next();

                                        // Proses penghitungan biaya pengiriman
                                        System.out.println(jarakPengiriman);
                                        double beratPaket;
                                        System.out.print("Berat paket (gram)        : ");
                                        beratPaket = sc.nextDouble();
                                        System.out.print("Jarak Pengiriman (km)     : ");
                                        jarakPengiriman = sc.nextDouble();
                                        double panjang, lebar, tinggi;
                                        System.out.print("Panjang (cm)              : ");
                                        panjang = sc.nextDouble();
                                        System.out.print("Lebar (cm)                : ");
                                        lebar = sc.nextDouble();
                                        System.out.print("Tinggi (cm)               : ");
                                        tinggi = sc.nextDouble();

                                        // Layanan Pengiriman
                                        System.out.println("======================================");
                                        System.out.println("Pilih layanan pengiriman yang digunakan");
                                        System.out.println("1. Reguler");
                                        System.out.println("2. Express");
                                        System.out.print("Pilihan Anda : ");
                                        int layanan = scanner.nextInt();
                                        double layananDouble = (double) layanan;
                                        double total = biayaPengiriman(beratPaket, jarakPengiriman, panjang, lebar,
                                                tinggi, layananDouble);
                                        System.out.println("======================================");
                                        System.out.println("Nama pengirim           : " + namaPengirim);
                                        System.out.println("Nama penerima           : " + namaPenerima);
                                        System.out.println("Alamat penerima         : " + alamatPenerima);
                                        System.out.println("Biaya pengiriman        : " + total);
                                        System.out.println("Waktu                   : " + today);
                                        System.out.println("                          " + time);
                                        // System.out.println("Diskon yang di dapat : " + diskon);

                                        System.out.println("======================================");
                                        System.out.println(
                                                "Apakah anda ingin melanjutkan pengiriman? \n 1. Iya \n 2. Tidak");
                                        System.out.print("Pilihan Anda : ");
                                        int lanjut = scanner.nextInt();

                                        if (lanjut == 1) {
                                            while (lanjut == 1) {
                                                System.out.println("======================================");
                                                System.out.println("Masukkan Pembayaran ");
                                                System.out.println("1. Transfer");
                                                System.out.println("2. Tunai");
                                                System.out.println("======================================");
                                                int bayar = scanner.nextInt();
                                                double kembalian = pembayaran(bayar, total);

                                                if (kembalian >= 0) {
                                                    System.out.println("======================================");
                                                    System.out.println("Transaksi berhasil!");
                                                    System.out.println("Kembalian :" + kembalian);

                                                            // pilihan untuk pengiriman atau pick up
                                                            System.out.println("======================================");
                                                            System.out.println("Pilihan Pengiriman:");
                                                            System.out.println("1. Antar ke Tempat Ekspedisi");
                                                            System.out.println("2. Pick Up");
                                                            System.out.print("Pilihan Anda : ");
                                                            int cchoice = scanner.nextInt();
                                                            scanner.nextLine();

                                                            if (cchoice == 1) {
                                                                System.out.println("Paket Anda segera antar ke Ekspedisi DINPUR");
                                                            } else if (cchoice == 2) {
                                                                System.out.println("======================================");
                                                                System.out.print("Masukkan alamat pengambilan paket: ");
                                                                String alamatRumah = scanner.nextLine();
                                                                System.out.println("\n Paket akan segera diambil di alamat Anda : " + alamatRumah);
                                                            } else {
                                                                System.out.println("Pilihan tidak valid");
                                                            }
                                                } else {
                                                    System.out.println("======================================");
                                                    System.out.println("Transaksi gagal! Pembayaran tidak mencukupi.");
                                                }
                                                break;
                                            }
                                            String resi;

                                            // Menampilkan Resi
                                            if (layanan == 1) {
                                                System.out.println("======================================");
                                                System.out.println(" ______________________________________________");
                                                System.out.println("|                                     |        |");
                                                System.out.println("|       EKSPEDISI DINPUR              |   RGL  |");
                                                System.out.println("|_____________________________________|________|");
                                                System.out.printf("|Pengirim        : %-28s|\n", namaPengirim);
                                                System.out.printf("|No Hp pengirim  : %-28s|\n", noHpPengirim);
                                                System.out.printf("|Penerima        : %-28s|\n", namaPenerima);
                                                System.out.printf("|No Hp Penerima  : %-28s|\n", noHpPenerima);
                                                System.out.printf("|Tujuan          : %-28s|\n", alamatPenerima);
                                                System.out.printf("|Keterangan      : %-23sgram |\n", beratPaket);
                                                System.out.printf("|                  %-25skm |\n", jarakPengiriman);
                                                System.out.printf("|Waktu           : %-28s|\n", today);
                                                System.out.printf("|                  %-28s|\n", time);
                                                System.out.printf("|Biaya           : %-28s|\n", total);

                                                // format resi reguler
                                                String rgl = "RGL01";
                                                int isiResi1 = (int) jarakPengiriman;
                                                int isiResi2 = (int) beratPaket;
                                                resi = rgl + isiResi1 * isiResi2;
                                                System.out.printf("|No Resi         : %-28s|\n", resi);
                                                System.out.println("|______________________________________________|");
                                                System.out.println("Cetak Resi dan tempel pada paket !");

                                            } else {
                                                System.out.println("======================================");
                                                System.out.println(" ______________________________________________");
                                                System.out.println("|                                     |        |");
                                                System.out.println("|       EKSPEDISI DINPUR              |   EXR  |");
                                                System.out.println("|_____________________________________|________|");
                                                System.out.printf("|Pengirim        : %-28s|\n", namaPengirim);
                                                System.out.printf("|No Hp pengirim  : %-28s|\n", noHpPengirim);
                                                System.out.printf("|Penerima        : %-28s|\n", namaPenerima);
                                                System.out.printf("|No Hp Penerima  : %-28s|\n", noHpPenerima);
                                                System.out.printf("|Tujuan          : %-28s|\n", alamatPenerima);
                                                System.out.printf("|Keterangan      : %-23sgram |\n", beratPaket);
                                                System.out.printf("|                  %-25skm |\n", jarakPengiriman);
                                                System.out.printf("|Waktu           : %-28s|\n", today);
                                                System.out.printf("|                  %-28s|\n", time);
                                                System.out.printf("|Biaya           : %-28s|\n", total);
                                                // format resi express
                                                String exr = "EXR02";
                                                int isiResi11 = (int) jarakPengiriman;
                                                int isiResi22 = (int) beratPaket;
                                                resi = exr + isiResi11 * isiResi22;
                                                System.out.printf("|No Resi         : %-28s|\n", resi);
                                                System.out.println("|______________________________________________|");
                                                System.out.println("Cetak Resi dan tempel pada paket !");

                                            }
                                            // memasukkan array 2 dimensi resi
                                            if (login == 1) {
                                                dataPengiriman3[b][k1] = namaPengirim;
                                                dataPengiriman3[b + 1][k1] = noHpPengirim;
                                                dataPengiriman3[b + 2][k1] = namaPenerima;
                                                dataPengiriman3[b + 3][k1] = noHpPenerima;
                                                dataPengiriman3[b + 4][k1] = alamatPenerima;
                                                dataPengiriman3[b + 5][k1] = resi;

                                                dataPaket3[b][k1] = total;
                                                dataPaket3[b + 1][k1] = beratPaket;
                                                dataPaket3[b + 2][k1] = jarakPengiriman;
                                                k3++;

                                            }
                                        } else {
                                            System.out.println("Transaksi gagal");
                                        }
                                        System.out.print("Mau buat pengiriman baru (y/n)? ");
                                        String kirim = sc.next();
                                        if (kirim.equalsIgnoreCase("y")) {
                                            button = true;
                                        } else {
                                            button = false;
                                            break;
                                        }
                                    }
                                } else if (choice == 2) {
                                    boolean button = true;
                                    while (button) {
                                        System.out.println(" ======================================");
                                        System.out.println("|Pilih tindakan:                       |");
                                        System.out.println("|1.Lewat nama pengirim                 |");
                                        System.out.println("|2.Lewat no resi                       |");
                                        System.out.println("|3.Kembali                             |");
                                        System.out.println(" ======================================");
                                        System.out.print("Pilihan Anda : ");
                                        int pil = scanner.nextInt();
                                        if (pil == 1) {
                                            System.out.print("Masukan nama pengirim : ");
                                            String namaPengirim = scanner.next();
                                            System.out.println("======================================");
                                            tampilRiwayat(pil, namaPengirim, dataPengiriman3, dataPaket3, k3);

                                        } else if (pil == 2) {
                                            System.out.print("Masukan no resi : ");
                                            String noResi = scanner.next();
                                            System.out.println("======================================");
                                            tampilRiwayat(pil, noResi, dataPengiriman3, dataPaket3, k3);

                                        } else if (pil == 3) {
                                            System.out.println("======================================");
                                            break;
                                        }
                                    }
                                } else if (choice == 3) {
                                    melacakPaket(dataPengiriman3, k3, sampai3);
                                } else if (choice == 4) {
                                    // Implementasi pilihan keluar
                                    System.out.println("Anda telah keluar ");
                                    break;
                                }
                            }
                        } else {
                            System.out.print("Masukan ulang (y/n): ");
                            String pil = input.next();
                            if (!pil.equalsIgnoreCase("y")) {
                                break;
                            }
                        }
                        break;
                    }
                    break;
                case 5:
                case 6:
                    System.out.println("Terima kasih telah menggunak progam ekspedisi DINPUR");
                    keluar=true;
                    break;
            
                }
            if(keluar){
                break;
            }
        }
    }

    public static void manajer(double[][] dataPaket1, String[][] dataPengiriman1, int k1, int b, boolean loginBerhasil,
            double[][] dataPaket2, String[][] dataPengiriman2, int k2, String[][] dataPengiriman3, double[][] dataPaket3, int k3) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (loginBerhasil) {
                System.out.println("1. Menampilkan semua riwayat");
                System.out.println("2. Menampilkan laporan Bulanan");
                System.out.println("3. Keluar");

                System.out.print("Masukan pilihan: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Pilih admin");
                    System.out.println("1.Admin 1");
                    System.out.println("2.Admin 2");
                    System.out.print("Masukan pilihan anda: ");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        pencarianRiwayat(scanner, dataPengiriman1, dataPaket1, k1);
                        break;
                    } else if (choice == 2) {
                        pencarianRiwayat(scanner, dataPengiriman2, dataPaket2, k2);
                    }
                } else if (choice == 2) {
                    System.out.println("Pilih : ");
                    System.out.println("1.Admin 1");
                    System.out.println("2.Admin 2");
                    System.out.println("3.Pelanggan");
                    System.out.println("4.Keluar");
                    System.out.print("Masukan pilihan anda: ");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        laporanAdmin(dataPengiriman1, dataPaket1, k1);
                    } else if (choice == 2) {
                        laporanAdmin(dataPengiriman2, dataPaket2, k2);
                    } else if (choice==3){
                        laporanPelanggan(dataPengiriman3, dataPaket3, k3);
                    }
                } else if (choice==3){
                    break;
                }
            }
        }

    }

    static void pencarianRiwayat(Scanner scanner, String[][] dataPengiriman, double[][] dataPaket, int k) {
        while (true) {
            // ... Bagian untuk riwayat pembelian ...
            System.out.println(" ======================================");
            System.out.println("|1.Lewat nama pengirim                 |");
            System.out.println("|2.Lewat no Hp pengirim                |");
            System.out.println("|3.Lewat nama penerima                 |");
            System.out.println("|4.Lewat no Hp penerima                |");
            System.out.println("|5.Lewat alamat penerima               |");
            System.out.println("|6.Lewat no resi                       |");
            System.out.println("|7.Jumlah riwayat                      |");
            System.out.println("|8.Menampilkan riwayat                 |");
            System.out.println("|9.Kembali                             |");
            System.out.println(" ======================================");
            System.out.print("Pilihan Anda : ");
            int pil = scanner.nextInt();

            if (pil == 1) {
                System.out.print("Masukan nama pengirim : ");
                String namaPengirim = scanner.next();
                System.out.println("======================================");
                tampilRiwayat(pil, namaPengirim, dataPengiriman, dataPaket, k);

            } else if (pil == 2) {
                System.out.print("Masukan no hp pengirim : ");
                String nomorPengirim = scanner.next();
                System.out.println("======================================");
                tampilRiwayat(pil, nomorPengirim, dataPengiriman, dataPaket, k);

            } else if (pil == 3) {
                System.out.print("Masukan nama penerima : ");
                String namaPenerima = scanner.next();
                System.out.println("======================================");
                tampilRiwayat(pil, namaPenerima, dataPengiriman, dataPaket, k);

            } else if (pil == 4) {
                System.out.print("Masukan no hp penerima : ");
                String nomorPenerima = scanner.next();
                System.out.println("======================================");
                tampilRiwayat(pil, nomorPenerima, dataPengiriman, dataPaket, k);

            } else if (pil == 5) {
                System.out.print("Masukan alamat penerima : ");
                String alamatPenerima = scanner.next();
                System.out.println("======================================");
                tampilRiwayat(pil, alamatPenerima, dataPengiriman, dataPaket, k);

            } else if (pil == 6) {
                System.out.print("Masukan no resi : ");
                String noResi = scanner.next();
                System.out.println("======================================");
                tampilRiwayat(pil, noResi, dataPengiriman, dataPaket, k);

            } else if (pil == 7) {
                System.out.println("======================================");
                System.err.println("Jumlah Transaksi : " + dataPengiriman[1].length);

            } else if (pil == 8) {
                System.out.println("======================================");
                System.out.println("Menampilkan semua riwayat:");
                for (int i = 0; i < k; i++) {
                    System.out.println("======================================");
                    System.out.println("Data pengiriman ke-" + (i + 1));
                    for (int j = 0; j < dataPengiriman.length - 1; j++) {
                        System.out.println("Nama Pengirim    : " + dataPengiriman[j][i]);
                        System.out.println("No Hp Pengirim   : " + dataPengiriman[j + 1][i]);
                        System.out.println("Nama Penerima    : " + dataPengiriman[j + 2][i]);
                        System.out.println("No Hp Penerima   : " + dataPengiriman[j + 3][i]);
                        System.out.println("Alamat Penerima  : " + dataPengiriman[j + 4][i]);
                        System.out.println("No Resi          : " + dataPengiriman[j + 5][i]);
                        System.out.println("Biaya Pengiriman : " + dataPaket[j][i]);
                        System.out.println("Berat Paket      : " + dataPaket[j + 1][i]);
                        System.out.println("Jarak Pengiriman : " + dataPaket[j + 2][i]);
                        break;
                    }
                }

            } else if (pil == 9) {
                System.out.println("======================================");
                break;
            }
        }
    }

    static int login(String[][] logindata) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nama pengguna : ");
            String user = input.nextLine();
            System.out.print("Masukkan kata sandi    : ");
            String pass = input.nextLine();
            if (user.equalsIgnoreCase("q") || pass.equalsIgnoreCase("q")) {
                return 0;
            }
            for (int i = 0; i < logindata.length; i++) {
                if (user.equalsIgnoreCase(logindata[i][0]) && pass.equals(logindata[i][1])) {
                    System.out.println("===========================================");
                    System.out.println("Login berhasil!");
                    System.out.println("===========================================");

                    return i + 1;
                }
            }
            System.out.println("Username atau Kata sandi salah");
            return 0;
        }
    }

    static void tampilRiwayat(int pil, String data, String[][] dataPengiriman, double[][] dataPaket, int k) {
        boolean riwayatDitemukan = false;
        for (int i = 0; i < k; i++) {
            for (int j = pil - 1;;) {
                if (data.equalsIgnoreCase(dataPengiriman[j][i])) {
                    System.out.println("Nama Pengirim    : " + dataPengiriman[j][i]);
                    System.out.println("No Hp Pengirim   : " + dataPengiriman[j + 1][i]);
                    System.out.println("Nama Penerima    : " + dataPengiriman[j + 2][i]);
                    System.out.println("No Hp Penerima   : " + dataPengiriman[j + 3][i]);
                    System.out.println("Alamat Penerima  : " + dataPengiriman[j + 4][i]);
                    System.out.println("No Resi          : " + dataPengiriman[j + 5][i]);
                    System.out.println("Biaya Pengiriman : " + dataPaket[j][i]);
                    System.out.println("Berat Paket      : " + dataPaket[j + 1][i]);
                    System.out.println("Jarak Pengiriman : " + dataPaket[j + 2][i]);
                    riwayatDitemukan = true;
                    break;
                }
            }
            if (riwayatDitemukan) {
                break;
            }
        }
        if (!riwayatDitemukan) {
            System.out.println("Riwayat tidak ditemukan.");
        }
    }

    static double biayaPengiriman(double berat, double jarak, double panjang, double lebar, double tinggi,
            double layanan) {
        double dimensi, biayaPengiriman, diskon, total;
        biayaPengiriman = berat * 10 + jarak * 5 + panjang * 5 + lebar * 5 + tinggi * 5;
        dimensi = panjang * tinggi * lebar;
        diskon = 0;
        if (layanan == 1) {
            if (jarak > 1000) {
                if (berat < 2000) {
                    if (dimensi < 600) {
                        diskon = 3 * 0.05;
                    } else {
                        diskon = 2 * 0.05;
                    }
                } else {
                    diskon = 0.05;
                }
            }
            total = biayaPengiriman - (biayaPengiriman * diskon);

        } else {
            total = biayaPengiriman + (biayaPengiriman * (50 / 100));
        }
        return total;
    }

    static void melacakPaket(String[][] dataPengiriman, int k, String [] sampai) {
        while (true) {
            Scanner input = new Scanner(System.in);
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            System.out.print("Masukkan No Resi yang ingin dikonfirmasi: ");
            String resi = input.nextLine();
            boolean riwayatDitemukan = false;
            for (int i = 0; i < dataPengiriman[5].length; i++) {
                for (int j = 0; j < dataPengiriman.length; j++) {
                    if (resi.equalsIgnoreCase(dataPengiriman[5][i])) {
                        System.out.println( " ");
                        System.out.println("No. Resi                   " + dataPengiriman[j + 5][i]);
                        System.out.println("- " + date + " " + time + " Pesanan Dibuat");
                        System.out.println("|");
                        LocalTime time2 = time.plusHours(2);
                        System.out.println("- " + date + " " + time2 + " Pesanan telah dibawa oleh kurir menuju "
                                + dataPengiriman[j + 4][i]);
                        System.out.println("|");
                        LocalDate date2 = date.plusDays(1);
                        LocalTime time3 = time2.plusHours(3);
                        System.out.println("- " + date2 + " " + time3
                                + " Pesanan telah berada dilokasi transit Hub terakhir " + dataPengiriman[j + 4][i]);
                        System.out.println("|");
                        LocalTime time4 = time3.plusHours(5);
                        System.out.println("- " + date2 + " " + time4 + " Paket telah diambil kurir daerah anda");
                        System.out.println("|");
                        
                        if (sampai[i] == dataPengiriman[5][i] ) {
                            LocalTime time5 = time4.plusHours(2);
                            LocalDate date3 = date2.plusDays(1);
                            System.out.println("- " + date3 + " " + time5 + " Paket telah diterima");
                            System.out.println(" ");
                            System.out.println("Terima kasih telah memakai jasa Ekspedisi Dinpur!");
                            riwayatDitemukan = true;
                        } else {
                            System.out.println("Konfirmasi paket belum sampai ke alamat tujuan.");
                            riwayatDitemukan = true;
                        }
                        break;
                    }
                    riwayatDitemukan = false;
                    break;
                }
                if (riwayatDitemukan) {
                    break;
                }
                if (riwayatDitemukan == false) {
                    System.out.println("Paket tidak ada.");
                }

            }
            break;
        }

    }

    static double pembayaran(int bayar, double total) {
        Scanner input = new Scanner(System.in);

        if (bayar == 1) {
            System.out.println("Kirim ke no rekening ini: (bank pur) 92341761128 ");
            System.out.println("1. Sudah");
            System.out.println("2. Batal");
            int rekening = input.nextInt();

            if (rekening == 1) {
                return 0;
            } else {
                return -1;
            }
        } else {
            System.out.println("======================================");
            System.out.print("Masukkan jumlah uang pelanggan : ");
            int uang = input.nextInt();
            double kembalian = uang - total;

            if (kembalian >= 0) {
                return kembalian;
            } else {
                return -1;
            }
        }
    }

    public static void laporanAdmin(String[][] dataPengiriman, double[][] dataPaket, int k) {
        System.out.println("==========================================================================================================");
        System.out.println("                               LAPORAN BULANAN ADMIN EKSPEDISI DINPUR                                     ");
        System.out.println("==========================================================================================================");
    
        // Tanggal laporan
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String today = formatter.format(now);
    
        // Header laporan
        System.out.printf("| %-4s | %-20s | %-20s | %-21s | %-10s | %-13s |\n",
                "NO", "NAMA PENGIRIM", "NAMA PENERIMA", "TANGGAL PENGIRIMAN", "NO RESI", "TOTAL BIAYA");
        System.out.println("----------------------------------------------------------------------------------------------------------");
    
        // Data pengiriman
        double totalBiaya = 0;
        int totalPengiriman = 0;
        for (int i = 0; i <= k-1; i ++) {
            String namaPengirim = dataPengiriman[0][i];
            String namaPenerima = dataPengiriman[2][i];
            String tanggalPengiriman = today;
            String noResi = dataPengiriman[5][i];
            Double biaya = dataPaket[0][i];
        
            totalBiaya += biaya;
            totalPengiriman++;

            System.out.printf("| %-4d | %-20s | %-20s | %-21s | %-10s | %-13s |\n",
            totalPengiriman, namaPengirim, namaPenerima, tanggalPengiriman, noResi, biaya);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("JUMLAH PENGIRIMAN: %d\n", totalPengiriman);
        System.out.printf("TOTAL PENDAPATAN: %s\n", new DecimalFormat("#,###").format(totalBiaya));
        System.out.println("==========================================================================================================");
        }

        public static void laporanPelanggan(String[][] dataPengiriman, double[][] dataPaket, int k) {
        System.out.println("==========================================================================================================");
        System.out.println("                               LAPORAN BULANAN PELANGGAN EKSPEDISI DINPUR                                 ");
        System.out.println("==========================================================================================================");
    
        // Tanggal laporan
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String today = formatter.format(now);
    
        // Header laporan
        System.out.printf("| %-4s | %-20s | %-20s | %-21s | %-10s | %-13s |\n",
                "NO", "NAMA PENGIRIM", "NAMA PENERIMA", "TANGGAL PENGIRIMAN", "NO RESI", "TOTAL BIAYA");
        System.out.println("----------------------------------------------------------------------------------------------------------");
    
        // Data pengiriman
        double totalBiaya = 0;
        int totalPengiriman = 0;
        for (int i = 0; i <= k-1; i ++) {
            String namaPengirim = dataPengiriman[0][i];
            String namaPenerima = dataPengiriman[2][i];
            String tanggalPengiriman = today;
            String noResi = dataPengiriman[5][i];
            Double biaya = dataPaket[0][i];
        
            totalBiaya += biaya;
            totalPengiriman++;

            System.out.printf("| %-4d | %-20s | %-20s | %-21s | %-10s | %-13s |\n",
            totalPengiriman, namaPengirim, namaPenerima, tanggalPengiriman, noResi, biaya);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("JUMLAH PENGIRIMAN: %d\n", totalPengiriman);
        System.out.printf("TOTAL PENDAPATAN: %s\n", new DecimalFormat("#,###").format(totalBiaya));
        System.out.println("==========================================================================================================");
        }
}