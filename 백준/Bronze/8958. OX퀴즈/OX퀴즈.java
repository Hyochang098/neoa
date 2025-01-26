import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int tc=0;tc<n;tc++) {
			String str = sc.next();
			int score = 0;
			int current =0;
			for(int i=0; i<str.length();i++) {
				char s = str.charAt(i);
				if(s == 'O') {
					current+=1;
					score+=current;
				}else if(s == 'X') {
					current =0;
				}
			}
			System.out.println(score);
		}
	}
}