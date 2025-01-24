import java.util.Scanner;

public class Main {

    public static String fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputs = new String[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = sc.nextLine();
        }

        int startNumber = -1; 
        for (String input : inputs) {
            try {
                startNumber = Integer.parseInt(input); 
                break;
            } catch (NumberFormatException e) {
            }
        }

        if (startNumber != -1) {
            for (int i = startNumber - 2; ; i++) {
                if (fizzBuzz(i).equals(inputs[0]) &&
                    fizzBuzz(i + 1).equals(inputs[1]) &&
                    fizzBuzz(i + 2).equals(inputs[2])) {
                    System.out.println(fizzBuzz(i + 3));
                    break;
                }
            }
        }
    }
}
