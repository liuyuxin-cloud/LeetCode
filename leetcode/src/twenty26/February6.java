package twenty26;

//188. 买卖股票的最佳时机 IV

public class February6 {
}

class Solution2_6 {
    public int maxProfit(int k, int[] prices) {
        k = Math.min(k, prices.length / 2);
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = 0;
        }
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - price);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + price);
            }
        }
        return dp[k][1];
    }
}
