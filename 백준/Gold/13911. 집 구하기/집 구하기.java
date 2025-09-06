import java.io.*;
import java.util.*;

public class Main {
    static class Edge { int to,w; Edge(int t,int w){this.to=t; this.w=w;} }
    static class Node implements Comparable<Node>{
        int v,d;
        Node(int v,int d){this.v=v; this.d=d;}
        public int compareTo(Node o){ return d==o.d? v-o.v : d-o.d; }
    }
    static final int INF = 1_000_000_000;

    static int[] dijkstra(List<Edge>[] g, int[] sources, int limit){
        int n = g.length-1;
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int s: sources){ dist[s]=0; pq.add(new Node(s,0)); }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.d!=dist[cur.v]) continue;
            if(limit>0 && cur.d>limit) continue;
            for(Edge e: g[cur.v]){
                int nd = cur.d + e.w;
                if(nd < dist[e.to]){
                    dist[e.to]=nd;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
        List<Edge>[] g = new ArrayList[V+1];
        for(int i=1;i<=V;i++) g[i]=new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b,w));
            g[b].add(new Edge(a,w));
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] mac = new int[M];
        boolean[] isM = new boolean[V+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){ mac[i]=Integer.parseInt(st.nextToken()); isM[mac[i]]=true; }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[] star = new int[S];
        boolean[] isS = new boolean[V+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++){ star[i]=Integer.parseInt(st.nextToken()); isS[star[i]]=true; }

        int[] distM = dijkstra(g, mac, X);
        int[] distS = dijkstra(g, star, Y);

        long ans = Long.MAX_VALUE;
        for(int v=1; v<=V; v++){
            if(isM[v] || isS[v]) continue;
            if(distM[v] <= X && distS[v] <= Y){
                long sum = (long)distM[v] + distS[v];
                if(sum < ans) ans = sum;
            }
        }
        bw.write(ans==Long.MAX_VALUE ? "-1\n" : ans+"\n");
        bw.flush();
    }
}
