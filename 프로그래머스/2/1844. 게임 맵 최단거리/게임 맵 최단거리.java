import java.util.*;

class Solution {
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] range = new int[n][m];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0});
        range[0][0]=1;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y= cur [0];
            int x= cur [1];
            if(y==n-1&&x==m-1){
                return range[y][x];
            }
            for(int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny>=0&&ny<n
                   &&nx>=0&&nx<m
                   &&range[ny][nx]==0&&maps[ny][nx]==1){
                    range[ny][nx]=range[y][x]+1;
                    que.add(new int[]{ny,nx});
                }
            }
            
        }
        return -1;
    }
}