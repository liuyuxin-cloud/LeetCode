package twenty21;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */

public class October18_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(new Solution10_18_1().rob(nums));
    }
}

class Solution10_18_1 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            for (int i = 2; i < nums.length; i++) {
                if (i == 2) {
                    dp[0] = nums[0];
                    dp[1] = nums[1];
                    dp[2] = nums[0] + nums[2];
                } else {
                    dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
                }
            }

        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
