import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] tomato = new int[n][m];

		Queue<int[]> queue = new LinkedList<int[]>();
		int already = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1) {
					queue.offer(new int[] { i, j });
				} 
			}
		}
		int ans = bfs(queue, tomato);
		boolean check=true;
		Loop:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 0) {
					check=false;
				} 
			}
		}
		if(check)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	public static int bfs(Queue<int[]> sample, int[][] arr) {
		int h = arr.length;
		int w = arr[0].length;

		int[] dy = new int[] { 1, -1, 0, 0 };
		int[] dx = new int[] { 0, 0, 1, -1 };
		int count = -1;
		while (!sample.isEmpty()) {
			int size = sample.size();
			count++;
			for (int i = 0; i < size; i++) {
				int[] tt = sample.poll();
				int y = tt[0];
				int x = tt[1];

				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if (ny >= 0 && ny < h && nx >= 0 && nx < w && arr[ny][nx] == 0) {
						arr[ny][nx] = 1;
						sample.offer(new int[] {ny,nx});
					}
				}
			}
		}
		return count;
	}
}