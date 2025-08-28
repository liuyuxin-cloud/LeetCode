package twenty25;

import java.util.HashSet;
import java.util.Set;

//最长连续序列
public class August28 {
}

class Solution8_28 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int ans = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                ans = Math.max(ans, currentStreak);
            }
        }
        return ans;
    }
}