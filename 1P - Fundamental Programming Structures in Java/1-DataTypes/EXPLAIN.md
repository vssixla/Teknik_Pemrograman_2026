## Source Code
```java
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
```

## Input
5
-150

150000

1500000000

213333333333333333333333333333333333

-1000

## Output
-150 can be fitted in:
* short
* int
* long

150000 can be fitted in:
* int
* long

1500000000 can be fitted in:
* int
* long

213333333333333333333333333333333333 can't be fitted anywhere.

-1000
-1000 can be fitted in:
* short
* int
* long

## Analisis Permasalahan
Dalam bahasa pemrograman Java, terdapat delapan tipe data primitive yang salah satunya digunakan untuk menyimpan objek bilangan bulat, yaitu byte, short, int, dan long. Setiap tipe data ini memiliki kapasitas penyimpanan yang berbeda, yang ditentukan oleh jumlah bit yang digunakan. 
	Diketahui:
•	byte menggunakan 8 bit sehingga dapat menyimpan bilangan dari -128 hingga 127
•	short menggunakan 16 bit dengan rentang -32.768 hingga 32.767
•	int menggunakan 32 bit dengan rentang -2.147.483.648 hingga 2.147.483.647
•	long menggunakan 64 bit dengan rentang -9.223.372.036.854.775.808 hingga 9.223.372.036.854.775.807
	Pemasalahan ini muncul ketika akan menginputkan suatu bilangan bulat, yang mana nilainya bisa sangat besar ataupun sangat kecil, sehingga tidak semua tipe data mampu menyimpan nilai angka tersebut. Jika nilai angka yang diberikan melebihi kapasitas tipe data yang digunakan, maka akan terjadi overflow atau program gagal memproses angka dengan benar.

## Analisis Solusi 
Untuk mengatasi masalah ini, diperlukan sebuah mekanisme untuk menentukan tipe data primitif terkecil yang dapat menampung angka input dengan tepat, atau menentukan jika angka tersebut berada di luar kapasitas semua tipe data yang tersedia. 
	Solusi untuk permasalahan ini dapat dilakukan dengan membaca setiap angka masukan sebagai string terlebih dahulu, kemudian dikonversi menjadi BigInteger (memproses angka yang sangat besar tanpa terjadi overflow). Jika angka tersebut masuk ke dalam rentang sebuah tipe data, maka tipe data tersebut dicatat sebagai tipe yang dapat menyimpan angka tersebut. Proses ini diulang untuk semua tipe data agar dapat menampilkan semua tipe yang mampu menampung angka tersebut, diurutkan dari ukuran terkecil hingga terbesar.  Apabila angka masukan tidak termasuk dalam rentang tipe data manapun, maka program akan menampilkan pesan bahwa angka tersebut “can't be fitted anywhere”. 
	Dengan pendekatan ini, program mampu menangani berbagai kasus angka, baik yang kecil maupun yang sangat besar, dan memberikan output yang sesuai dengan format yang diminta. 
