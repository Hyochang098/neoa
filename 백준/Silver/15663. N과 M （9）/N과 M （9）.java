import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		recursion(0,new int[m]);
		
		

	}

	private static void recursion(int cur,int[] select) {
		// TODO Auto-generated method stub
		if(cur==m) {
			for(int s:select) {
				System.out.print(s+" ");
			}
			System.out.println();
			return;
		}
		int pre = 0;
		for(int i=0;i<n;i++) {
			if(!visited[i]&&arr[i]!=pre) {
				visited[i]=true;
				select[cur]=arr[i];
				recursion(cur+1,select);
				visited[i]=false;
				pre = arr[i];
			}
		}
		
	}
}