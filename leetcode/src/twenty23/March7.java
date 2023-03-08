package twenty23;

import java.util.Arrays;

public class March7 {
    public static void main(String[] args) {
        Solution3_7 s = new Solution3_7();
        System.out.println(s.PredictTheWinner1(new int[]{1,5,2}));
    }

}

class Solution3_7 {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int l, int r, int turn) {
        if (l == r) {
            return nums[l] * turn; // 递归最里层
        }
        int scoreStart = nums[l] * turn + total(nums, l + 1, r, -turn); // 选择第一个递归下一次
        int scoreEnd = nums[r] * turn + total(nums, l, r - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn; // 递归最外层返回结果
    }

    // dp[i][j] = Max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
    public boolean PredictTheWinner1(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = nums.length-1; i >= 0; i--) {
            for(int j = i+1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][nums.length-1] > 0;
    }
}