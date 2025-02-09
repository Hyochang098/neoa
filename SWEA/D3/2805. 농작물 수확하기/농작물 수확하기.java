import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			sc.nextLine();

			int k = n / 2;
			int[][] farm = new int[n][n];

			int ans = 0;
			for (int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				for (int j = 0; j < n; j++) {
					farm[i][j] = temp.charAt(j)-'0';
				}
			}
			for (int i = 0; i < n; i++) {
                int start = Math.abs(k - i);
                int end = n - start;

                for (int j = start; j < end; j++) {
                    ans += farm[i][j];
                }
            }
			System.out.println("#"+tc+" "+ans);
		}
	}
}