import java.util.Scanner;
import java.util.Arrays;

public class Football_match {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        int[] teamA = new int[n];
        for (int i = 0; i < n; i++) {
            teamA[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] teamB = new int[m];
        for (int i = 0; i < m; i++) {
            teamB[i] = scanner.nextInt();
        }

        int[] result = countMatches(teamA, teamB);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        scanner.close();

    }

    public static int[] countMatches(int[] teamA, int[] teamB) {
        Arrays.sort(teamA);

        int[] result = new int[teamB.length];

        for (int i = 0; i < teamB.length; i++) {
            result[i] = binarySearchCount(teamA, teamB[i]);
        }

        return result;
    }

    public static int binarySearchCount(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                count = mid + 1;
                left = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }
}