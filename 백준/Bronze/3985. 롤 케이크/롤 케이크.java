import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int n = sc.nextInt();

        int[] cake = new int[l];
        int[] greed = new int[n];
        int[] real = new int[n];

        int expect_max = 0;
        int expect_max_index = 0;

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt() - 1;
            int k = sc.nextInt() - 1;

            greed[i] = k - p + 1;
            if (greed[i] > expect_max) {
                expect_max = greed[i];
                expect_max_index = i + 1;
            }

            for (int j = p; j <= k; j++) {
                if (cake[j] == 0) {
                    cake[j] = i + 1;
                    real[i]++;
                }
            }
        }

        System.out.println(expect_max_index);

        int real_max = 0;
        int real_max_index = 0;

        for (int i = 0; i < n; i++) {
            if (real[i] > real_max) {
                real_max = real[i];
                real_max_index = i + 1;
            }
        }

        System.out.println(real_max_index);
    }
}
