import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] arr = new boolean[42];
		
		for(int i=0; i<10; i++) {
			int a = sc.nextInt();
			arr[a%42]=true;
		}
		int ans=0;
		for(int i=0; i<42; i++) {
			if(arr[i])
				ans++;
		}
		System.out.println(ans);
	
	}
}