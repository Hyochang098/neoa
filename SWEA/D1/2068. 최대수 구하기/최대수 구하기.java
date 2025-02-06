import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			bubblesort(arr);
			System.out.println("#"+tc+" "+arr[0]);
		}
	}

	public static void bubblesort(int[] sample) {
		int n = sample.length;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (sample[j] < sample[j + 1]) {
					int temp = sample[j];
					sample[j] = sample[j + 1];
					sample[j + 1] = temp;
				}

			}

		}
	}

}