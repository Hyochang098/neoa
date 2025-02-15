import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(fac(n));
	}

	static long fac(int x) {
		if (x < 2) {
			return 1;
		}
		return x * fac(x-1);
	}
}