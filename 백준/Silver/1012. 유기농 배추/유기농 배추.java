import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();// 배추

			int[][] baechu = new int[n][m];
			boolean[][] visited = new boolean[n][m];
			Queue<int[]> que = new LinkedList<>();

			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				baechu[b][a]=1;
			}

			int[] dy = new int[] { 1, -1, 0, 0 };
			int[] dx = new int[] { 0, 0, 1, -1 };
			
			int cnt=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(baechu[i][j]==1&&!visited[i][j]) {
						que.add(new int[] {i,j});
						visited[i][j]=true;
						cnt++;
						while (!que.isEmpty()) {
							int[] temp=que.poll();
							int y = temp[0];
							int x = temp[1];
							for (int k1 = 0; k1 < 4; k1++) {
								int ny = y + dy[k1];
								int nx = x + dx[k1];
								if (0 <= ny && ny < n && 0 <= nx && nx < m && baechu[ny][nx] == 1 && !visited[ny][nx]) {
									que.add(new int[] { ny, nx });
									visited[ny][nx] = true;
								}
							}
						}
					}
				}
			}
					
			
			System.out.println(cnt);
		}
	}
}