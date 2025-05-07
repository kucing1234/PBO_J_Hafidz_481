
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Admin admin = new Admin("Admin Utama", "AU001", "admin", "admin123");
        Mahasiswa mhs = new Mahasiswa("Hafidz", "481");


        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login Admin");
        System.out.println("2. Login Mahasiswa");
        System.out.print("Pilih menu: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch(pilihan) {
            case 1:
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if(admin.login(username, password)) {
                    admin.displayInfo();
                } else {
                    System.out.println("Login gagal! Kredensial tidak valid");
                }
                break;

            case 2:
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("NIM: ");
                String nim = scanner.nextLine();

                if(mhs1.login(nama, nim)) {
                    mhs1.displayInfo();
                } else {
                    System.out.println("Login gagal! Data tidak ditemukan");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }
        scanner.close();
    }
}
