package twenty22;

public class November28 {
}

class Solution11_28 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n+1];
        for (int i = 0; i < n; i++) { //求前缀和
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for(int j = 2; j <= k; j++) {
            for(int i = j; i <= n; i++) {
                for(int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j-1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
