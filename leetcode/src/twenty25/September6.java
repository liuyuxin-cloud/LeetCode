package twenty25;

import java.util.Arrays;

public class September6 {
}

class Solution9_6 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int n = points.length;
        int left = points[0][0], right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int l = points[i][0], r = points[i][1];
            if (l > right) {
                left = l;
                right = r;
            } else {
                left = Math.max(left, l);
                right = Math.min(right, r);
                n--;
            }
        }
        return n;
    }
}