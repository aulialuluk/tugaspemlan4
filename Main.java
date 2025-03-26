import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("=== SELAMAT DATANG DI SWALAYAN TINY ===");

        System.out.print("Nama: ");
        String nama = io.nextLine();
        System.out.print("Nomor pelanggan: ");
        String noPelanggan = io.nextLine();
        System.out.print("Pin: ");
        String pin = io.nextLine();

        Akun akun = new Akun(400000, nama, noPelanggan, pin); 

        while (true) {
            System.out.println("========== MENU ===========");
            System.out.println("1. Top Up");
            System.out.println("2. Belanja");
            System.out.println("3. Keluar");
            System.out.print("Opsi: ");
            int pilihan = io.nextInt();

            if (pilihan == 1) {
                System.out.print("Jumlah top up: ");
                double jumlah = io.nextDouble();
                System.out.print("PIN: ");
                String inputPin = io.next();
                if (akun.autentikasi(inputPin)) {
                    akun.setSaldo(akun.getSaldo() + jumlah);
                    System.out.println("Top up berhasil Saldo baru: Rp" + String.format("%,.2f", akun.getSaldo()));
                }
            } else if (pilihan == 2) {
                System.out.print("Jumlah pembelian: ");
                double jumlah = io.nextDouble();
                System.out.print("PIN: ");
                String inputPin = io.next();
                Transaksi.beli(akun, jumlah, inputPin);
            } else if (pilihan == 3) {
                System.out.println("======= Terima kasih ======");
                break;
            } else {
                System.out.println("Maaf terjadi kesalahan");
            }
        }

        io.close(); 
    }
}
