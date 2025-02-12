import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= t; tc++) {
			String str = sc.nextLine();
			int ans = 0;
			for (int i = 0; i < str.length(); i++) {
				boolean check = true;
				if (str.charAt(i) != (str.charAt(str.length() - 1 - i))) {
					check = false;
					break;
					
				}
				if (check)
					ans = 1;
				else
					ans = 0;
			}
			System.out.println("#" + tc + " " + ans);

		}

	}
}