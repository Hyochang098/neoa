import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int a = 0; a < 10; a++) {
            int t = sc.nextInt(); 
            sc.nextLine();
            String dummy = sc.nextLine(); 
            
            String sample = sc.nextLine(); 
            
            int cnt = 0;

            for (int i = 0; i <= sample.length() - dummy.length(); i++) {
                boolean check = true;
                for (int j = 0; j < dummy.length(); j++) {
                    if (sample.charAt(i + j) != dummy.charAt(j)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    cnt++; 
                }
            }

            System.out.println("#" + t + " " + cnt);
        }

    }
}