package twenty23;

public class March14 {
}
class Solution3_14 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i-1], prices[i]);
            profit = Math.max(profit, prices[i] - dp[i-1]);
        }
        return profit;
    }
}