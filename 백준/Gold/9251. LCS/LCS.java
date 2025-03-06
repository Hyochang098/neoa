import java.util.Scanner;

public class Main {
	// 9251 - LCS
	// 두 문자열에 공통되는 부분수열중 가장 긴놈

	// 그럼 두 문자열을 입력받고 숫자로 변환
	// 1차원은 시간초과;
	// 같은 수 중에 최댓값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 2차원으로 
		// 글자가 같을때마다 +1 이전 단계 값+1을 넣음
		// 다르면 붙어 있는 이전값 왼쪽 | 위의 값을 비교 
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}