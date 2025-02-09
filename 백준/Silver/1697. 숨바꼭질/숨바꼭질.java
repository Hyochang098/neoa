import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        queue.add(n);
        visit[n] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (cur == k) {
                    return time;
                }

                int[] arr = {cur - 1, cur + 1, cur * 2};
                for (int pre : arr) {
                    if (pre >= 0 && pre < 100001 && !visit[pre]) {
                        queue.add(pre);
                        visit[pre] = true;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
