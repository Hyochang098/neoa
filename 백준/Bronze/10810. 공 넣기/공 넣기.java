import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0; i<m; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			
			int num = sc.nextInt();
			for(int j =a; j<b+1
					;j++) {
			
				arr[j]=num;
				
			}
		}

		for (int num:arr) {
			System.out.print(num+ " ");
		}
	}
}
