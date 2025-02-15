
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			boolean[] stone = new boolean[n];

			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				if (num == 1) {
					stone[i] = true;
				}
			}

			for (int i = 0; i < m; i++) {
				int center = sc.nextInt() - 1;
				int range = sc.nextInt();
				for (int j = 1; j <= range; j++) {
					if(center+j<n&&center-j>=0) {
						if(stone[center+j]&&stone[center-j]) {
							stone[center+j]=false;
							stone[center-j]=false;
						}else if(!stone[center+j]&&!stone[center-j]) {
							stone[center+j]=true;
							stone[center-j]=true;
						}
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (boolean b : stone) {
				if (b) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

}