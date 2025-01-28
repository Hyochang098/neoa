import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		int weight = Integer.MIN_VALUE;
		int height = Integer.MIN_VALUE;
		int s_weight = Integer.MAX_VALUE;
		int s_height = Integer.MAX_VALUE;
		int[][] yellow = new int[6][2];
		for (int i = 0; i < 6; i++) {
			yellow[i][0] = sc.nextInt();
			yellow[i][1] = sc.nextInt();
		}

		int h_idx = 0;
		int w_idx = 0;
		for (int i = 0; i < 6; i++) {
			if (yellow[i][0] == 4 || yellow[i][0] == 3) {
				if (height < yellow[i][1]) {
					height = yellow[i][1];
					h_idx = i;
				}
			}
			if (yellow[i][0] == 1 || yellow[i][0] == 2) {
				if (weight < yellow[i][1]) {
					weight = yellow[i][1];
					w_idx = i;
				}

			}
		}
		int s_idx1 = (h_idx + 3) % 6;
		int s_idx2 = (w_idx + 3) % 6;

		if (s_height > yellow[s_idx1][1]) {
			s_height = yellow[s_idx1][1];
		}

		if (s_weight > yellow[s_idx2][1]) {
			s_weight = yellow[s_idx2][1];
		}

		int ans = k * ((height * weight) - (s_weight * s_height));
		System.out.println(ans);
	}
}