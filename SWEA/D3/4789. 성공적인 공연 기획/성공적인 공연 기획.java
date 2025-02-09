import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			String[] str = (sc.nextLine()).split("");
			int[] audience = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				audience[i] = Integer.parseInt(str[i]);
			}
			int clap = audience[0];
			int ans = 0;
			for (int i = 1; i < audience.length; i++) {
				if (i > clap) {
					ans++;
					clap++;
				}
				clap += audience[i];
			}
			System.out.println("#" + tc + " " + ans);
		}

	}
}