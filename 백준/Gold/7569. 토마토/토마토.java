
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[h][n][m];
		Queue<int[]> queue = new LinkedList<>();
		int notomato = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = Integer.parseInt(st1.nextToken());
					if (tomato[i][j][k] == 1) {
						queue.add(new int[] { i, j, k });
					}
					if (tomato[i][j][k] == 0) {
						notomato++;
					}
				}
			}
		}

		if (notomato == 0) {
			System.out.println(0);
			return;
		}

		int ans = bfs(tomato, queue, notomato);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	public static int bfs(int[][][] sample, Queue<int[]> queue, int o) {
        int result = 0;
        int h = sample.length;
        int w = sample[0].length;
        int b = sample[0][0].length;

        int[] dz = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dx = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int z = arr[0], y = arr[1], x = arr[2];

                for (int j = 0; j < 6; j++) {
                    int nz = z + dz[j];
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (nz >= 0 && nz < h && ny >= 0 && ny < w && nx >= 0 && nx < b && sample[nz][ny][nx] == 0) {
                        sample[nz][ny][nx] = 1;
                        o--;
                        queue.add(new int[]{nz, ny, nx});
                    }
                }
            }
            result++;
            if (o == 0) {
                return result;
            }
        }
        return -1;
    }
}