import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static List<int[]> permute;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		arr = new int[n];
		visited = new boolean[n];
		permute = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		permut(0, new int[n]);

		int max = Integer.MIN_VALUE;
        for (int[] perm : permute) {
            max = Math.max(max, findsum(perm));
        }
        System.out.println(max);
	}

	private static void permut(int cur, int[] perm) {
		// TODO Auto-generated method stub
		if (cur == n) {
			permute.add(perm.clone());
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm[cur] = arr[i];
				permut(cur + 1, perm);
				visited[i] = false;
			}
		}

	}

	static int findsum(int[] perm) {
		int sum = 0;
		for (int i = 0; i < perm.length - 1; i++) {
			sum += Math.abs(perm[i] - perm[i + 1]);
		}
		return sum;
	}
}