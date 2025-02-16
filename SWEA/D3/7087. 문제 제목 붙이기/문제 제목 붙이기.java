import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			sc.nextLine();

			Set<Character> set = new HashSet<>();
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				set.add(temp.charAt(0));
			}

			Character[] arr = set.toArray(new Character[0]);
			Arrays.sort(arr);
			if (arr[0] == 'A') {
				cnt = 1;
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == arr[i - 1] + 1)
						cnt++;
					else
						break;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}