import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int c = a / b;
			int d = a % b;
			
			System.out.print("#"+test+" ");
			System.out.print(c+" ");
			System.out.println(d);

		}

	}
}