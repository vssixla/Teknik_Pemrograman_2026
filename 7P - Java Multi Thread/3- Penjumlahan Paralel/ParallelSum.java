// Class SumTask merepresentasikan 1 thread untuk menghitung sebagian angka
class SumTask extends Thread {

    //Menyimpan batas awal dan akhir perhitungan
    private int start, end;
    //Menyimpan hasil penjumlahan parsial dari thread ini
    private int partialSum;
    // Constructor untuk inisialisasi range dan nama thread
    public SumTask(int start, int end, String name) {
        // Memberikan nama thread (Thread 1, Thread 2, dst)
        super(name);
        //Menyimpan nilai awal range
        this.start = start;
        //Menyimpan nilai akhir range
        this.end = end;
    }

    //Method run()  yang dijalankan thread
    public void run() {
        //Inisialisasi hasil parsial
        partialSum = 0;
        //Loop untuk menjumlahkan angka dari start sampai end
        for (int i = start; i <= end; i++) {
            //Menambahkan nilai i ke dalam partialSum
            partialSum += i;
        }
    }
    //Mengembalikan hasil parsial thread
    public int getPartialSum() {
        return partialSum;
    }
    //Mengambil nilai awal range (untuk ditampilkan)
    public int getStartRange() {
        return start;
    }
    //Mengambil nilai akhir range (untuk ditampilkan)
    public int getEndRange() {
        return end;
    }
}

public class ParallelSum {

    public static void main(String[] args) throws InterruptedException {
        int jumlahThread = 4; //Menentukan banyak thread
        int angkaAkhir = 1000; //Menentukan angka akhir penjumlahan

        //Array untuk menyimpan semua thread
        SumTask[] threads = new SumTask[jumlahThread];

        //SOLUSI: Membagi beban kerja (Divide and Conquer)
        int range = angkaAkhir / jumlahThread;
        int start = 1;  //Nilai awal dimulai dari 1

        System.out.println("====== PENJUMLAHAN PARALEL ======");
        System.out.println("*** Jumlah Thread = " + jumlahThread); //Menampilkan jumlah thread
        System.out.println("*** Angka Akhir = " + angkaAkhir + "\n"); //Menampilkan angka akhir
        System.out.println("======== PEMBAGIAN TUGAS ========");

        //Loop untuk membuat dan menjalankan thread
        for (int i = 0; i < jumlahThread; i++) {

            //SOLUSI: Mengatur pembagian range per thread
            // Thread terakhir menangani sisa jika tidak habis dibagi
            int end = (i == jumlahThread - 1) ? angkaAkhir : start + range - 1;

            //Membuat thread dengan range tertentu
            threads[i] = new SumTask(start, end, "Thread " + (i + 1));

            System.out.println(threads[i].getName() + //Menampilkan tugas thread
                ": Menjumlahkan " + start + "-" + end);

            threads[i].start(); //SOLUSI: Menjalankan thread secara paralel
            start = end + 1; //Mengatur start berikutnya
        }

        //SOLUSI: Menunggu semua thread selesai (sinkronisasi)
        for (int i = 0; i < jumlahThread; i++) {
            threads[i].join();
        }

        System.out.println("\n========= HASIL PARSIAL ========="); //Menampilkan hasil parsial
        int total = 0;

        //Loop untuk mengambil hasil dari setiap thread
        for (int i = 0; i < jumlahThread; i++) {
            //Mengambil hasil parsial dari thread ke-i
            int partial = threads[i].getPartialSum();
            //Menampilkan hasil parsial
            System.out.println("Hasil Parsial " + threads[i].getName()
                + " : " + partial);
            total += partial; //SOLUSI: Menjumlahkan hasil parsial ke total akhir
        }

        System.out.println("\n========== HASIL AKHIR ==========");
        System.out.println("JUMLAH PARSIAL : " + total);
    }
}