import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println("#" + t + " " + mutiple(m, n));
		}
	}

	public static int mutiple(int n, int a) {
		if (n == 0) {
			return 1;
		}
		return a*mutiple(n - 1, a);
	}
}