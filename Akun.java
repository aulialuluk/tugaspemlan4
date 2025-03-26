public class Akun {
    private double saldo;
    private String nama;
    private String noPelanggan;
    private String pin;
    private boolean Block = false; // Menandai apakah akun diblokir
    private int salahPin = 0; // Counter untuk kesalahan PIN

    public Akun(double saldo, String nama, String noPelanggan, String pin) {
        this.saldo = saldo;
        this.nama = nama;
        this.noPelanggan = noPelanggan;
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }

    public String getNoPelanggan() {
        return noPelanggan;
    }

    public String getPin() {
        return pin;
    }

    public boolean isBlocked() {
        return Block;
    }

    public boolean autentikasi(String inputPin) {
        if (Block) {
            System.out.println("Akun Anda telah diblokir Transaksi tidak dapat dilakukan.");
            return false;
        }

        if (inputPin.equals(pin)) {
            salahPin = 0;
            return true;
        } else {
            salahPin++;
            System.out.println("PIN salah. Kesempatan tersisa: " + (3 - salahPin));
            if (salahPin >= 3) {
                Block = true;
                System.out.println("Akun Anda telah diblokir karena salah memasukkan PIN.");
            }
            return false;
        }
    }

    public String getJenisAkun() {
        String digitAwal = noPelanggan.substring(0, 2);
        switch (digitAwal) {
            case "38": return "Silver";
            case "56": return "Gold";
            case "74": return "Platinum";
            default: return "Reguler";
        }
    }
}
