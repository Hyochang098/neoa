
import java.util.Scanner;

public class Solution {
	// 재귀로 제곱?
	// m만큼 곱하고 0이되면 1반환?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();

			int ans = pow(n, m);

			System.out.println("#" + num + " " + ans);

		}

	}

	static int pow(int n, int m) {
		// TODO Auto-generated method stub
		if (m == 0) {
			return 1;
		}
		
		int num = pow(n,m/2);
		
		if(m%2==0) {//짝수면 n 리턴하면될듯?
			return num*num;
		}else {
			return num*num*n;
		}

	}
}