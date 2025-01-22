import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int[] ranking = new int[n];
		for (int i = 0; i < n; i++) {
			int score=1;
			for (int j = 0; j < n; j++) {
				if(arr[i][0]<arr[j][0]) {
					if(arr[i][1]<arr[j][1]){
						score+=1;
						ranking[i]=score;
					}else {
						continue;
					}
				}else
					ranking[i]=score;

			}
		}
		for(int i=0; i<n; i++) {
			System.out.print(ranking[i]+" ");
		}
	}
}
