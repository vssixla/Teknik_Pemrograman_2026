public class GenericsTypeOld { //membuat class bernama GenericsTypeOld

    private Object t; //variabel t bertipe object dan hanya bisa diakses di class ini

    /*Method yang digunakan untuk mengambil nilai 
    yang tersimpan dalam variabel t */
    public Object get() { 
        return t;
    }

    /*Method yang digunakan untuk menyimpan nilai ke dalam variabel t */
    public void set(Object t) {
        this.t = t;
    }

    public static void main(String args[]) { //method utama program
        GenericsTypeOld type = new GenericsTypeOld(); //membuat objek dari class GenericsTypeOld
        type.set("Java"); //program menyimpan string "Java" ke dalam variabel t
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException

        System.out.println(str); //tambahan untuk melihat output
    }
}
