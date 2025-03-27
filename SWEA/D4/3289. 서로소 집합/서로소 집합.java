import java.util.Scanner;

public class Solution {
	// n -> 1부터 n까지
	// m -> 간선 갯수
	// 입력형태
	// 0 합집합->union 1 포함->find
	// 간선정보 2개

	static int[] parents, rank;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			System.out.print("#"+tc+" ");
			n = sc.nextInt();
			parents = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				parents[i] = i;
			}
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int com = sc.nextInt();

				int a = sc.nextInt();
				int b = sc.nextInt();
				
				switch (com) {
				case 1:
					if (find(a) == find(b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
					break;
				case 0:
					union(a, b);
					break;
				}

			}
			System.out.println();
		}
	}

	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		int x = find(a);
		int y = find(b);
		if (x == y)
			return;
		if (rank[x] < rank[y]) {
			parents[x] = y;
		} else if (rank[x] > rank[y]) {
			parents[y] = x;
		} else {
			parents[y] = x;
			rank[x]++;
		}
	}

	private static int find(int b) {
		if (b == parents[b]) {
			return b;
		} else {
			return find(parents[b]);
		}
	}
}