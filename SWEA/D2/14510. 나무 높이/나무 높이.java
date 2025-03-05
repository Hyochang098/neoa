import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[] tree = new int[n];

			int high = 0;
			for (int i = 0; i < n; i++) {
				tree[i] = sc.nextInt();
				high = Math.max(high, tree[i]);
			}

			int day = 1;
			int complete = 0;
			while (complete < n) {
				// 정렬하고 제일 끝은 최댓값임
				// 그러면 조건문을 역순으로 돌면서(n-1)부터 high가 아닌경우에 더해주기?
				complete = 0;
//				System.out.println(n+" "+complete);
				for (int i = 0; i < n; i++) {
					if (tree[i] == high)
						complete = complete + 1;
				}
				Arrays.sort(tree);
				int grow = 0;
				int next = 0;
				if (day % 2 == 0) {
					grow = 2;
					next = 1;
				} else {
					grow = 1;
					next = 2;
				}
				// 정렬햇으니까 제일 목표를 제외하면n-2임 아니면 어쩔거임?
				// 반복문으로 찾는다?(while)?(for)?
				// 4
				// 2 3 5 10

				for (int i = n - 1; i >= 0; i--) {
					if (tree[i] != high) {// 아닌 제일 큰수 찾고 연산 해주고 넘기기
						if (tree[i] + grow <= high && tree[i] + next != high) {
							tree[i] += grow;
//							System.out.println(Arrays.toString(tree));
							break;
						}
					}
				}

				// 차이를 확인하고 아니면 다른 수에게 더해주기
				if (complete == n) {
					continue;
				} else {
					day++;
				}

			}
			int ans = day - 1;
			System.out.println("#" + tc + " " + ans);

		}

	}

}
