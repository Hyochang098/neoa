import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] smuf = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			smuf[i] = sc.nextInt();
			sum += smuf[i];
		}

		sum = sum - 100;

		Loop:
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if ((smuf[i] + smuf[j]) == sum) {
					smuf[i] = 0;
					smuf[j] = 0;
					break Loop;
				}
			}
		}
		Arrays.sort(smuf);

		for(int i =0; i<9; i++) {
			if(smuf[i] !=0)
			System.out.println(smuf[i]);
		}

	}
}
