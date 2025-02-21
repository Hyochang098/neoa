import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();// 테스트
		for (int tc = 1; tc <= t; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			System.out.print("#"+tc+" ");
			int n = sc.nextInt();// 명령어
			for (int i = 0; i < n; i++) {
				int command = sc.nextInt();
				int num = 0;
				if (command == 1) {
					num = sc.nextInt()*-1;
				}
				switch(command) {
				case 1:
					pq.add(num);
					break;
				case 2:
					if(pq.isEmpty()) {
						System.out.print(-1+" ");
					}else {
						System.out.print(pq.poll()*-1+" ");
					}
					break;
				}

			}
			System.out.println();
		}

	}
}
