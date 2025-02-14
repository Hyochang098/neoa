
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n + m];
		for (int i = 0; i < n + m; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		for (int a : arr) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}