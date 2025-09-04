package twenty25;

//57. 插入区间

import java.util.Arrays;

public class September4 {
}

class Solution9_3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int left = newInterval[0];
        int right = newInterval[1];
        int index = 0;
        boolean isPlaced = false;

        for (int[] interval : intervals) {
            if (isPlaced) {
                // 如果新区间已经放置，直接添加后续所有区间
                res[index++] = interval;
            } else if (interval[1] < left) {
                // 当前区间在新区间左侧，无重叠
                res[index++] = interval;
            } else if (interval[0] > right) {
                // 当前区间在新区间右侧，无重叠
                // 先放置合并后的新区间
                res[index++] = new int[]{left, right};
                // 再放置当前区间
                res[index++] = interval;
                isPlaced = true;
            } else {
                // 有重叠，合并区间
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        // 如果循环结束后新区间还未放置，则放置它
        if (!isPlaced) {
            res[index++] = new int[]{left, right};
        }

        return Arrays.copyOf(res, index);
    }
}