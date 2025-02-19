import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			sc.nextLine();

			int[][] farm = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < n; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}

			int center = n / 2;

			int step = 0;
			int ans = 0;
			while (step <= center) {
			    int left = center - step;
			    int right = center + step;

			    
			    for (int i = left; i <= right; i++) {
			        ans += farm[step][i];
			        if (step != center) {
			            ans += farm[n - 1 - step][i];
			        }
			    }

			    step++; 
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
} 