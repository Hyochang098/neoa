import java.util.Scanner;

public class Main {
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = -1;
		int c = -1;
		while (!(r == 0 && c == 0)) {
			r = sc.nextInt();
			c = sc.nextInt();

			sc.nextLine();
			char[][] mine = new char[r][c];
			for (int i = 0; i < r; i++) {
				String temp = sc.nextLine();
				for (int j = 0; j < c; j++) {
					mine[i][j] = temp.charAt(j);
				}
			}

			String[][] ans = new String[r][c];

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (mine[i][j] == '.') {
						int cnt = 0;
						for (int k = 0; k < 8; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if (ny >= 0 && ny < r && nx >= 0 && nx < c && mine[ny][nx] == '*') {
								cnt++;
							}
						}
						ans[i][j] = String.valueOf(cnt);
					} else if (mine[i][j] == '*') {
						ans[i][j] = "*";
					}

				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(ans[i][j]);
				}
				System.out.println();
			}
		}
	}
}