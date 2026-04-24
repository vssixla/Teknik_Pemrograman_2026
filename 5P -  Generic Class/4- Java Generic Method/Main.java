// Interface generic MinMax dengan batasan tipe
// T harus merupakan tipe yang mengimplementasikan Comparable
interface MinMax<T extends Comparable<T>> {

    // Method untuk mencari dan mengembalikan nilai maksimum
    T max();
}

// Class generic MyClass yang mengimplementasikan interface MinMax
// T juga dibatasi harus mengimplementasikan Comparable
class MyClass<T extends Comparable<T>> implements MinMax<T> {

    // Array bertipe generic untuk menyimpan data
    T[] vals;

    // Constructor untuk menerima array data dan menyimpannya ke variabel vals
    MyClass(T[] o) {
        vals = o;
    }

    // Implementasi method max() untuk mencari nilai terbesar dalam array
    public T max() {

        // Menyimpan nilai pertama sebagai nilai maksimum sementara
        T v = vals[0];

        // Melakukan perulangan untuk membandingkan semua elemen array
        for (int i = 1; i < vals.length; i++) {

            // Menggunakan method compareTo dari interface Comparable
            // Jika nilai vals[i] lebih besar dari v maka ganti nilai maksimum
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }

        // Mengembalikan nilai maksimum yang ditemukan
        return v;
    }
}

// Class utama untuk menjalankan program
public class Main {

    public static void main(String[] args) {

        // Membuat array Integer
        Integer[] inums = {3, 6, 2, 8, 6};

        // Membuat array Character
        Character[] chs = {'b', 'r', 'p', 'w'};

        // Membuat objek MyClass dengan tipe Integer
        // Data array Integer dikirim ke constructor
        MyClass<Integer> a = new MyClass<>(inums);

        // Membuat objek MyClass dengan tipe Character
        // Data array Character dikirim ke constructor
        MyClass<Character> b = new MyClass<>(chs);

        // Memanggil method max() untuk mencari nilai Integer terbesar
        System.out.println("Nilai Integer Terbesar: " + a.max());

        // Memanggil method max() untuk mencari karakter terbesar
        System.out.println("Karakter Terbesar: " + b.max());
    }
}