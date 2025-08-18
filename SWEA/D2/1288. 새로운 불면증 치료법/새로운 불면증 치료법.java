
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            int step = 1;
            boolean[] visited = new boolean[10];
            int cnt=0;

            while (true) {
                int cur = n * step;
                String s = String.valueOf(cur);
                for(int k=0;k<s.length();k++) {
                    if (visited[s.charAt(k) - '0']) {
                        continue;
                    }
                    visited[s.charAt(k) - '0'] = true;
                    cnt++;
                }
                if(cnt==10) {
                    System.out.println("#" + i + " " + cur);
                    break;
                }
                step++;
            }

        }

    }
}
