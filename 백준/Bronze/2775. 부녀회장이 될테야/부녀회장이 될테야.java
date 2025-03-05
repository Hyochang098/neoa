import java.util.Scanner;

public class Main {
	static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		// k층 n호에 얼마나 사나
		// 0층에 n호는 n만큼의 사람이 삼
		// k층 n호 에는 k-1층 의 1~n까지의 합
		// k층 n호 = k층 n-1호+k-1층 n호
		// 2차원 배열?
		// 매 줄마다?

		for (int tc = 1; tc <= t; tc++) {
			k = sc.nextInt();
			n = sc.nextInt();

			System.out.println(find());
		}

	}

	private static int find() {
		// TODO Auto-generated method stub
		int[][] apart = new int[k+1][n+1];//k층 n호 0층 이 존재 n은 1호부터 n까지
		for(int i=1;i<n+1;i++) {//0층 i호는 i명임
			apart[0][i]=i;
		}
		for(int i=1;i<k+1;i++) {//
			for(int j=1;j<n+1;j++) {
				apart[i][j]=apart[i][j-1]+apart[i-1][j];
			}
		}
		
		return apart[k][n];
	}
}