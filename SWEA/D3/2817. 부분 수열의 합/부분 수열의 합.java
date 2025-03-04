
import java.util.Scanner;

public class Solution {
	static int n, k;
	static int[] arr;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n];
			ans = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			permute(0, 0);
			System.out.println("#"+tc+" " + ans);

		}

	}

	private static void permute(int cur, int sum) {
		// TODO Auto-generated method stub
		if (cur == n) {
			if (sum == k) {
				ans++;
			}
			return;
		}
		permute(cur + 1, sum + arr[cur]);
		permute(cur + 1, sum);

	}
}