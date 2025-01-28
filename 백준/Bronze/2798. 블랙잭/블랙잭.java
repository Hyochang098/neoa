import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] card = new int[n];
		for(int i=0; i<n;i++) {
			card[i]=sc.nextInt();
		}
		int ans=0;
		Loop:
		for(int i=0; i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					if(card[i]+card[j]+card[k]==m) {
						ans=card[i]+card[j]+card[k];
						break Loop;
					}else if(card[i]+card[j]+card[k]<m) {
						if(card[i]+card[j]+card[k]>ans)
						ans=card[i]+card[j]+card[k];
					}else {
						continue;
					}
				}
			}
		}
		System.out.println(ans);
	}
}