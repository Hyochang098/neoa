import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] arr = new int[a];
		int count = 0;
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
			if (prime(arr[i]) == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean prime(int a) {
		if (a < 2)
			return false;
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
