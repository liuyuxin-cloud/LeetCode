/**
 *给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */

public class October25 {
}
class Solution10_25{
    public int maxProfit(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {  // 卖出有利可图
                ans += (arr[i] - arr[i-1]);
            }
        }

        return ans;
    }
}