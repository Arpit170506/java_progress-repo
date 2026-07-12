import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Array_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        sortmultipleoffive(arr);
        for(int i = 0; i < arr.length; i++ ) {
            System.out.print(arr[i]);
            if (i < arr.length - 1 ) {
                System.out.print(" ");
            }    
        }
        System.out.println();
        scanner.close();
    }

    public static void sortmultipleoffive(int[] arr) {
        ArrayList<Integer> Multiples = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                Multiples.add(arr[i]);
            }
        }
        Collections.sort(Multiples, Collections.reverseOrder());
        int listIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 5 == 0) {
                arr[i] = Multiples.get(listIndex);
                listIndex++;
            }
        }

    }
}
