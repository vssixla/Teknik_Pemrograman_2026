import java.util.*;
import java.math.BigInteger;

public class Bilangan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inputkan banyak bilangan yang akan diperiksa: ");
        int banyak_bilangan = sc.nextInt(); //Prose input banyak bilangan yang akan diperiksa

        System.out.print("Inputkan bilangan yang akan dicek: \n"); 

        for (int i = 0; i < banyak_bilangan; i++) { 
            String nilai_bilangan = sc.next();  //Proses menginputkan banyak bilngan yang akan dicek
            //Proses dilakukan berulang sebanyak banyak bilanga yang diinputkan

            //Program akan mendeteksi langsung penyimpanan suatu jenis bilangan
            BigInteger banyak_angka = new BigInteger(nilai_bilangan);

            BigInteger byteMin = BigInteger.valueOf(Byte.MIN_VALUE);
            BigInteger byteMax = BigInteger.valueOf(Byte.MAX_VALUE);

            BigInteger shortMin = BigInteger.valueOf(Short.MIN_VALUE);
            BigInteger shortMax = BigInteger.valueOf(Short.MAX_VALUE);

            BigInteger intMin = BigInteger.valueOf(Integer.MIN_VALUE);
            BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);

            BigInteger longMin = BigInteger.valueOf(Long.MIN_VALUE);
            BigInteger longMax = BigInteger.valueOf(Long.MAX_VALUE);
            
            //Proses pemeriksaan bilangan sekaligus output yang akan keluar
            if (banyak_angka.compareTo(longMin) < 0 || banyak_angka.compareTo(longMax) > 0) {
                System.out.println(nilai_bilangan + " can't be fitted anywhere.");
            } else {
                System.out.println(nilai_bilangan + " can be fitted in:");

                if (banyak_angka.compareTo(byteMin) >= 0 && banyak_angka.compareTo(byteMax) <= 0) {
                    System.out.println("* byte");
                }
                if (banyak_angka.compareTo(shortMin) >= 0 && banyak_angka.compareTo(shortMax) <= 0) {
                    System.out.println("* short");
                }
                if (banyak_angka.compareTo(intMin) >= 0 && banyak_angka.compareTo(intMax) <= 0) {
                    System.out.println("* int");
                }
                if (banyak_angka.compareTo(longMin) >= 0 && banyak_angka.compareTo(longMax) <= 0) {
                    System.out.println("* long");
                }
            }
            System.out.print("\n");
        }
        sc.close();
    }
}
