
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main{

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        java.io.BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int m = Integer.parseInt(nm[0]);
        int n = Integer.parseInt(nm[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.start, y = cur.end, w = cur.weight;
            if (x == n - 1 && y == m - 1) {
                System.out.println(w);
                return;
            }
            if (dist[x][y] < w) continue;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                int nw = w + map[nx][ny];
                if (dist[nx][ny] > nw) {
                    dist[nx][ny] = nw;
                    pq.offer(new Node(nx, ny, nw));
                }
            }
        }
    }


}
