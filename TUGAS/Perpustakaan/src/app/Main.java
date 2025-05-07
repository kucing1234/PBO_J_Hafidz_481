package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        Buku buku1 = new Fiksi("Cinta Brontosaurus", "Raditya Dika", "Romansa");
        Buku buku2 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah");


        Anggota anggota1 = new Anggota("Hafidz", "2J481");
        Anggota anggota2 = new Anggota("Gatot", "2J451");


        buku1.displayInfo();
        buku2.displayInfo();


        anggota1.pinjamBuku(buku1.getJudul());
        anggota1.pinjamBuku(buku2.getJudul(), 4);
        anggota1.kembalikanBuku(buku1.getJudul());


        anggota2.pinjamBuku(buku2.getJudul());
        anggota2.kembalikanBuku(buku2.getJudul());
    }
}
