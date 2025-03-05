
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 1.두개의 리스트를 갱신하면서?
	// 2.5*5배열을 만들고 아래로 내리면서 더하면되나?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] tri = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = sc.nextInt();
			}
		}

		// 1번
		ArrayList<Integer> pre = new ArrayList<>();
		pre.add(tri[0][0]);
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> cur = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {// pre의 모든 수를 꺼내고 tri에 있는 경우랑 더함 
				int num = tri[i][j];
				int sub = tri[i][j];
				if (j == 0) {// 시작
					num += pre.get(j);
				} else if (i == j) {// 마지막
					num += pre.get(j - 1);
				} else {// 중간에 있는애들은 두가지 경우가 있는데 최댓값으로 넣음
					num += pre.get(j);
					sub += pre.get(j - 1);
					num = Math.max(num, sub);
				}
				cur.add(num);
			}
			pre = cur;
		}
		int ans = 0;
		for (int p : pre) {
			ans = Math.max(ans, p);
		}
		System.out.println(ans);
	}
}