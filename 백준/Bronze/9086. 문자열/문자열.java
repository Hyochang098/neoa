import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			String str = sc.next();
			char f = str.charAt(0);
			char l = str.charAt(str.length() - 1);
			System.out.print(f);
			System.out.print(l);
			System.out.println();
		}
	}
}