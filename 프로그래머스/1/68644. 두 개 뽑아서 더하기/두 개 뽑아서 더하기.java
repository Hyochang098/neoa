import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> combination = new TreeSet();
        for(int i=0;i < numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                combination.add(numbers[i]+numbers[j]);
            }
        }
        answer = new int[combination.size()];
        int index = 0;
        for(int num : combination) {
            answer[index++] = num;
        }
        return answer;
    }
}