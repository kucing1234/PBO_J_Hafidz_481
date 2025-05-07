package perpustakaan;

public class Fiksi extends Buku {
    private String genre;

    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("[BUKU FIKSI]");
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Genre: " + genre + "\n");
    }
}
