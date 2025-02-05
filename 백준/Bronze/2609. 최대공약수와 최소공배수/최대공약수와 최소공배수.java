import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int k = sc.nextInt();
		int n = Math.max(a,k);
		k = Math.min(a,k);
		int large = Ucl(n,k);//최대공약수
		int Small = n*k/large;
		System.out.println(large);
		System.out.println(Small);
	
	}
	public static int Ucl(int a, int b) {
		while (b!=0) {
			int c = a%b;
			a =b;
			b = c;
		}
		return a;
	}



}
