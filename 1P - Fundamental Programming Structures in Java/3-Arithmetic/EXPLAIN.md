## Source Code
```java
class FloatingPoint {
    public static void main(String[] args) { 
        double x = 92.98;
        int nx = (int) Math.round(x);

        System.out.println(nx);  //Menambahkan sendiri untuk mengetahui hasilnya
    }
}
```

## Output 
93

## Analisis Permasalahan
Permasalahan berkaitan dengan pembulatan nilai x, x memiliki nilai 92.98 yang merupakan tipe bilangan double. Ketika fungsi Math.round(x) dijalankan, nilai tersebut akan dibulatkan ke bilangan bulat terdekat, karena nilai desimal 0.98 lebih besar dari 0.5, maka nilai akan dibulatkan ke atas. 
