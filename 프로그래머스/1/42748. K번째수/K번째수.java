import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            answer[i] = calculate(array,commands[i]);
        }
        return answer;
    }
    public int calculate(int[] array,int[] command){
        int start = command[0]-1;
        int end = command[1]-1;
        int idx = command[2]-1;
        int[] temp = new int[end-start+1];
        int index = 0;
        for(int i = start; i<=end; i++){
            temp[index++]=array[i];
        }
        Arrays.sort(temp);
        return temp[idx];
    }
}