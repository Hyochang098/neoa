import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] basicArr = new int[n][n];
			int[][] spinArr1 = new int[n][n];
			int[][] spinArr2= new int[n][n];
			int[][] spinArr3= new int[n][n];
			
			String[][] ans = new String[n][3];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					basicArr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					ans[i][j] = "";
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					spinArr1[i][j] = basicArr[n-j-1][i];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					spinArr2[i][j] = basicArr[n-i-1][n-j-1];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					spinArr3[i][j] = basicArr[j][n-i-1];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ans[i][0]+=String.valueOf(spinArr1[i][j]);
					ans[i][1]+=String.valueOf(spinArr2[i][j]);
					ans[i][2]+=String.valueOf(spinArr3[i][j]);
				}
			}
			System.out.println("#"+tc);
			for (int i = 0; i < n; i++) {
			    System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
			}

		}
	}
}