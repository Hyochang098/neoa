import java.util.HashMap;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=0;tc<t;tc++) {
			int n =sc.nextInt();
			HashMap<String, Integer> closet = new HashMap<>();
			for(int i = 0; i<n;i++) {
				String item = sc.next();
				String wear = sc.next();
				closet.put(wear, closet.getOrDefault(wear, 0)+1 );
			}
			int ans=1;
			for(int a:closet.values()) {
				ans*=(a+1);
			}
			ans= ans-1;
			System.out.println(ans);
		}

		
	}
}