import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] stackvisited = new boolean[n + 1];
		stack.add(v);
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (stackvisited[cur])
				continue;
			else
				stackvisited[cur]=true;{
			System.out.print(cur + " ");
			for (int i = n; i >= 1; i--) {
				if (arr[cur][i] == 1 && stackvisited[i] == false) {
					stack.add(i);
				}}
			}
		}

		System.out.println();
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] quevisited = new boolean[n + 1];
		que.add(v);
		quevisited[v] = true;
		while (!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur + " ");
			for (int i = 1; i <= n; i++) {
				if (arr[cur][i] == 1 && quevisited[i] == false) {
					que.add(i);
					quevisited[i] = true;
				}
			}
		}

	}

}