
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean check = true;
			for (int i = 0; i < n; i++) {
				if((m&(1<<i))==0) {
					check=false;
					break;
				}
				
			}
			if (check)
				System.out.println("#"+tc+" ON");
			else
				System.out.println("#"+tc+" OFF");
			// 2진수 변환? 없이 && 1111(n개만큼)이랑 하면 됮 ㅣ않음?

		}
	}
}