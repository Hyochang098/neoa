import java.util.Scanner;

public class Solution {
	static int n;
	static int[][] chess;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			chess = new int[n][n];
			ans=0;
			isQueen(0);
			System.out.println("#" + tc + " " + ans);

		}

	}

	// 퀸을 놓는 방법에 따라 방향이 다르겠지만 넣을 때 고려해야하는건 대각선 두줄임
	// 내려가면서 열에 퀸을 넣는 경우 위 방향의 좌우 대각선 퀸이 있는지를 확인
	private static void isQueen(int depth) {
		// TODO Auto-generated method stub
		if (depth == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean check = true;

			for (int j = 0; j < depth; j++) {
				if (chess[j][i] == 1) {
					check = false;
					break;
				}
			}
			// 위 오른쪽탐색
			int sero = depth - 1;
			int garo = i - 1;
			while (sero >= 0 && garo >= 0) {
				if (chess[sero][garo] == 1) {
					check = false;
					break;
				}
				sero--;
				garo--;
			}
			// 위 왼족탐색
			sero = depth - 1;
			garo = i + 1;
			while (sero >= 0 && garo < n) {
				if (chess[sero][garo] == 1) {
					check = false;
					break;
				}
				sero--;
				garo++;
			}
			if (check) {
				chess[depth][i] = 1;
				isQueen(depth + 1);
				chess[depth][i] = 0;
			}

		}

	}
}