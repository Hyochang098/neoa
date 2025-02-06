import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt()-1;
			ArrayList<Integer> pre = new ArrayList<Integer>();
			pre.add(1);
			System.out.println("#" + tc);
			System.out.println(1);
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> cur = new ArrayList<>();
				cur.add(1);
				for (int j = 1; j < pre.size(); j++) {
					cur.add(pre.get(j - 1) + pre.get(j));
				}
				cur.add(1);

				pre = cur;

				for (int j = 0; j < pre.size(); j++) {
					System.out.print(pre.get(j) + " ");
				}
				System.out.println();
			}
		}
	}
}