import java.util.Scanner;

public class Solution {
	static int ans, n;

	static int[][] students;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			students = new int[n + 1][n + 1];
			ans =0;
			for (int i = 0; i < m; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();

				students[first][second] = 1;// 크면 1로
				students[second][first] = 2;// 작으면 2로
			}

			for (int i = 1; i < n + 1; i++) {
				dfs(i);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void dfs(int start) {
		// TODO Auto-generated method stub
		// 시작 점 에서 위로 아래로 추적하는 메서드 방문은 여기서 새로 생성
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		up(start, visited);
		down(start, visited);
		for (int i = 1; i < n+1; i++) {
			if (!visited[i]) {
				return;
			}
		}
		ans++;
	}

	private static void down(int start, boolean[] visited) {
		for (int i = 1; i < n + 1; i++) {
			if (students[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				down(i, visited);
			}
		}

	}

	private static void up(int start, boolean[] visited) {
		for (int i = 1; i < n + 1; i++) {
			if (students[start][i] == 2 && !visited[i]) {
				visited[i] = true;
				up(i, visited);
			}
		}
	}
}