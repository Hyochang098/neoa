import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = Integer.MIN_VALUE;
		int winner = 0;
		for (int j = 0; j < 5; j++) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += sc.nextInt();
			}
			if(max<sum) {
				max=sum;
				winner=j+1;
			}
		}
		System.out.println(winner+" "+max);
	}
}