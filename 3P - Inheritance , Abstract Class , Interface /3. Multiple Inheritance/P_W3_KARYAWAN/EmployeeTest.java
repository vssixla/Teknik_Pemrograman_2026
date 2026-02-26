public class EmployeeTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        // Inisialisasi data karyawan
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Menaikkan gaji setiap staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        // Mencetak data dari setiap staf
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        //Menampilkan hasil instruksi 1
        Employee e1 = new Employee("A", 2000, 1, 1, 2000);
        Employee e2 = new Employee("B", 3000, 1, 1, 2000);
        int hasil = e1.compare(e2);
        System.out.println("\n=== INSTRUKSI SATU (A) ===");
        System.out.println("Hasil compare: " + hasil);
    }
}

