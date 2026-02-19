public class Restaurant {
    
    // 1. Semua attribute harus bersifat private  ==============
    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int id = 0; // tidak perlu static lagi

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
    }

    //  2. Akses data menggunakan Getter (Data Access Control)
    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public int getStok(int index) {
        return stok[index];
    }

    // 2. Setter dengan Validasi
    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) { // Mencegah stok nilai negatif
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    // 3. Validasi Stok Saat Menambahkan Menu
    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {
        if (stokAwal < 0) { //Kalau stok < 0 tidak bisa
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        namaMakanan[id] = nama;
        hargaMakanan[id] = harga;
        stok[id] = stokAwal;
        id++; // otomatis bertambah
    }

    // Untuk menampilkan daftar menu
    public void tampilMenuMakanan() {
        System.out.println("==================== DAFTAR MENU =====================");

        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.printf(
                    "%-3d %-20s [%3d] %15s %,.0f\n",
                    i,
                    namaMakanan[i],
                    stok[i],
                    "Rp.",
                    hargaMakanan[i]
                );
            }
        }   
    }

    // Untuk Cek stok habis
    private boolean isOutOfStock(int index) {
        return stok[index] == 0;
    }

    // 4. Pengembangan Fitur (Mini Case)
    public void pesanMenu(int index, int jumlah) {
        if (index < 0 || index >= id) { // Validasi index menu 
            System.out.println("Menu tidak ditemukan!");
            return;
        }
        if (jumlah <= 0) { // Validasi jumlah pesanan 
            System.out.println("Jumlah pesanan tidak valid!");
            return;
        }

        // Validasi ketersediaan stok
        if (stok[index] >= jumlah) {
            stok[index] -= jumlah;  // b) Stok otomatis berkurang
            System.out.println("Pesanan berhasil! Total bayar: Rp. "  
                + (hargaMakanan[index] * jumlah));  // Menampilkan total pembayaran
        } else { // c) Pesanan ditolak jika stok tidak cukup
            System.out.println("Pesanan ditolak! Stok tidak mencukupi.");
        }
    }
}
