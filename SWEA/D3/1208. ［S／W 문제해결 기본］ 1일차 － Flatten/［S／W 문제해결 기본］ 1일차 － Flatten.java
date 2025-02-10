import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();

			int[] box = new int[100];

			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);
			while (dump > 0) {
				box[99]--;
				box[0]++;
				dump--;
				if (box[0] > box[1] || box[99] < box[98]) {
					Arrays.sort(box);
				}
			}
			Arrays.sort(box);
			System.out.println("#"+tc+" "+(box[99] - box[0]));
		}
	}
}
