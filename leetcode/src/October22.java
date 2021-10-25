/**
 * 给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，并且两个景点i 和j之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 */

public class October22 {
}

class Solution10_22 {
    public int maxScoreSightseeingPair(int[] values) {
        int mvp = values[0];
        int res = mvp;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, values[i] - i + mvp);
            mvp = Math.max(mvp, values[i] + i);
        }
        Thread
        return res;
    }
}