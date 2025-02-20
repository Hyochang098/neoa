import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[] visit = new boolean[n + 1];
		int[] arr = new int[m];
		bt(0, m, n, arr, visit);
	}

	 static void bt(// 현재 위치, 목표위치, 전체 범위,저장할 배열, 방문처리
			int cur, int target, int range, int[] arr, boolean[] v) {

		if (cur == target) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= range; i++) {
			if (!v[i]) {
				v[i] = true;
				arr[cur]=i;
				bt(cur + 1, target, range, arr, v);
				v[i] = false;

			}

		}
	}
}