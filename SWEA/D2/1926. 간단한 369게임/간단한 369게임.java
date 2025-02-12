import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int num = 1;
		while (num <= n) {
			String str = String.valueOf(num);
			if (str.contains("3")||str.contains("6")||str.contains("9")) {
				int cnt=0;
				for (int i = 0; i < str.length(); i++) {
					int a = str.charAt(i) -'0';;
					if(a%3==0&&a!=0)
						System.out.print("-");
				}
				System.out.print(" ");
			} else {
				System.out.print(num+" ");
			}
			num++;
		}

	}
}