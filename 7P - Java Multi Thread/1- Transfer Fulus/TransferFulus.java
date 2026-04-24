public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {

        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: transfer dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 terlebih dahulu (lock pertama)
                synchronized (acc2) { // Mengunci acc2 setelah acc1 (lock kedua)
                    
                    System.out.println("Thread 1: Transfer dari acc1 ke acc2");

                    int amount = 50;  // jumlah uang yang akan ditransfer

                    // Validasi saldo cukup (SOLUSI UNTUK LOGIKA TRANSFER)
                    if (acc1.balance >= amount) {
                        acc1.balance -= amount; // Kurangi dari sumber
                        acc2.balance += amount; // Tambah ke tujuan
                    } else {
                        System.out.println("Saldo acc1 tidak cukup!");
                    }
                }
            }
        });

        // Thread 2: transfer dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // SOLUSI : disamakan, tetap lock acc1 dulu
                synchronized (acc2) { //Mengunci acc2 setelah acc1
                    
                    System.out.println("Thread 2: Transfer dari acc2 ke acc1");

                    int amount = 30;

                    //SOLUSI : logika transfer
                    if (acc2.balance >= amount) {
                        acc2.balance -= amount;
                        acc1.balance += amount;
                    } else {
                        System.out.println("Saldo acc2 tidak cukup!");
                    }
                }
            }
        });

        //Menjalankan kedua thread secara concurrent
        t1.start(); 
        t2.start();

        //Menunggu kedua thread selesai sebelum lanjut
        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}