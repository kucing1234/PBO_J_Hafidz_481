import java.util.Scanner;

public class LoginUtama {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Pilih Jenis Login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Admin admin = new Admin();
                    System.out.print("Masukkan Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String password = scanner.nextLine();

                    if (admin.login(username, password)) {
                        System.out.println("Login Admin berhasil!");
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                    }
                }
                case 2 -> {
                    Mahasiswa mahasiswa = new Mahasiswa();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    if (mahasiswa.login(nama, nim)) {
                        System.out.println("Login Mahasiswa berhasil!");
                        mahasiswa.displayInfo();
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

class Admin {
    String username = "Admin123";
    String password = "Password123";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}

class Mahasiswa {
    String nama = "K";
    String nim = "2";

    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(nama) && inputNim.equals(nim);
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}