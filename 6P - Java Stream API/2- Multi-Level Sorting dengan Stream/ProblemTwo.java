package JavaProblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemTwo {
    public static void main(String[] args) {

        // Membuat daftar (List) objek Student secara statis
        List<Student> students = Arrays.asList(
                new Student(101, "Joe"),
                new Student(103, "Zulkifli"),
                new Student(102, "Riza"),
                new Student(104, "Alice"),
                new Student(105, "Joshua")
        );
        
        // Memproses data menggunakan Java Stream API
        List<Student> ans = students.stream() //[1] Membuka stream
                .sorted((s1, s2) -> {       // [2] Melakukan pengurutan
                    
                    // Logika: Jika nama sama, bandingkan ID
                    if (s1.getName().equalsIgnoreCase(s2.getName())) {
                        // Jika nama sama, urutkan berdasarkan ID (secara ascending)
                        return Integer.compare(s1.getId(), s2.getId()); //[3]
                    }
                    // Jika nama berbeda, bandingkan Nama
                    else {
                        return s1.getName().compareToIgnoreCase(s2.getName()); //[4]
                    }
                })
                // Mengumpulkan hasil akhir stream menjadi sebuah list baru
                .collect(Collectors.toList()); //[5] Mengumpulkan hasil

        // Melakukan perulangan untuk mencetak setiap objek Student yang sudah terurut
        for (Student student : ans) {
            System.out.println(student);
        }
    }
}


