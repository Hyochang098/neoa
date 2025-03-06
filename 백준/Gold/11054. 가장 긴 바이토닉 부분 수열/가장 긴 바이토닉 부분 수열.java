
import java.util.Scanner;

public class Main {

	// 11054 가장 긴 바이토닉 부분 수열
	// 바이토닉 수열-> 1 2 3 4 3 2 1 처럼 상승하다가 하강하는 수열
	// 상승이나 하강만해도 괜찮음

	// 그러면 dp배열을 3개만들어서? 올라가는거1 내려가는거2 상승하다 하강은?
	// 상승하강은 조건으로?
	// 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] dp1 = new int[n];// 상승
		int[] dp2 = new int[n];// 하강
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp1[i] = 1;
			dp2[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}

			}
		}

		
		//반대로 가면서 기준이 탐색한 수보다 크면 오른쪽에 남아있는 애들은 감소하는 배열임
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp1[i] + dp2[i] - 1);
		}
		System.out.println(ans);
	}
}
