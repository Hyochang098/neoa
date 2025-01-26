import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] basket = new int[n];
		for (int i = 0; i < n; i++) {
			basket[i] = (i + 1);
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			if (a == b)
				continue;
			else {
				while (a < b) {
					int temp = basket[a];
					basket[a] = basket[b];
					basket[b] = temp;
					a++;
					b--;
				}
			}
		}
		for (int k = 0; k < n; k++) {
			System.out.print(basket[k] + " ");
		}
	}
}