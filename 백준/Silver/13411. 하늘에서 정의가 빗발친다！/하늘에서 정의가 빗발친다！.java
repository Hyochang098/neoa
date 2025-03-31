import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		double[][] robot = new double[n][2];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int speed = sc.nextInt();
			double time = Math.sqrt(x * x + y * y) / speed;
			robot[i][1] = time;
			robot[i][0] = i + 1;
		}

		Arrays.sort(robot, (a, b) -> Double.compare(a[1], b[1]));

		for (int i = 0; i < n; i++) {
			System.out.println((int) robot[i][0]);
		}
	}
}
