import java.util.Scanner;

public class Solution {
	static int[] tickets = new int[4];
	static int[] months = new int[12];
	static int[] sel = new int[12];
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				tickets[i] = sc.nextInt();
			}
			for (int i = 0; i < 12; i++) {
				months[i] = sc.nextInt();
			}
			combi(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void combi(int cur) {
		if (cur >= 12) {
			int pay = cal();
			if (pay != 0)
				ans = Math.min(ans, pay);
			return;
		}

		sel[cur] = 0;
		combi(cur + 1);

		sel[cur] = 1;
		combi(cur + 1);

		for (int i = 0; i < 3; i++) {
			if (cur + i >= 12)
				break;
			sel[cur + i] = 2;
		}
		combi(cur + 3);
		for (int i = 0; i < 3; i++) {
			if (cur + i >= 12)
				break;
			sel[cur + i] = -1;
		}

		sel[cur] = 3;
		combi(12);
		sel[cur] = -1;
	}

	static int cal() {
		int result = 0;
		for (int i = 0; i < 12; i++) {
			int select = sel[i];
			if (select == 0) {
				result += tickets[0] * months[i];
			}
			if (select == 1) {
				result += tickets[1];
			}
			if (select == 2) {
				result += tickets[2];
				i += 2;
			}
			if (select == 3) {
				result += tickets[3];
				break;
			}
		}
		return result;
	}
}
