import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] line = new int[n];

		for (int i = 0; i < n; i++) {
			line[i] = sc.nextInt();
		}
		Arrays.sort(line);
		int[] time = new int[n];
		int sum=0;
		for (int i = 0; i < n; i++) {
			if (i == 0)
				time[0] = line[0];
			else {
				time[i] = time[i - 1] + line[i];
			}
			sum+=time[i];
		}
		System.out.println(sum);

	}
}
