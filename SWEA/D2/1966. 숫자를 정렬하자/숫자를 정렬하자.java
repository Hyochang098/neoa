
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 1; i < n; i++) {
				int num = arr[i];
				int j;
				for (j = i - 1; j >= 0 && num < arr[j]; j--) {

					arr[j + 1] = arr[j];
				}
				arr[j + 1] = num;
			}
			System.out.print("#" + tc + " ");
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}
}