
import java.util.Scanner;

public class Main {
	static int n;

	static int recurcnt = 0;
	static int dpcnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		fibo(n);
		fibona(n);

		System.out.println(recurcnt + " " + dpcnt);

	}

	private static int fibona(int cur) {
		// TODO Auto-generated method stub
		if (cur == 1 || cur == 0) {
			return cur;
		}
		int[] dp = new int[cur + 1];
		dp[1] = dp[2] = 1;
		for (int i = 3; i < cur + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dpcnt++;
		}
		return dp[cur];
	}

	private static int fibo(int cur) {
		// TODO Auto-generated method stub
		if (cur == 1 || cur == 2) {
			recurcnt++;
			return 1;
		}
		return fibo(cur - 1) + fibo(cur - 2);
	}
}