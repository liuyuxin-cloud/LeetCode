package twenty24;

//长度最小的子数组

public class July7 {
}

//滑动窗口
class Solution7_7 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                int len = i - j + 1;
                res = Math.min(res, len);
                sum -= nums[j++];
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}