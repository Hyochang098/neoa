
import java.util.Scanner;

public class Solution {
	static int n, l, ans;
	static int[][] ham;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();// 재료 수
			l = sc.nextInt();// 칼로리제한
			ans = Integer.MIN_VALUE;
			// 음식에 대한 조합 이후 칼로리 더하고
			// 그 중 맛 점수 높은거
			// 입력을 2줄 /1 맛 2 칼로리
			ham = new int[n][2];

			for (int i = 0; i < n; i++) {
				ham[i][0] = sc.nextInt();// 맛
				ham[i][1] = sc.nextInt();// 칼로리
			}

			permute(0, 0, 0);// 조합짜서 칼로리 맞는 경우에만 맛을 max로 갱신
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void permute(int cur, int sum, int deli) {
		// cur-조합 수 sum-칼로리 deli-맛점수
		if (cur == n) {
			if (sum < l) {
				ans = Math.max(ans, deli);
			}
			return;
		}
		
		permute(cur + 1, sum + ham[cur][1], deli + ham[cur][0]);
		permute(cur + 1, sum, deli);
	}
}
