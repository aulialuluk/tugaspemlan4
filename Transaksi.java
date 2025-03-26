public class Transaksi {
    private static final int MIN_TRANSAKSI = 10000;
    private int salahPin = 0;
    private boolean autentikasi = false;

     public boolean autentikasi(String pin, String pinAkun) {
        if (pinAkun.equals(pin)) {
            autentikasi = true;
        } else {
            salahPin++;
            if (salahPin == 3) {
                System.out.println("Akun diblokir");
            }
        }
        return autentikasi;
    }

     public static void beli(Akun akun, double jumlah, String inputPin) {
        if (!akun.autentikasi(inputPin)) {
            return; 
        }

        if (jumlah < MIN_TRANSAKSI) {
            System.out.println("Jumlah transaksi minimal adalah Rp" + MIN_TRANSAKSI);
            return;
        }

        if (akun.getSaldo() < jumlah) {
            System.out.println("Saldo tidak mencukupi");
            return;
        }

        double saldoSetelahTransaksi = akun.getSaldo() - jumlah;
        double cashback = hitungCashback(akun, jumlah);
        double saldoAkhir = saldoSetelahTransaksi + cashback;

        akun.setSaldo(saldoAkhir);

        System.out.println("Pembelian berhasil.");
        System.out.println("Total pembelian: Rp" + String.format("%,.2f", jumlah));
        if (cashback > 0) {
            System.out.println("Anda mendapatkan cashback: Rp" + String.format("%,.2f", cashback));
        }
        System.out.println("Saldo baru: Rp" + String.format("%,.2f", saldoAkhir));
    }

    private static double hitungCashback(Akun akun, double jumlah) {
        String jenisAkun = akun.getJenisAkun();
        double cashback = 0;

        switch (jenisAkun) {
            case "Silver":
                if (jumlah > 1000000) {
                    cashback = jumlah * 0.05;
                }
                break;
            case "Gold":
                if (jumlah > 1000000) {
                    cashback = jumlah * 0.07;
                } else {
                    cashback = jumlah * 0.02;
                }
                break;
            case "Platinum":
                if (jumlah > 1000000) {
                    cashback = jumlah * 0.10;
                } else {
                    cashback = jumlah * 0.05;
                }
                break;
        }

        return cashback;
    }
}
