import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0'; 
            }
        }
        
        int ans = bfs(map);
        System.out.println(ans);
    }

    public static int bfs(int[][] arr) {
        int a = arr.length;
        int b = arr[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[a][b];

        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };

        int count = 0;  


        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;  

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];

                if (y == a - 1 && x == b - 1) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (ny >= 0 && ny < a && nx >= 0 && nx < b) {
                        if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            queue.offer(new int[] { ny, nx });
                        }
                    }
                }
            }
        }

        return -1;
    }
}