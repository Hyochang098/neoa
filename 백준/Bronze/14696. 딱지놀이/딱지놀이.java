import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();
			int[] arr_a = new int[4];
			for (int i = 0; i < a; i++) {
				int k = sc.nextInt() - 1;
				arr_a[k]++;
			}
			int b = sc.nextInt();
			int[] arr_b = new int[4];
			for (int i = 0; i < b; i++) {
				int k = sc.nextInt() - 1;
				arr_b[k]++;
			}
			if (arr_a[3] > arr_b[3]) {
				System.out.println("A");
			} else if (arr_a[3] < arr_b[3]) {
				System.out.println("B");
			} else {
				if (arr_a[2] > arr_b[2]) {
					System.out.println("A");
				} else if (arr_a[2] < arr_b[2]) {
					System.out.println("B");
				} else {
					if (arr_a[1] > arr_b[1]) {
						System.out.println("A");
					} else if (arr_a[1] < arr_b[1]) {
						System.out.println("B");
					} else {
						if (arr_a[0] > arr_b[0]) {
							System.out.println("A");
						} else if (arr_a[0] < arr_b[0]) {
							System.out.println("B");
						} else
							System.out.println("D");
					}
				}
			}

		}
	}
}
