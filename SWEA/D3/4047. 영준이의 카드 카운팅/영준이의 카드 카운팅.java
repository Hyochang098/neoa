import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			String str = sc.nextLine();
			HashSet<Integer> S_deck = new HashSet<>();
			HashSet<Integer> D_deck = new HashSet<>();
			HashSet<Integer> H_deck = new HashSet<>();
			HashSet<Integer> C_deck = new HashSet<>();
			int s = 13;
			int d = 13;
			int h = 13;
			int c = 13;
			boolean check = true;

			for (int i = 0; i < str.length(); i += 3) {
				char kind = str.charAt(i);
				int num = Integer.parseInt(str.substring(i + 1, i + 3));

				switch (kind) {
				case 'S':
					if (!S_deck.add(num)) {
						check = false;
						break;
					}
					s--;
					break;
				case 'D':
					if (!D_deck.add(num)) {
						check = false;
						break;
					}
					d--;
					break;
				case 'H':
					if (!H_deck.add(num)) {
						check = false;
						break;
					}
					h--;
					break;
				case 'C':
					if (!C_deck.add(num)) {
						check = false;
						break;
					}
					c--;
					break;
				}

				if (!check)
					break;
			}

			if (check)
				System.out.println("#" + tc + " " + s + " " + d + " " + h + " " + c);
			else
				System.out.println("#" + tc + " " + "ERROR");
		}
	}
}