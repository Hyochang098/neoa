import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mask = (1 << n) - 1;
            if ((m & mask) == mask) {
                System.out.println("#" + i + " ON");
            } else {
                System.out.println("#" + i + " OFF");
            }
        }
    }
}