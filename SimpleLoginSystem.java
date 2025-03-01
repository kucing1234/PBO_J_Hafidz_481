import java.util.Scanner;

public class SimpleLoginSystem {
    public static void main(String[] args) {
        // Menampilkan pilihan login
        try (Scanner scanner = new Scanner(System.in)) {
            // Menampilkan pilihan login
            System.out.println("Pilih Jenis Login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // membersihkan newline
            // Mengecek jenis login
            switch (pilihan) {
                case 1 -> {
                    // Login Admin
                    System.out.print("Masukkan Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String password = scanner.nextLine();
                    // Validasi username dan password admin
                    if (username.equals("Admin010") && password.equals("password010")) {
                        System.out.println("Login Admin berhasil!");
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                    }
                }
                case 2 -> {
                    // Login Mahasiswa
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    // Validasi nama dan NIM mahasiswa
                    if (nama.equals("K") && nim.equals("2")) {
                        System.out.println("Login Mahasiswa berhasil!");
                        System.out.println("Nama: " + nama);
                        System.out.println("NIM: " + nim);
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                }
                default -> // Pilihan tidak valid
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
