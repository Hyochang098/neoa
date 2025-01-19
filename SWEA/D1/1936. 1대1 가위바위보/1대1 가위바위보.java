import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		b = b + 1;
		a = a % 3;
		b = b % 3;
		if (a == b) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}

}
