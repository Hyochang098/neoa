import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double max = 0;
		int sum = 0;
		for (int i = 0; i < a; i++) {
			int score= sc.nextInt();
			sum+=score;
			if (score> max)
				max = score;
		}
		double ans =  (sum/(a*max)*100);
		System.out.print(ans);
	}

}