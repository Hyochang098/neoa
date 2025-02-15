import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];

		int ans = Integer.MIN_VALUE;
		int h = 0;
		int w = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
				if (ans < arr[i][j]) {
					ans = arr[i][j];
					h = i+1;
					w = j+1;
				}
			}
		}
		System.out.println(ans);
		System.out.println(h+" "+w);
	}
}