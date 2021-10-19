import static java.lang.Math.max;

/**
 * 0-1背包问题的动态规划求解
 */
public class October18 {
    public static void main(String[] args){
        int[] value = new int[]{6,3,5,4,6};
        int[] weight = new int[]{2,2,6,5,4};
        int n = 5;
        int range = 10;
        System.out.println(new Solution10_18().knapStak(value,weight,n,range));
    }
}

class Solution10_18{
    public int knapStak(int value[], int weight[], int n, int range) {
        int[][] dp= new int[ n + 1][range + 1];
        for (int i = 0; i <= range; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // 这里是比较经典的状态转移方程
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                // 当前这个物品的重量比背包最大的容量还要大的时候，不取当前物品，最大价值承接自上一个物品能获得的最大价值
                if (weight[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    // 当前物品是可以放入背包的，这时就要进行决策，
                    // 有两种选择：
                    // 1. 不放入背包，承接上一个物品的最大价值
                    // 2，放入背包，此时要回溯到前一个位置的容量减去本物品质量的价值 再加上本物品价值就可以了
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                System.out.print( dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][range];
    }
}
