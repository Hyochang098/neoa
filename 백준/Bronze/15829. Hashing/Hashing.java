import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int[] arr = new int[n];
		for(int i =0; i<n;i++) {
			arr[i] = (int) str.charAt(i)-96;
		}
		long hash =0;
		int r=31;
		
		for(int j=0; j<n; j++) {
			hash += arr[j]*(long)Math.pow(r, j);
		}
		System.out.println(hash%1234567891);
	}
}
