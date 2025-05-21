package com.praktikum.users;

// Kelas User sebagai abstract class
public abstract class User {
    private final String nama;
    private final String nim;

    // Constructor untuk inisialisasi nama dan nim
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter dan Setter untuk nim
    public String getNim() {
        return nim;
    }


    public abstract boolean login(String id, String pass);


    public abstract void displayAppMenu();


}
