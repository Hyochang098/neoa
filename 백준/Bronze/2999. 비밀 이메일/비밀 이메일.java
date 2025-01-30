import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int a = str.length();
		int b = (int) Math.sqrt(a);
		int r = 0;
		for (int i = 1; i <= b; i++) {
			if (a % i == 0) {
				if (r < i) {
					r = i;
				}
			}
		}
		int c = a / r;
		char[][] arr = new char[c][r];
		for (int i = 0; i < str.length(); i++) {
			arr[i / r][i % r] = str.charAt(i);
		}
		for(int i=0;i<r;i++) {
			for(int j=0; j<c;j++) {
				System.out.print(arr[j][i]);
			}
		}
	}
}
