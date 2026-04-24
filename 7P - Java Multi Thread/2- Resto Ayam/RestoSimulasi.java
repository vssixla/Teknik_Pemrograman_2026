class Resto {

    //Variabel untuk menyimpan stok ayam
    //SOLUSI: menggunakan 'private' untuk menjaga enkapsulasi (tidak bisa diakses langsung dari luar)
    private int chickenStock = 100;

    //SOLUSI UTAMA: keyword 'synchronized', hanya 1 thread yang bisa masuk ke method ini dalam satu waktu
    public synchronized void serveCustomer(String cashierName) {

        if (chickenStock > 0) {

            try {
                //Memberikan delay simulasi proses pelayanan dan
                //method sudah synchronized (thread lain harus menunggu)
                Thread.sleep(10);
            } catch (InterruptedException e) {
                //Menangani jika thread di-interrupt
                Thread.currentThread().interrupt();
            }

            //Mengurangi stok ayam sebanyak 1
            //SOLUSI: dilakukan dalam kondisi aman (tidak bisa diakses bersamaan oleh thread lain)
            chickenStock--;

            //Menampilkan informasi bahwa transaksi berhasil
            System.out.println(cashierName + 
                " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);

        } else {

            //Jika stok habis, menampilkan pesan gagal
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    //Method untuk mengambil sisa stok 
    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {

    public static void main(String[] args) throws InterruptedException {

        //Membuat objek restoran 
        Resto ayamJuicyLuicyGallagher = new Resto();

        //Membuat task (pekerjaan) yang akan dijalankan oleh setiap thread
        Runnable task = () -> {

            //Looping untuk mensimulasikan banyak pelanggan
            //SOLUSI: setiap kasir mencoba melayani hingga 100 kali
            for (int i = 0; i < 30; i++) {

                //Memanggil method serveCustomer
                //Thread akan mengirimkan nama kasirnya masing-masing
                ayamJuicyLuicyGallagher
                    .serveCustomer(Thread.currentThread().getName());
            }
        };

        //Membuat 3 thread sebagai kasir
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        //Menjalankan thread pertama
        kasir1.start();

        //Menjalankan thread kedua dan ketiga
        kasir2.start();
        kasir3.start();

        //Menunggu semua thread selesai sebelum lanjut ke bawah
        //SOLUSI: memastikan hasil akhir tidak dicetak sebelum proses selesai
        kasir1.join();
        kasir2.join();
        kasir3.join();

        //Menampilkan hasil akhir stok ayam
        System.out.println("--- HASIL AKHIR STOK: " + 
            ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}