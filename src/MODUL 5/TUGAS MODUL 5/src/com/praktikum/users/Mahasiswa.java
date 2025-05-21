package com.praktikum.users;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.item;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String nama, String nim) {
        return getNama().equals(nama) && getNim().equals(nim);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // bersihkan newline
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
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
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();

        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        item itemBaru = new item(namaBarang, deskripsi, lokasi);
        LoginSystem.reportedItems.add(itemBaru);

        System.out.println("Laporan barang berhasil diterima.");
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("\nDaftar Barang yang Dilaporkan (Status: Reported):");
        boolean adaReported = false;
        for (com.praktikum.models.item item : LoginSystem.reportedItems) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                System.out.println("-----------------------------------");
                System.out.println("Nama Barang : " + item.getItemName());
                System.out.println("Deskripsi   : " + item.getDescription());
                System.out.println("Lokasi      : " + item.getLocation());
                System.out.println("Status      : " + item.getStatus());
                adaReported = true;
            }
        }
        if (!adaReported) {
            System.out.println("Tidak ada barang dengan status 'Reported'.");
        }
    }
}
