import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int[] arr = new int[n];

		arr[0] = 1;
		int ans = 0;//던진횟수
		int post = 0;//줄사람
		while (arr[post] != m) {
			if (arr[post] % 2 == 0) {
				post = post + l;
			} else {
				post = post - l;
			}
			if (post > n-1)
				post = post - n;
			else if (post < 0)
				post = post+ n;
			arr[post] += 1;
			ans += 1;
		}

		System.out.println(ans);
	}
}
