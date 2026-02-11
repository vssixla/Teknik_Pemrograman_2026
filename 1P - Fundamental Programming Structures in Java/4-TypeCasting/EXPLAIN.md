## Source Code
```java
class ConvertDataType {
	static short methodOne(long l) {
		int i = (int) l; return (short)i;
	}
	public static void main(String[] args) {
		double d = 10.25; float f = (float) d;
		byte b = (byte) methodOne((long) f); System.out.println(b);
	}
}
```

## Output 
10

## Analisis Permasalahan
Program ini merupakan program yang melakukan konversi tipe data dari yang berukuran besar (double) menjadi ukuran yang lebih kecil (byte). Program ini menggunakan casting eksplisit yang memaksa perubahan pada tipe dayang berbeda ukuran. Dari program diatas, dapat dilihat nilai awal dari variable d berubah dan disimpan di dalam variable b. 
