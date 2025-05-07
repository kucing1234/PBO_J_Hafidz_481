package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin", "0000", "admin123", "adminpass");
        Mahasiswa mahasiswa = new Mahasiswa("Budi", "123456");

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        User currentUser = null;
        boolean loginBerhasil = false;

        if (pilihan == 1) {
            System.out.print("Masukkan Username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan Password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                currentUser = admin;
                loginBerhasil = true;
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.login(nama, nim)) {
                currentUser = mahasiswa;
                loginBerhasil = true;
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        if (loginBerhasil && currentUser != null) {
            System.out.println("Login berhasil.\n");
            currentUser.displayAppMenu(); // Polymorphic call
        } else {
            System.out.println("Login gagal. Periksa kembali input Anda.");
        }
    }
}
