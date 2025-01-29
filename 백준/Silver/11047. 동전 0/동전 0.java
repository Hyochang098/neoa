import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int cnt=0;
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			if(k/arr[i]>0) {
				cnt++;
			}
		}
		int[] real = new int[cnt];
		for(int i=0; i<cnt;i++) {
			real[i]=arr[cnt-i-1];
		}
		int ans=0;
		for(int coin:real) {
			ans+=k/coin;
			k%=coin;
		}
		System.out.println(ans);
	}
}
