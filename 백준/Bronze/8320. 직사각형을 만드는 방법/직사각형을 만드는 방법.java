import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 0;
		int c = 0;
		while (c <= a) {
			b++;
			c = b * b;
		}
		int ans = a;
		for (int i = 2; i < b; i++) {
			c = ((a - i*i)/ i)+1;
			ans += c;
		}
		System.out.println(ans);
	}
}