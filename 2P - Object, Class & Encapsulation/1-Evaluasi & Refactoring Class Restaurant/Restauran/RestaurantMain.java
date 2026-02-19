import java.util.Scanner;

public class RestaurantMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        menu.tampilMenuMakanan();

        System.out.println("\n=== PEMESANAN ===");
        System.out.print("Pilih nomor menu: ");
        int nomor = input.nextInt();

        System.out.print("Masukkan jumlah pesanan: ");
        int jumlah = input.nextInt();

        menu.pesanMenu(nomor, jumlah);

        System.out.println("\n=============== MENU SETELAH PEMESANAN ===============");
        menu.tampilMenuMakanan();

        input.close();
    }
}
