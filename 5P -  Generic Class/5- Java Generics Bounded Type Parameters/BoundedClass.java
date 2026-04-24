class Bound<T extends A> { /*mendeklarasikan sebuah class generic bernama Bound
    dengan tipe parameter T yang dibatasi harus merupakan turunan dari class A. */

    private T objRef; //mendeklarasikan variabel bernama objRef dengan tipe T.
    //Variabel ini digunakan untuk menyimpan objek yang merupakan turunan dari class A.

    //Constructor yang digunakan untuk menerima objek bertipe T
    public Bound(T obj) {
        this.objRef = obj; //Menyimpan objek yang diterima ke dalam variabel objRef
    }

    //Method yang digunakan untuk menjalankan method displayClass()
    public void doRunTest() {
        //Memanggil method displayClass() dari objek yang disimpan
        this.objRef.displayClass();
    }
}

class A { /*mendeklarasikan sebuah class bernama A yang akan menjadi superclass
    bagi class lain seperti B dan C. */

    public void displayClass() { //Method yang digunakan untuk menampilkan informasi class
        System.out.println("Inside super class A");
    }
}

class B extends A { /*mendeklarasikan class B yang merupakan turunan (subclass)
    dari class A. */

    public void displayClass() { //Method ini menimpa (override) method dari class A
        System.out.println("Inside sub class B");
    }
}

class C extends A { /*mendeklarasikan class C yang juga merupakan turunan
    dari class A. */

    public void displayClass() { //Method ini menimpa (override) method dari class A
        System.out.println("Inside sub class C");
    }
}

public class BoundedClass { /*mendeklarasikan class utama yang berisi method main
    untuk menjalankan program. */

    public static void main(String a[]) { //method utama tempat program mulai dijalankan.

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        //Membuat objek Bound dengan tipe parameter C
        //Objek C dikirim ke constructor Bound
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest(); //Memanggil method doRunTest() sehingga method displayClass() milik C dijalankan

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        //Membuat objek Bound dengan tipe parameter B
        //Objek B dikirim ke constructor Bound
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest(); //Memanggil method doRunTest() sehingga method displayClass() milik B dijalankan

        // similarly passing super class A
        //Membuat objek Bound dengan tipe parameter A
        //Objek A dikirim ke constructor Bound
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest(); //Memanggil method doRunTest() sehingga method displayClass() milik A dijalankan
    }
}