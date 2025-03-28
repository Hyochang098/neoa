import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int[][] arr = new int[101][101];
            boolean[] visited = new boolean[101];
            Queue<Integer> que = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int num = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arr[num][end] = 1;
            }
            int ans = start;
            visited[start] = true;
            que.add(start);
            while (!que.isEmpty()) {
                int size = que.size();
                int max = 0;
                for (int i = 0; i < size; i++) {
                    int cur = que.poll();
                    max = Math.max(max, cur);
                    for (int k = 1; k <= 100; k++) {
                        if (arr[cur][k] == 1 && !visited[k]) {
                            visited[k] = true;
                            que.add(k);
                        }
                    }
                }
                ans = max;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
