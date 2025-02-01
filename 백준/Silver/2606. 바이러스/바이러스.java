import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point =sc.nextInt();
		int node = sc.nextInt();
		
		int[][] computer= new int[point+1][point+1];
		
		for(int i=0; i<node;i++) {
			int a= sc.nextInt();
			int b= sc.nextInt();
			computer[a][b]=1;
			computer[b][a]=1;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[point+1];
		queue.add(1);
		visited[1]=true;
		while (!queue.isEmpty()) {
			int cur=queue.poll();
			
			for(int i =1; i<point+1;i++) {
				if(computer[cur][i]==1&&!visited[i]) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		int ans = 0;
		for(boolean a:visited) {
			if(a)
				ans++;
		}
		System.out.println(ans-1);
	}
}