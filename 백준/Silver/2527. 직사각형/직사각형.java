import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();

			if (x > A && X > a && y > B && Y > b) {
				System.out.println("a");// 면
			} else if ((a == X && b == Y) || (a == X && y == B) || (x == A && b == Y) || (x == A && y == B)) {
				System.out.println("c"); // 점
			} else if ((a <= X && x >= A && (b == Y || y == B)) || (b <= Y && y >= B && (a == X || x == A))) {
				System.out.println("b");// 선
			} else {
				System.out.println("d");// 없음

			}
		}
	}
}