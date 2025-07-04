class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        recursion(numbers,0,0,target);
        return answer;
    }
    public void recursion(int[] numbers, int cur, int sum,int target){
        if(cur==numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
        recursion(numbers, cur+1, sum-numbers[cur], target);
        recursion(numbers, cur+1, sum+numbers[cur], target);        
    }
}