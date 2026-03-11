//2. Membuat Strings Java
import java.util.Scanner;

public class Strings{
    public static void main(String[] args)
    {
        String[] wordList;
        int size;
        Scanner scan = new Scanner(System.in);

        System.out.print("How many words do you want to sort? ");
        size = scan.nextInt();

        wordList = new String[size];

        System.out.println("Enter the words...");

        for(int i = 0; i < size; i++)
            wordList[i] = scan.next();

        Sorting.insertionSort(wordList); //4. Mengganti method sorting

        System.out.println("\nWords in sorted order:");

        for(String word : wordList)
            System.out.print(word + " ");

        System.out.println();
    }
}