
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int start = (int) Math.ceil(Math.sqrt(m));
		int end = (int)  Math.floor(Math.sqrt(n));

		int sum=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=start;i<=end;i++) {
			int temp = i*i;
			sum+=temp;
			if(min>temp) {
				min=temp;
			}
		}
		if(sum==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}