import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dummy = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dummy[r][c] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<Integer> timing = new ArrayDeque<>();
        Queue<Character> dir = new ArrayDeque<>();

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            timing.add(time);
            dir.add(direction);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addLast(new int[]{1, 1});
        int time = 0;
        int direction = 0;

        while (true) {
            int[] head = snake.peekLast();
            int ny = head[0] + dy[direction];
            int nx = head[1] + dx[direction];
            time++;

            if (ny < 1 || ny > n || nx < 1 || nx > n || isOnBody(snake, ny, nx)) {
                System.out.println(time);
                break;
            }

            snake.addLast(new int[]{ny, nx});
            if (dummy[ny][nx] != 1) {
                snake.pollFirst();
            } else {
                dummy[ny][nx] = 0;
            }

            if (!timing.isEmpty() && time == timing.peek()) {
                timing.poll();
                char c = dir.poll();
                if (c == 'D') direction = (direction + 1) % 4;
                else direction = (direction + 3) % 4;
            }
        }
    }
    
    static boolean isOnBody(Deque<int[]> snake, int y, int x) {
        for (int[] part : snake) {
            if (part[0] == y && part[1] == x) return true;
        }
        return false;
    }
}
