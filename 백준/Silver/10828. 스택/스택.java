import java.util.Scanner;
import java.util.Stack;

// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
public class Main {
	public static void main(String[] args) {
        // 문제 10828 해결을 위한 코드를 작성하세요.
    	Scanner sc = new Scanner(System.in);
    	Stack<Integer> stack =new Stack<>();
    	int n =sc.nextInt();
    	sc.nextLine();
    	
    	for(int i =0;i<n; i++) {
    		String str = sc.nextLine();
    		if(str.startsWith("push")) {
    			int a = Integer.parseInt(str.split(" ")[1]);
    			stack.push(a);
    		}else if(str.equals("top")) {
    			if (stack.empty())
    				System.out.println(-1);
    			else
    			System.out.println(stack.peek());
    		}else if(str.equals("size")) {
    			System.out.println(stack.size());
    		}else if(str.equals("empty")) {
    			if (stack.empty())
    				System.out.println(1);
    			else
    				System.out.println(0);
    		}else if(str.equals("pop")) {
    			if (stack.empty())
    				System.out.println(-1);
    			else
    				System.out.println(stack.pop());
    		}
    	}
    	
    	
    }
}