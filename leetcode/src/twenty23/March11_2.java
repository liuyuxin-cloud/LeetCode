package twenty23;

public class March11_2 {
}
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxNum = nums[0];
        for(int i: nums) {
            pre = Math.max(pre + i, i);
            maxNum = Math.max(pre, maxNum);
        }
        return maxNum;
    }
}
