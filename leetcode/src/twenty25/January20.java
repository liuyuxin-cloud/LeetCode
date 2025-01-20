package twenty25;

public class January20 {
}

class Solution1_20 {
    public int findClosestNumber(int[] nums) {
        int min = Math.abs(nums[0]);
        int max = nums[0];
        for (int i: nums) {
            if (Math.abs(i) < min) {
                min = Math.abs(i);
                max = i;
            }else if (Math.abs(i) == min) {
                max = Math.max(max, i);
            }

        }
        return max;
    }
}