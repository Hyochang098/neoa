import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < n + m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			board[from] = to;
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 1, 0 });
		visited[1] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int pos = current[0];
			int moves = current[1];

			if (pos == 100) {
				return moves;
			}

			for (int i = 1; i <= 6; i++) {
				int next = pos + i;
				if (next > 100)
					continue;

				if (board[next] != 0) {
					next = board[next];
				}

				if (!visited[next]) {
					visited[next] = true;
					queue.add(new int[] { next, moves + 1 });
				}
			}
		}
		return -1;
	}
}
