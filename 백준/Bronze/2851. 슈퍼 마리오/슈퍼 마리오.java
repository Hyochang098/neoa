import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mush = new int[10];
		int[] mushSum = new int[10];
		for (int i = 0; i < 10; i++) {
			mush[i] = sc.nextInt();
			if (i == 0)
				mushSum[i] = mush[i];
			else
				mushSum[i] = mush[i] + mushSum[i - 1];
		}
		for (int i = 0; i < 10; i++) {
			if (mushSum[i] > 100) {
				if (i == 0) {
					System.out.println(mushSum[i]);
					break;
				} else {
					if ((100 - mushSum[i - 1]) >= (mushSum[i] - 100)) {
						System.out.println(mushSum[i]);
						break;
					} else {
						System.out.println(mushSum[i - 1]);
						break;
					}
				}
			}
			if (mushSum[9] <= 100) {
				System.out.println(mushSum[9]);
				break;
			}
		}
	}
}
