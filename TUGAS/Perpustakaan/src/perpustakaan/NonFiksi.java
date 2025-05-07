package perpustakaan;

public class NonFiksi extends Buku {
    private String topik;

    public NonFiksi(String judul, String penulis, String topik) {
        super(judul, penulis);
        this.topik = topik;
    }

    @Override
    public void displayInfo() {
        System.out.println("[BUKU NON-FIKSI]");
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Topik: " + topik + "\n");
    }
}
