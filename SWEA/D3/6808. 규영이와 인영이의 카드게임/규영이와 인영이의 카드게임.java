import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	// 1 ~ 18 총18
	// 9 9 나눠서
	// 서로 카드 내고 높은 점수가 두사람 카드합만큼
	// 총점이 높으면 됨
	// 규영이 카드 순서 고정
	// 위 고정된 순서에 따른 인영이의 조합에 따라서 승패가 판별됨

	// 카드 9개 정보가 나옴
	// 나머지 9개는 인영
	// 9개의 조합을 만듬
	// 1 2
	// 2 1
	// 위 두가지 경우는 다른 결과를 만드니 순열
	// 9! = 362,880
	static int[] kyu;
	static int[] young;
	static boolean[] card;
	static boolean[] visited;
	static int win;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			card = new boolean[19];
			for (int i = 0; i < 9; i++) {
				int idx = sc.nextInt();
				card[idx] = true;
			}
			kyu = new int[9];
			young = new int[9];
			visited = new boolean[9];
			win = 0;
			int k_idx = 0;
			int y_idx = 0;
			for (int i = 1; i < 19; i++) {
				if (!card[i]) {
					young[y_idx++] = i;
				} else {
					kyu[k_idx++] = i;
				}
			}

			permute(0, new int[9]);

			System.out.println("#" + tc + " " + win + " " + (362880 - win));
		}
	}

	static void permute(int cur, int[] select) {
		// TODO Auto-generated method stub
		if (cur == 9) {
			verse(select);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				select[cur] = young[i];
				permute(cur + 1, select);
				visited[i] = false;
			}
		}
	}

	private static void verse(int[] select) {
		// TODO Auto-generated method stub
		int k_point = 0;
		int y_point = 0;
//		System.out.println(Arrays.toString(kyu));
//		System.out.println(Arrays.toString(young));
		for (int i = 0; i < 9; i++) {
			if (kyu[i] > select[i]) {
				k_point += (kyu[i] + select[i]);
			} else if (kyu[i] < select[i]) {
				y_point += (kyu[i] + select[i]);
			}
		}
		if (k_point > y_point) {
			win++;
		}
	}
}