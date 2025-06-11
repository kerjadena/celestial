public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("Mahasiswa", "2203456789", 3.5);

        // Menampilkan data awal
        mhs.printInfo();

        // Mengubah data dengan setter
        mhs.setNama("Mahasiswa 1");
        mhs.setIpk(4.2); // Ini tidak valid, akan ditolak
        mhs.setIpk(3.9); // Valid
//        mhs.ipk =

        System.out.println("\nSetelah update:");
        mhs.printInfo();
    }
}