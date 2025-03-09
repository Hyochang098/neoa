import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 16985 - Maaaaaaaaaze
	// 3차원 미로를 만들 것임 2차원형태의 미로정보가 나옴 최단 경로로 3차원 미로 완성

	// 5 5 5 형태 고정임
	// 그러면 5 5 배열을 4가지경우로 놓을 수 잇고(90도 돌리며)
	// 4의 5제곱 1024
	// 이후 조합 후에 bfs로 출구로 가기

	// 모든 경우를 봐도 될듯? n의 범위가 작으니
	// 각 층의 정보 순서
	// 순서를 만들고 회전을 한다고?
	// 54321 4^5 -> 120 1024 =100000 십만자리 경우
	// 출구는 꼭지점이고 대칭에 있는 곳이 출구임 4가지 경우

	static int[][][] original = new int[5][5][5]; // 원본 미로 저장
	static int[][][] maze = new int[5][5][5]; // 조합된 미로 (BFS 탐색용)
	static boolean[] used = new boolean[5]; // 층 배치 여부 체크
	static int[] order = new int[5]; // 층 배치 순서
	static int ans = Integer.MAX_VALUE; // 최단 거리 저장

	static int[] dz = { 0, 0, 0, 0, 1, -1 };// 델타, 계속 시도할 출발점들
	static int[] dy = { 1, -1, 0, 0, 0, 0 };// 면이 인접이라햇으니 대각선 x
	static int[] dx = { 0, 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// stage 배열로 모두 입력하면 될듯?
		for (int z = 0; z < 5; z++) {
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					original[z][y][x] = sc.nextInt();
				}
			}
		}

		used = new boolean[5];
		permute(0); // 층 순서 정하기 (순열 생성)

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	// 순열 생성 (5개의 층을 배치하는 모든 경우 탐색)
	private static void permute(int depth) {
		if (depth == 5) {
			setMaze(); // 🔹 배치된 층을 실제 `maze[][][]`에 적용
			rotate(0);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!used[i]) {
				used[i] = true;
				order[depth] = i;
				permute(depth + 1);
				used[i] = false;
			}
		}
	}

	// 🔹 `order[]`에 따라 `maze[][][]`를 구성
	private static void setMaze() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.arraycopy(original[order[i]][j], 0, maze[i][j], 0, 5);
				//->배열을 복사함 
			}
		}
	}

	// 하나씩 내려가며 층 돌리기
	private static void rotate(int depth) {
		if (depth == 5) {
			if (maze[0][0][0] == 1 && maze[4][4][4] == 1) {
				ans = Math.min(ans, bfs());
			}
			return;
		}
		for (int r = 0; r < 4; r++) {
			spin(depth, r); // 현재 층을 r번 회전
			rotate(depth + 1);
		}
	}

	// 도착 층 회전
	private static void spin(int index, int rotation) {
		int[][] temp = new int[5][5];

		// 90도 회전
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rotation == 0) temp[i][j] = maze[index][i][j]; // 0도
				else if (rotation == 1) temp[i][j] = maze[index][4 - j][i]; // 90
				else if (rotation == 2) temp[i][j] = maze[index][4 - i][4 - j]; // 180
				else temp[i][j] = maze[index][j][4 - i]; // 270
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				maze[index][i][j] = temp[i][j];
			}
		}
	}

	// BFS
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[5][5][5];

		queue.add(new int[] { 0, 0, 0, 0 }); // z y x 이동 횟수
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int z = cur[0];
			int y = cur[1];
			int x = cur[2];
			int d = cur[3];

			if (z == 4 && y == 4 && x == 4)
				return d;

			for (int i = 0; i < 6; i++) {
				int nz = z + dz[i], ny = y + dy[i], nx = x + dx[i];

				if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5)
					continue;
				if (visited[nz][ny][nx] || maze[nz][ny][nx] == 0)
					continue;

				visited[nz][ny][nx] = true;
				queue.add(new int[] { nz, ny, nx, d + 1 });
			}
		}
		return Integer.MAX_VALUE; // 예외처리
	}
}
