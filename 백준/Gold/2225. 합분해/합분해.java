import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] arr = new int[k + 1][n + 1];

		for (int i = 0; i <= k; i++) {
			arr[i][0] = 1;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000000;
			}
		}
		System.out.println(arr[k][n]);
	}
}
