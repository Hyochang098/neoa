import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();// 입력
			boolean[] check = new boolean[10];// 확인
			int cnt = 0;// 10개 모엿는지
			int ans = 1;// 몇n까지?
			while (cnt < 10) {
				String str = String.valueOf(n * ans);
				for (int i = 0; i < str.length(); i++) {
					int idx = str.charAt(i)-'0';
					if (!check[idx]) {
						check[idx] = true;
						cnt++;
					}

				}
				ans++;
			}
			int real = (ans-1)*n;
			System.out.println("#"+tc+" "+real);

		}
	}
}