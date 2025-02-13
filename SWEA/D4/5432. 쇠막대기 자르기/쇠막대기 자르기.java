import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
        sc.nextLine();

        for (int tc = 1; tc <= t; tc++) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            int pipe = 0; 
            int laser = 0; 

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('('); 
                } else { 
                    stack.pop(); 
                    
                    if (str.charAt(i - 1) == '(') { 
                        laser++;
                        pipe += stack.size();
                    } else { 
                        pipe += 1;
                    }
                }
            }
            System.out.println("#" + tc + " " + pipe);
        }
    }
}
