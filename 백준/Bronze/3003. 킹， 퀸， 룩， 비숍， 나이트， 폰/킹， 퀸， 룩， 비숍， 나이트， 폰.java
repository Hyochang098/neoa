import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] correct_chess = new int[] {1, 1, 2, 2, 2, 8};
		
		for(int i=0;i<6;i++) {
			int ans=0;
			int num=sc.nextInt();
			ans = correct_chess[i]-num;
			System.out.print(ans+" ");
		}
		

	}
}
