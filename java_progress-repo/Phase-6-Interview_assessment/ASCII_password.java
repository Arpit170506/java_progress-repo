import java.util.Scanner;

public class ASCII_password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String encodedString = scanner.nextLine();
        System.out.println(decodePassword(encodedString));

        scanner.close();
    }

    public static String decodePassword(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return "";
        }

        StringBuilder reversed = new StringBuilder(encoded).reverse();
        StringBuilder result = new StringBuilder();

        int i = 0;
        int n = reversed.length();

        while (i < n) {
            if (reversed.charAt(i) == '1' && i + 2 <n) {
                String asciiStr = reversed.substring(i,i+3);
                int asciiVal = Integer.parseInt(asciiStr);
                result.append((char) asciiVal);
                i += 3;

            } else if (i + 1 < n) {
                String asciiStr = reversed.substring(i, i+2);
                int asciiVal = Integer.parseInt(asciiStr);
                result.append((char) asciiVal);
                i += 2;

            } else {
                break;
            }
        }
        return result.toString();
    }
}