import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
public class Main {
	public static void main(String[] args) {
        // 문제 10828 해결을 위한 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		int n = sc.nextInt(); // 명령어 수 입력
		sc.nextLine();
		
		for (int i = 0; i < n; i++) { // 반복문 수정
			String str = sc.nextLine(); // 명령어 입력

			if (str.startsWith("push")) {
				int a = Integer.parseInt(str.split(" ")[1]); // 정수 추출
				que.add(a);
			} else if (str.equals("pop")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.poll());
				}
			} else if (str.equals("front")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.peek());
				}
			} else if (str.equals("size")) {
				System.out.println(que.size());
			} else if (str.equals("empty")) {
				if (que.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (str.equals("back")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(((LinkedList<Integer>) que).getLast());
				}
			}
		}
    	
    	
    }
}