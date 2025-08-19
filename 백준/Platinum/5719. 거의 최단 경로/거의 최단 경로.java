import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int n, m, s, d;
    static List<Edge>[] graph;
    static List<Integer>[] prev;
    static int[] dist;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            if (n == 0 && m == 0) break;

            String[] in = br.readLine().split(" ");
            s = Integer.parseInt(in[0]);
            d = Integer.parseInt(in[1]);

            graph = new ArrayList[n];
            prev = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                prev[i] = new ArrayList<>();
            }

            for (int i = 0; i <m; i++) {
                String[] tmp = br.readLine().split(" ");
                int u = Integer.parseInt(tmp[0]);
                int v = Integer.parseInt(tmp[1]);
                int p = Integer.parseInt(tmp[2]);
                graph[u].add(new Edge(v, p));
            }

            dist = new int[n];
            Arrays.fill(dist, INF);
            find(s);

            Queue<Integer> q = new LinkedList<>();
            q.add(d);
            boolean[][] removed = new boolean[n][n];
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int prevNode : prev[now]) {
                    if (!removed[prevNode][now]) {
                        removed[prevNode][now] = true;
                        q.add(prevNode);
                    }
                }
            }

            List<Edge>[] newGraph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                newGraph[i] = new ArrayList<>();
                for (Edge e : graph[i]) {
                    if (!removed[i][e.to]) {
                        newGraph[i].add(e);
                    }
                }
            }
            graph = newGraph;

            Arrays.fill(dist, INF);
            find(s);

            int answer = dist[d];
            sb.append(answer == INF ? -1 : answer).append('\n');
        }
        System.out.print(sb);
    }

    static void find(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;
            for (Edge next : graph[cur.to]) {
                int nextCost = cur.cost + next.cost;
                if (dist[next.to] > nextCost) {
                    dist[next.to] = nextCost;
                    pq.offer(new Edge(next.to, nextCost));
                    prev[next.to].clear();
                    prev[next.to].add(cur.to);
                } else if (dist[next.to] == nextCost) {
                    prev[next.to].add(cur.to);
                }
            }
        }
    }
}