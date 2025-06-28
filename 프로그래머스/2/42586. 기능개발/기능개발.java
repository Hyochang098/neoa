import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> answer = new ArrayList<Integer>();
        int[] complete = new int[n];

        for (int i = 0; i < n; i++) {
            if((100-progresses[i])%speeds[i]!=0){
                complete[i]=((100-progresses[i])/speeds[i])+1;
            }else{
                complete[i]=(100-progresses[i])/speeds[i];
            }
        }

        int max = complete[0];
        int completeCnt = 1;

        for (int i = 1; i < n; i++) {
            if (complete[i] <= max) {
                completeCnt++;
            } else {
                answer.add(completeCnt);
                max = complete[i];
                completeCnt = 1;
            }
        }
        answer.add(completeCnt);
        return answer;
    }
}
