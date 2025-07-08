
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int maxLevel = 0;
        for (int diff : diffs) {
            maxLevel = Math.max(maxLevel, diff);
        }

        int left = 1;
        int right = maxLevel;
        int answer = maxLevel;

        while (left < right) {
            int level = left + (right - left) / 2;
            long time = times[0];

            for (int i = 1; i < diffs.length; i++) {
                int k = 0;
                if (level < diffs[i]) {
                    k = diffs[i] - level;
                }
                time += (long) (times[i] + times[i - 1]) * k + times[i];
            }

            if (time <= limit) {
                answer = level;
                right = level;
            } else {
                left = level + 1;
            }
        }

        return answer;
    }
}
