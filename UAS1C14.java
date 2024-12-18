import java.util.Scanner;

public class UAS1C14 {
    static String[] namaTim14;
    static int[][] skorTim14;
    static int jumlahTim14;
    static Scanner sc14 = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan14;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Score Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan14 = sc14.nextInt();
            sc14.nextLine();

            switch (pilihan14) {
                case 1 -> inputDataSkor14();
                case 2 -> tampilkanTabelSkor14();
                case 3 -> tentukanJuara14();
                case 4 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan14 != 4);
    }

    static void inputDataSkor14() {
        int nimAkhir14 = 18 % 3;
        jumlahTim14 = (nimAkhir14 % 3) + 4;
        System.out.println("Jumlah tim: " + jumlahTim14);

        namaTim14 = new String[jumlahTim14];
        skorTim14 = new int[jumlahTim14][2];

        for (int i = 0; i < jumlahTim14; i++) {
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            namaTim14[i] = sc14.nextLine();

            System.out.print("Masukkan skor tim ke-" + (i + 1) + " untuk Level 1: ");
            skorTim14[i][0] = sc14.nextInt();
            sc14.nextLine();

            if (skorTim14[i][0] < 0) {
                System.out.println("Skor harus bilangan positif atau nol.");
                i--;
                continue;
            }

            if (skorTim14[i][0] < 35) {
                System.out.println("Skor di Level 1 kurang dari 35, maka skor tersebut dianggap nol.");
                skorTim14[i][0] = 0;
            }

            System.out.print("Masukkan skor tim ke-" + (i + 1) + " untuk Level 2: ");
            skorTim14[i][1] = sc14.nextInt();
            sc14.nextLine();

            if (skorTim14[i][1] < 0) {
                System.out.println("Skor harus bilangan positif atau nol.");
                i--;
            }
        }
    }

    static void tampilkanTabelSkor14() {
        if (namaTim14 == null || skorTim14 == null) {
            System.out.println("Data skor belum diinput. Silakan input data terlebih dahulu.");
            return;
        }
    
        int nomorAbsen14 = 14;
        System.out.println("\n=== Tabel Skor ===");
        System.out.println("Nama Tim\tLevel 1\tLevel 2\tTotal Skor");
    
        for (int i = 0; i < jumlahTim14; i++) {
            int totalSkor14 = skorTim14[i][0] + skorTim14[i][1];
    
            if (totalSkor14 % 2 == 0) {
                totalSkor14 -= 15;
            }
    
            if (skorTim14[i][0] > 50 && skorTim14[i][1] > 50) {
                totalSkor14 += nomorAbsen14;
            }
    
            System.out.printf("%s\t\t%d\t%d\t%d\n", namaTim14[i], skorTim14[i][0], skorTim14[i][1], totalSkor14);
        }
    }
    

    static void tentukanJuara14() {
        if (namaTim14 == null || skorTim14 == null) {
            System.out.println("Data skor belum diinput. Silakan input data terlebih dahulu.");
            return;
        }

        int skorTertinggi14 = 0;
        int pemenang14 = -1;
        boolean seri14 = false;

        for (int i = 0; i < jumlahTim14; i++) {
            int totalSkor14 = skorTim14[i][0] + skorTim14[i][1];

            if (totalSkor14 > skorTertinggi14) {
                skorTertinggi14 = totalSkor14;
                pemenang14 = i;
                seri14 = false;
            } else if (totalSkor14 == skorTertinggi14) {
                if (skorTim14[i][1] > skorTim14[pemenang14][1]) {
                    pemenang14 = i;
                    seri14 = false;
                } else if (skorTim14[i][1] == skorTim14[pemenang14][1]) {
                    seri14 = true;
                }
            }
        }

        if (seri14) {
            System.out.println("Turnamen berakhir seri. Tim terbaik adalah WILDAN ");
        } else {
            System.out.println("Selamat kepada Tim " + namaTim14[pemenang14] + " yang telah memenangkan kompetisi");
        }
    }
}
