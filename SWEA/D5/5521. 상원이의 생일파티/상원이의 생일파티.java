import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] relation = new int[n + 1][n + 1];


            Queue<Integer> que = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            visited[1]=true;
            int ans =0;
            for(int i=0;i<m;i++){
                int owner= sc.nextInt();
                int friend = sc.nextInt();
                if(owner==1){
                    que.add(friend);
                    visited[friend]=true;
                    ans++;
                }
                relation[owner][friend]=1;
                relation[friend][owner]=1;
            }

            while(!que.isEmpty()){
                int next = que.poll();
                for(int i=1;i<n+1;i++){
                    if(relation[next][i]==1&&relation[1][next]==1&&!visited[i]){
                        visited[i]=true;
                        que.add(i);
                        ans++;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}