import java.util.Scanner;

public class Solution {
    static String[] arr;    
    static int[][] tree;    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            sc.nextLine();  

            arr = new String[n + 1];    
            tree = new int[n + 1][2];   

            for (int i = 1; i <= n; i++) {
                String[] temp = sc.nextLine().split(" ");
                int node = Integer.parseInt(temp[0]);
                arr[node] = temp[1]; 
                
                if (temp.length == 4) {
                    int left = Integer.parseInt(temp[2]);
                    int right = Integer.parseInt(temp[3]);
                    tree[node][0] = left;  
                    tree[node][1] = right; 
                } else if (temp.length == 3) {
                    int left = Integer.parseInt(temp[2]);
                    tree[node][0] = left;  
                }
            }

            System.out.println("#" + tc);
            
            jae(1);
            System.out.println();
        }
    }

    static void jae(int cur) {
        if (cur == 0) return;  

        jae(tree[cur][0]);

        System.out.print(arr[cur]);

        jae(tree[cur][1]);
    }
}
