import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt();
			int dis = 0;
			int cur = 0;
			int speed = 0;
			for (int i = 0; i < n; i++) {
				int command = sc.nextInt();
				if (command != 0) {
					speed = sc.nextInt();
				}
				switch (command) {
				case 0:
					dis += cur;
					break;
				case 1:
					cur += speed;
					dis += cur;
					break;
				case 2:
					if (speed > cur) {
						cur = 0;
					} else {
						cur -= speed;
					}
					dis += cur;
					break;
				}
			}
			System.out.println("#" + tc + " " + dis);
		}
	}
}