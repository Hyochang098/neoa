import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int reachableTownCount = 0;
        final int INF = Integer.MAX_VALUE;

        int[][] travelTime = new int[N + 1][N + 1];
        for (int town = 1; town <= N; town++) {
            Arrays.fill(travelTime[town], INF);
            travelTime[town][town] = 0;
        }

        for (int[] path : road) {
            int from = path[0];
            int to = path[1];
            int time = path[2];
            travelTime[from][to] = Math.min(travelTime[from][to], time);
            travelTime[to][from] = Math.min(travelTime[to][from], time);
        }

        int[] minTimeFromStart = new int[N + 1];
        Arrays.fill(minTimeFromStart, INF);
        minTimeFromStart[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTown = current[0];
            int currentTime = current[1];

            if (currentTime > minTimeFromStart[currentTown]) continue;

            for (int nextTown = 1; nextTown <= N; nextTown++) {
                if (travelTime[currentTown][nextTown] == INF) continue;

                int newTime = currentTime + travelTime[currentTown][nextTown];
                if (newTime < minTimeFromStart[nextTown]) {
                    minTimeFromStart[nextTown] = newTime;
                    pq.offer(new int[]{nextTown, newTime});
                }
            }
        }

        for (int town = 1; town <= N; town++) {
            if (minTimeFromStart[town] <= K) {
                reachableTownCount++;
            }
        }

        return reachableTownCount;
    }
}
