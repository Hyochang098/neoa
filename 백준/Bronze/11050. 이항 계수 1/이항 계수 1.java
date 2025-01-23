import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int ans = fac(n)/(fac(n-k)*fac(k));
		System.out.println(ans);
	
	}
	public static int fac(int a) {
		int b=1;
		for(int i=1;i<=a;i++) {
			b *=i;
		}
		return b;
	}



}
