
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int p_x=0;
			int p_y=0;
			
			int q_x=0;
			int q_y=0;
			
			int a = 2;// 증가
			int idx = 0;// 배열 인덱스
			int col = 0;// 배열 인덱스(줄)
			int ans = 1;// 배열안의 값 (순서, p, q)
			int cnt = 0;// 증가값에 추가할 연산
			int first = 1;// 전 줄 시작값
			int[][] arr = new int[300][300];

			while (true) {
				if(col==299) {
					break;
				}
				arr[col][idx++] = ans;
				if(p==ans) {
					p_x=idx-1;
					p_y=col;
				}
				if(q==ans) {
					q_x=idx-1;
					q_y=col;
				}
				ans += a;
				a++;
				if (idx==299) {
					cnt++;
					col++;
					a = 2 + cnt;
					ans = first + cnt;
					first = ans;
					idx = 0;
				}
			} 
			int nx = p_x+q_x;
			int ny = p_y+q_y;
			System.out.println("#"+tc+" "+arr[ny+1][nx+1]);
		}
	}
}