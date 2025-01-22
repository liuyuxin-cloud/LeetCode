package twenty21;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 */

public class November3 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new Solution11_3().numberOfArithmeticSlices1(nums));
    }
}

class Solution11_3 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        dp[1] = 0;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            ans += dp[i];
        }
        return ans;
    }

    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int p = 0;
        int q = 0;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                q = p + 1;
            } else {
                q = 0;
            }
            ans += q;
            p = q;
        }
        return ans;
    }
}