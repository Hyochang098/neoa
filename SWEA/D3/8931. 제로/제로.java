import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int k = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			boolean check = true;
		
			for (int i = 0; i < k; i++) {
				int money = sc.nextInt();
			
				if (money != 0) {
					stack.push(money);
				} else {
				
					if (stack.isEmpty()) {
						check = false;
					} else {
						stack.pop();
					}
				}
			}
			int ans=0;
			while(!stack.isEmpty()) {
				ans+=stack.pop();
			}
			if(check) {
				System.out.println("#"+tc+" "+ans);
			}else {
				System.out.println("#"+tc+" "+0);
			}

		}

	}
}