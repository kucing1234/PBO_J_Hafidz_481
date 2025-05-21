package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.item;

import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Admin extends User implements AdminActions {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

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
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n--- Kelola Laporan Barang ---");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

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
                    if (LoginSystem.reportedItems.isEmpty()) {
                        System.out.println("Belum ada laporan barang.");
                    } else {
                        System.out.println("\nDaftar Semua Barang:");
                        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                            item item = LoginSystem.reportedItems.get(i);
                            System.out.println("-----------------------------------");
                            System.out.println("Index      : " + i);
                            System.out.println("Nama Barang: " + item.getItemName());
                            System.out.println("Deskripsi  : " + item.getDescription());
                            System.out.println("Lokasi     : " + item.getLocation());
                            System.out.println("Status     : " + item.getStatus());
                        }
                    }
                    break;

                case 2:
                    if (LoginSystem.reportedItems.isEmpty()) {
                        System.out.println("Belum ada laporan barang.");
                        break;
                    }

                    System.out.println("\nBarang dengan status 'Reported':");
                    boolean adaReported = false;
                    for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                        item item = LoginSystem.reportedItems.get(i);
                        if ("Reported".equalsIgnoreCase(item.getStatus())) {
                            System.out.println(i + ". " + item.getItemName() + " - " + item.getDescription());
                            adaReported = true;
                        }
                    }
                    if (!adaReported) {
                        System.out.println("Tidak ada barang yang perlu ditandai.");
                        break;
                    }

                    System.out.print("Masukkan indeks barang yang ingin ditandai: ");
                    try {
                        int index = scanner.nextInt();
                        scanner.nextLine();

                        item item = LoginSystem.reportedItems.get(index);
                        if (!"Reported".equalsIgnoreCase(item.getStatus())) {
                            System.out.println("Barang sudah ditandai sebelumnya.");
                        } else {
                            item.setStatus("Claimed");
                            System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                    }
                    break;

                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n--- Kelola Data Mahasiswa ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

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
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    String nim = scanner.nextLine();

                    // Cek apakah NIM sudah ada
                    boolean exists = false;
                    for (User user : LoginSystem.userList) {
                        if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Mahasiswa dengan NIM tersebut sudah ada.");
                    } else {
                        Mahasiswa mhsBaru = new Mahasiswa(nama, nim);
                        LoginSystem.userList.add(mhsBaru);
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();

                    Iterator<User> iterator = LoginSystem.userList.iterator();
                    boolean found = false;
                    while (iterator.hasNext()) {
                        User user = iterator.next();
                        if (user instanceof Mahasiswa && user.getNim().equals(nimHapus)) {
                            iterator.remove();
                            found = true;
                            System.out.println("Mahasiswa berhasil dihapus.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                    break;

                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
