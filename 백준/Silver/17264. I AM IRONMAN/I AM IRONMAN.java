import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 총 게임 횟수
		int m = Integer.parseInt(st.nextToken());// 데이터

		st = new StringTokenizer(br.readLine());
		int win = Integer.parseInt(st.nextToken()); // 승리 점수
		int lose = Integer.parseInt(st.nextToken()); // 패배 점수
		int goal = Integer.parseInt(st.nextToken()); // 목표 점수

		HashMap<String, Integer> hacker = new HashMap<>();

		int iron = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String player = st.nextToken();

			if (st.hasMoreTokens()) {
				String result = st.nextToken();
				if (result.equals("W"))
					hacker.put(player, win);
			} else {
				hacker.put(player, -lose);
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String player = st.nextToken();
			int result = -lose;
			if (hacker.containsKey(player)) {
				result = hacker.get(player);
			}

			iron += result;
			if (iron < 0) {
				iron = 0;
			}
			if (iron >= goal) {
				System.out.println("I AM NOT IRONMAN!!");
				return;
			}
		}
		System.out.println("I AM IRONMAN!!");
	}
}
