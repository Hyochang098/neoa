import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for(int i =0; i<lost.length; i++){
            lostSet.add(lost[i]);
        }
        for(int i =0;i<reserve.length;i++){
            reserveSet.add(reserve[i]);
        }
        
        for(int r : reserve){
            if(lostSet.contains(r)){
                lostSet.remove(r);
                reserveSet.remove(r);
            }
        }
        
        for(int donate: reserveSet){
            int front = donate - 1;
            int back = donate + 1;
            if(lostSet.contains(front)){
                lostSet.remove(front);
            }else if(lostSet.contains(back)){
                lostSet.remove(back);
            }
        }
        answer = n- lostSet.size();
        return answer;
    }
}