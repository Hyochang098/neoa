import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            sc.nextLine();
            int n = sc.nextInt();
            BigInteger N = BigInteger.valueOf(n);
            BigInteger sum = BigInteger.ZERO;

            for (int i = 0; i < n; i++) {
                BigInteger candy = sc.nextBigInteger();
                sum = sum.add(candy.remainder(N));
            }

            if (sum.remainder(N).equals(BigInteger.ZERO)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
