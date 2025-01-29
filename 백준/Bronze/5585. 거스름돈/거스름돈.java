import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int change = 0;
		n=1000-n;
		change += n/500;
		n%=500;
		change += n/100;
		n%=100;
		change += n/50;
		n%=50;
		change += n/10;
		n%=10;
		change += n/5;
		n%=5;
		change += n;
		System.out.println(change);
	}
}
