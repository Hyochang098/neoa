import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[] answer = new int[11];
		answer[1]=1;
		answer[2]=2;
		answer[3]=4;
		for(int i=4;i<11;i++) {
			answer[i]=answer[i-2]+answer[i-1]+answer[i-3];
		}
		for(int tc=0;tc<t;tc++) {
			int n =sc.nextInt();
			
			System.out.println(answer[n]);
		}
	}
}