import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			int cmd = sc.nextInt();
			if (cmd == 0) {
				if (heap.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(heap.poll()).append("\n");
			} else {
				heap.add(cmd);
			}
		}
		System.out.println(sb);

	}
}