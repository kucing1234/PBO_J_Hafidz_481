package com.praktikum.main;
import com.praktikum.users.*;
import com.praktikum.models.item;
import com.praktikum.users.Mahasiswa;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LoginSystem {
    // Penyimpanan data global
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        initDefaultUsers();

        System.out.println("=== Sistem Login ===");

        User loggedInUser = null;

        while (loggedInUser == null) {
            System.out.println("Pilih Role:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan (1 atau 2): ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String password = scanner.nextLine();

                    loggedInUser = loginAdmin(username, password);
                    if (loggedInUser == null) {
                        System.out.println("Login gagal. Username atau password salah.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    loggedInUser = loginMahasiswa(nama, nim);
                    if (loggedInUser == null) {
                        System.out.println("Login gagal. Nama atau NIM salah.");
                    }
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("Login berhasil. Selamat datang, " + loggedInUser.getNama() + "!");
        loggedInUser.displayAppMenu();

        scanner.close();
        System.out.println("Program selesai.");
    }

    private static void initDefaultUsers() {

        userList.add(new Admin("Administrator", "ADM001", "admin", "password"));


        userList.add(new Mahasiswa("Budi Santoso", "MHS123"));
        userList.add(new Mahasiswa("Siti Aminah", "MHS124"));
    }

    private static User loginAdmin(String username, String password) {
        for (User user : userList) {
            if (user instanceof Admin admin) {
                if (admin.login(username, password)) {
                    return admin;
                }
            }
        }
        return null;
    }

    private static User loginMahasiswa(String nama, String nim) {
        for (User user : userList) {
            if (user instanceof Mahasiswa mhs) {
                if (mhs.login(nama, nim)) {
                    return mhs;
                }
            }
        }
        return null;
    }
}
