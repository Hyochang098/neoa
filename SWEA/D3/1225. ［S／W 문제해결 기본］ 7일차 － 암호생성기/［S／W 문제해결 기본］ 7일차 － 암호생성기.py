
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int t = sc.nextInt();
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				que.add(sc.nextInt());
			}

			int key = 1;

			while (true) {
				int num = que.poll();
				if (key >= num) {
					num = 0;
					que.add(num);
					break;
				} else {
					num -= key;
					que.add(num);
				}
				key = (key + 1) % 6;
				if(key==0) {
					key=1;
				}
			}
			System.out.print("#" + t + " " );
			while(!que.isEmpty()) {
				System.out.print(que.poll()+" ");
			}
			System.out.println();
		}
	}
}