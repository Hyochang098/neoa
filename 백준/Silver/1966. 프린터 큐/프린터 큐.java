import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt(); 

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<int[]> queue = new LinkedList<>(); 
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 

            for (int i = 0; i < N; i++) {
                int priority = sc.nextInt();
                queue.add(new int[]{i, priority});
                pq.add(priority);
            }

            int count = 0; 
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int index = current[0];
                int priority = current[1];

                if (priority == pq.peek()) { 
                    pq.poll(); 
                    count++; 
                    if (index == M) { 
                        sb.append(count).append("\n");
                        break;
                    }
                } else { 
                    queue.add(current);
                }
            }
        }
        System.out.print(sb);
    }
}
