import java.time.LocalDate;
import java.util.Scanner;

public class DataDiri {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();


            System.out.print("Masukkan Jenis Kelamin (P/L): ");
            char jenisKelamin = scanner.next().charAt(0);


            System.out.print("Masukkan Tahun Lahir: ");
            int tahunLahir = scanner.nextInt();


            int tahunSekarang = LocalDate.now().getYear();


            int umur = tahunSekarang - tahunLahir;


            String jenisKelaminStr = "";
            if (jenisKelamin == 'L' || jenisKelamin == 'l') {
                jenisKelaminStr = "Laki-laki";
            } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
                jenisKelaminStr = "Perempuan";
            } else {
                System.out.println("Input jenis kelamin tidak valid!");
                return;
            }


            System.out.println("\nData Diri:");
            System.out.println("Nama \t\t  : " + nama);
            System.out.println("Jenis Kelamin : " + jenisKelaminStr);
            System.out.println("Umur \t\t  : " + umur + " tahun");

        }
    }
}