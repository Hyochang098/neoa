import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isPrime(sc.nextInt())) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int a) {
        if (a < 2) return false; 
        if (a == 2) return true; 
        if (a % 2 == 0) return false;
        for (int i = 3; i * i <= a; i += 2) { 
            if (a % i == 0) return false;
        }

        return true;
    }
}
