package JavaProblems; //Program berada dalam package JavaProblems

import java.util.ArrayList; // Mengimpor kelas ArrayList untuk menyimpan data dinamis
import java.util.List; // Mengimpor interface List
import java.util.stream.Collectors; // Mengimpor utilitas untuk mengumpulkan hasil dari Stream

public class ProblemOne { //Membuat class utama 
    public static void main(String[] args) {

        // Membuat daftar (list) kosong khusus untuk menampung objek Employee
        ArrayList<Employee> list = new ArrayList<>(); 

        list.add(new Employee("Alice", 50000));
        list.add(new Employee("Bob", 70000));
        list.add(new Employee("Rob", 40000));
        list.add(new Employee("John", 10000));

        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp = list.stream() // Ubah list ke stream

                // Mengubah ArrayList menjadi "Stream" agar bisa diproses secara fungsional
                // Mengurutkan employee berdasarkan nama dengan perbandingan abjad
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName())) 
                // Mengumpulkan hasil urutan tersebut kembali menjadi List baru
                // Mengumpulkan hasil akhir
                .collect(Collectors.toList() );
        
        // Melakukan iterasi (perulangan) untuk menampilkan setiap objek Employee yang sudah terurut
        for(Employee e : sortedEmp){
        // Mencetak objek (otomatis memanggil toString() dari class Employee)
            System.out.println(e);

        }
    }
}
