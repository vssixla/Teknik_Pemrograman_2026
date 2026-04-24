public class GenericsType<T> { /*mendeklarasikan sebuah class bernama GenericsType 
    yang menggunakan generic type parameter. */

    private T t; //mendeklarasikan variabel bernama t dengan tipe T.
    //Variabel hanya bisa diakses di dalam class.

    //Method yang digunakan untuk mengambil nilai yang tersimpan dalam variabel t.
    public T get() { //Method bisa dipanggil dari luar class.
        return this.t;
    }

    //Method yang digunakan untuk menyimpan nilai ke dalam variabel t.
    public void set(T t1) { //Method bisa dipanggil dari luar class.
        this.t = t1; //Nilai parameter t1 disimpan ke dalam variabel t
        //Digunakan untuk membedakan variabel instance dengan parameter.
    }

    public static void main(String args[]) { //method utama tempat program mulai dijalankan.
        //Membuat objek bernama type dari class GenericsType
        GenericsType<String> type = new GenericsType<>();
        //Program menyimpan nilai "Java" ke dalam variabel t
        type.set("Java"); // valid

        //Membuat objek tanpa menentukan tipe generic.
        GenericsType type1 = new GenericsType(); // raw type
        type1.set("Java"); // valid , raw type menerima berbagai tipe.
        //Menimpa nilai yang sebelumnya "Java" menjadi 10
        type1.set(10); // valid and autoboxing support

        //tambahan untuk melihat outputnya
        System.out.println(type.get());
        System.out.println(type1.get());
    }
}
