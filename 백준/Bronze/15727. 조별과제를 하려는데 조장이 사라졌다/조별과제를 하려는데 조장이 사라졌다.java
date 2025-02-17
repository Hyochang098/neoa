import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int ans = l / 5;
		if(l%5!=0) {
			ans++;
		}
		System.out.println(ans);

	}
}
