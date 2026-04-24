package JavaProblems; //Program berada dalam package JavaProblems
class Employee { //Membuat class Employee
    private String name; //Deklarasi variabel name yang hanya bisa diakses di class ini
    private int salary; //Deklarasi variabel salary yang hanya bisa diakses di class ini

    //Constructor, metode yang dipanggil saat membuat objek baru Employee
    public Employee(String name, int salary) {
        this.name =name; //Mengisi variabel 'name' dengan data nama pada ProblemOne
        this.salary =salary; //Mengisi variabel 'salary' dengan data salary pada ProblemOne
    }

    public String getName() {// Method getter untuk mengambil nilai 'name' dari luar class
        return name;//Mengembalikan isi variabel 'name'
    }

    public int getSalary() { //Method getter untuk mengambil nilai 'salary' dari luar class
        return salary; // Mengembalikan isi variabel 'salary'
    }

    @Override //Mengubah (override) perilaku bawaan metode dari class induk (Object)
    public String toString() { // Method untuk mengubah representasi objek menjadi format teks/string
        // Mengembalikan tampilan teks data tersebut
        return "Employee{name='"+ name +"', salary="+ salary +"}";
    }
    
}
