## Source Code Constants
```java
public class Constants {
	public static void main(String[] args) { 
		final double CM_PER_INCH = 2.54; double paperWidth = 8.5;
		double paperHeight = 11;
		System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
	}
}
```
## Output Constants
Paper size in centimeters: 21.59 by 27.94

## Source Code Constants2
```java
public class Constants {
	public static void main(String[] args) { 
		final double CM_PER_INCH = 2.54; double paperWidth = 8.5;
		double paperHeight = 11;
		System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
	}
}
```
## Output Constants2
Paper size in centimeters: 21.59 by 27.94

## Analisis Permasalahan
	Permasalahan dalam soal ini berfokus pada penggunaan konstanta dalam program Bahasa Java. Pada soal menampilkan dua potongan program yang menghasilkan output yang sama, yaitu “Paper size in centimeters: 21.59 by 27.94”, tetapi menggunakan penyusunan kode yang berbeda. Hal ini tentu akan menimbulkan kebingungan. 
	Kedua program melakukan operasi perhitungan yang sama, yaitu mengubah ukuran kertas dari inci ke centimeter menggunakan konstanta. Karena nilai konstanta dan rumus yang digunakan sama, hal ini yang membuat kedua program tersebut menghasilkan output yang sama. Kedua program tersebut, memiliki perbedaan cara dalam mendeklarasikan konstanta. 
	Pada program bagian pertama (Constants) menggunakan final double di dalam metode main. Hal ini membuat konstanta hanya dapat digunakan dalam lingkup method tersebut, dan jika program dikembangkan menjadi lebih besar maka konstanta tersebut tidak dapat langsung digunakan. 
Sedangkan pada program bagian kedua (Constants2) konstanta dideklarasikan menggunakan public static final double. Hal ini menunjukkan bahwa konstanta tersebut bersifat milik class, dapat diakses tanpa membuat objek, dan dapat digunakan oleh class lain. 





