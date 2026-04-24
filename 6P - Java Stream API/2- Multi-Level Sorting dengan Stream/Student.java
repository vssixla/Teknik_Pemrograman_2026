package JavaProblems;
class Student { //Kelas untuk merepresentasikan data Mahasiswa
    private int id; // Variabel untuk ID Siswa yang hanya diakses di class ini
    private String name; // Variabel untuk menyimpan nama siswa 
                            //dan hanya diakses di kelas ini

    // Konstruktor untuk inisialisasi objek
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter untuk mengakses ID 
    public int getId() {
        return id;
    }

    // Getter untuk mengakses Nama
    public String getName() {
        return name;
    }

    @Override
    public String toString() { //metode toString agar saat diprint menampilkan format yang rapi
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}