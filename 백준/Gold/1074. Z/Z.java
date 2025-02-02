import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int answer = Zstep(N, r, c);
		System.out.println(answer);
	}

	public static int Zstep(int N, int r, int c) {

		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			int n = (int) Math.pow(2, i);

			int r_point = (r / n) % 2;
			int c_point = (c / n) % 2;
			int area = (int) Math.pow(2, 2 * i);

			ans += (2 * r_point + c_point) * area;
		}
		return ans;
	}
}
