public class GenericsMethods { /*mendeklarasikan sebuah class bernama GenericsMethods
    yang berisi method generic untuk membandingkan dua objek bertipe GenericsType. */

    // Java Generic Method
    //Method generic yang digunakan untuk membandingkan dua objek GenericsType
    //T merupakan tipe data generic yang akan ditentukan saat method dipanggil
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
        //Mengambil nilai dari objek g1 dan g2 menggunakan method get()
        //Kemudian membandingkannya menggunakan method equals()
        return g1.get().equals(g2.get());
    }

    public static void main(String args[]) { //method utama tempat program mulai dijalankan.

        //Membuat objek bernama g1 dari class GenericsType dengan tipe data String
        GenericsType<String> g1 = new GenericsType<>();
        //Program menyimpan nilai "Java" ke dalam variabel t pada objek g1
        g1.set("Java");

        //Membuat objek bernama g2 dari class GenericsType dengan tipe data String
        GenericsType<String> g2 = new GenericsType<>();
        //Program menyimpan nilai "Java" ke dalam variabel t pada objek g2
        g2.set("Java");

        //Memanggil method generic isEqual dengan menyebutkan tipe data String secara eksplisit
        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);

        // above statement can be written simply as 
        //Pemanggilan method yang sama tetapi tanpa menuliskan tipe data secara eksplisit
        isEqual = GenericsMethods.isEqual(g1, g2);

        /*
         * This feature, known as type inference, allows you to invoke
         * a generic method as an ordinary method, without specifying 
         * a type between angle brackets 
         */
        
        // Compiler will infer the type that is needed
        //Artinya compiler Java secara otomatis menentukan tipe data yang diperlukan

        //Tambahan program untuk melihat outputnya 
        System.out.println("Apakah kedua objek sama? " + isEqual);
    }
}