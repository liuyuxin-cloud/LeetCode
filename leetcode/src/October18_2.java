/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */

public class October18_2 {
    public static void main(String[] args){
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution10_18_2().minCostClimbingStairs(cost));
    }
}

class Solution10_18_2 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        if(len == 1 || len == 2){
            return Math.min(cost[0], cost[1]);
        }else{
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = Math.min(cost[0], cost[1]);
            for(int i = 3; i < len+1; i++){
                dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
            }
        }
        return dp[len];
    }
}