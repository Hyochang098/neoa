import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();

			int[] num_str1 = new int[str1.length()];
			int[] num_str2 = new int[str2.length()];

			for (int i = 0; i < str1.length(); i++) {
				num_str1[i] = translate(str1.charAt(i));
			}
			for (int i = 0; i < str2.length(); i++) {
				num_str2[i] = translate(str2.charAt(i));
			}
			boolean point = true;
			if (num_str1.length != num_str2.length)
				point = false;
			else {
				for (int i = 0; i < str2.length(); i++) {
					if (num_str1[i] != num_str2[i])
						point = false;
				}
			}
			if (point)
				System.out.println("#" + tc + " SAME");
			else
				System.out.println("#" + tc + " DIFF");
		}
	}

	public static int translate(char c) {
		int result = 0;
		switch (c) {
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			result = 1;
			break;
		case 'B':
			result = 0;
			break;
		case 'C':
		case 'H':
		case 'E':
		case 'F':
		case 'G':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			result = -1;
			break;
		}
		return result;
	}
}