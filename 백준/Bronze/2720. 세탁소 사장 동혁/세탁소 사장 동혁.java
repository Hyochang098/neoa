import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n;i++) {
			int[] change = new int[4];
			int c = sc.nextInt();
			change[0]=c/25;
			c=c%25;
			change[1]=c/10;
			c=c%10;
			change[2]=c/5;
			c=c%5;
			change[3]=c/1;
			for(int C:change) {
				System.out.print(C+" ");
			}

			System.out.println();
		}
	}
}
