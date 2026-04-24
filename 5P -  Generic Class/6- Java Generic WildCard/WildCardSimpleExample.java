import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Wildcard Arguments With An Unknown Type
 * @author javaguides.net
 **/

public class WildCardSimpleExample { /*mendeklarasikan sebuah class bernama WildCardSimpleExample
    yang digunakan untuk menunjukkan penggunaan wildcard (?) pada generics. */

    //Method yang digunakan untuk mencetak isi dari sebuah Collection
    //Tanda wildcard (?) berarti method ini dapat menerima collection dengan tipe data apa pun
    public static void printCollection(Collection<?> c) {
        //Melakukan perulangan untuk mengambil setiap elemen dalam collection
        for (Object e : c) {
            //Menampilkan setiap elemen yang ada di dalam collection
            System.out.println(e);
        }
    }

    public static void main(String[] args) { //method utama tempat program mulai dijalankan.

        //Membuat objek collection bertipe String menggunakan ArrayList
        Collection<String> collection = new ArrayList<>();
        //Menambahkan data ke dalam collection
        collection.add("ArrayList Collection");
        //Memanggil method printCollection untuk menampilkan isi collection
        printCollection(collection);

        //Membuat objek collection bertipe String menggunakan LinkedList
        Collection<String> collection2 = new LinkedList<>();
        //Menambahkan data ke dalam collection
        collection2.add("LinkedList Collection");
        //Memanggil method printCollection untuk menampilkan isi collection
        printCollection(collection2);

        //Membuat objek collection bertipe String menggunakan HashSet
        Collection<String> collection3 = new HashSet<>();
        //Menambahkan data ke dalam collection
        collection3.add("HashSet Collection");
        //Memanggil method printCollection untuk menampilkan isi collection
        printCollection(collection3);
    }
}