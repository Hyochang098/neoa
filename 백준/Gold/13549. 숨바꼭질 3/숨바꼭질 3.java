import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> deque = new ArrayDeque<>();

        dist[N] = 0;
        deque.add(N);

        while (!deque.isEmpty()) {
            int x = deque.poll();

            if (x == K) {
                System.out.println(dist[x]);
                return;
            }

            if (2 * x <= MAX && dist[2 * x] > dist[x]) {
                dist[2 * x] = dist[x];
                deque.addFirst(2 * x);
            }

            if (x + 1 <= MAX && dist[x + 1] > dist[x] + 1) {
                dist[x + 1] = dist[x] + 1;
                deque.addLast(x + 1);
            }

            if (x - 1 >= 0 && dist[x - 1] > dist[x] + 1) {
                dist[x - 1] = dist[x] + 1;
                deque.addLast(x - 1);
            }
        }
    }
}
