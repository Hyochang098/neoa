import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String seat = sc.next();

		int Count = 1;
		for (int i = 0; i < n; i++) {
			if (seat.charAt(i) == 'S') {
				Count++;
			} else if (seat.charAt(i) == 'L') {
				Count++;
				i++;
			}
		}
		if (Count > n)
			System.out.println(n);
		else
			System.out.println(Count);
	}
}
