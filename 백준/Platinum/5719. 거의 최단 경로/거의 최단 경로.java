import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static int N, M, S, D;
    static List<Edge>[] graph;
    static List<Integer>[] prev;
    static int[] dist;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] nm = br.readLine().split(" ");
            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);
            if (N == 0 && M == 0) break;

            String[] sd = br.readLine().split(" ");
            S = Integer.parseInt(sd[0]);
            D = Integer.parseInt(sd[1]);

            graph = new ArrayList[N];
            prev = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                prev[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                String[] uvp = br.readLine().split(" ");
                int u = Integer.parseInt(uvp[0]);
                int v = Integer.parseInt(uvp[1]);
                int p = Integer.parseInt(uvp[2]);
                graph[u].add(new Edge(v, p));
            }

            dist = new int[N];
            Arrays.fill(dist, INF);
            dijkstra(S);

            Queue<Integer> q = new LinkedList<>();
            q.add(D);
            boolean[][] removed = new boolean[N][N];
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int prevNode : prev[now]) {
                    if (!removed[prevNode][now]) {
                        removed[prevNode][now] = true;
                        q.add(prevNode);
                    }
                }
            }

            List<Edge>[] newGraph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                newGraph[i] = new ArrayList<>();
                for (Edge e : graph[i]) {
                    if (!removed[i][e.to]) {
                        newGraph[i].add(e);
                    }
                }
            }
            graph = newGraph;

            Arrays.fill(dist, INF);
            dijkstra(S);

            int answer = dist[D];
            sb.append(answer == INF ? -1 : answer).append('\n');
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
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