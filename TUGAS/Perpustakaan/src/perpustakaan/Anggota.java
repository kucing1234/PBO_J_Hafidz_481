package perpustakaan;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }


    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " (" + idAnggota + ") meminjam: " + judul);
    }

    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " (" + idAnggota + ") meminjam: " + judul +
                " selama " + durasi + " hari\n");
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " (" + idAnggota + ") mengembalikan: " + judul + "\n");
    }
}
