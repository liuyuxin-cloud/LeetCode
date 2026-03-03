package twenty26;

//918. 环形子数组的最大和

public class March3 {
}

class Solution3_3 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        int leftSum = nums[0];
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            leftSum+= nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum); //前缀和
            pre = Math.max(pre + nums[i], nums[i]); //动态规划
            res = Math.max(res, pre);
        }

        int rightSum = 0;
        for (int i = n-1; i > 0; i--) {
            rightSum+= nums[i];
            res = Math.max(res, leftMax[i-1] + rightSum);
        }
        return res;
    }
}