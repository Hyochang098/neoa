import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		PriorityQueue<Long> card = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			card.add((long) sc.nextInt());
		}
		long[] list = new long[n];
		for (int i = 0; i < m; i++) {
			long t1 = card.poll();
			long t2 = card.poll();
			long t3 = t1 + t2;
			card.add(t3);
			card.add(t3);
		}

		long ans = 0;
		while (!card.isEmpty()) {
			ans += card.poll();
		}
		System.out.println(ans);
	}
}