package twenty24;

// 螺旋矩阵

import java.util.ArrayList;
import java.util.List;

public class July15 {
}

class Solution7_15 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>(m * n);
        int offset = 0;
        int loop = 0;
        int min = Math.min(m, n);
        int i = 0, j = 0;

        while (loop < min / 2) {

            for (j = offset; j < n - offset - 1; j++) {
                ans.add(matrix[offset][j]);
            }

            for (i = offset; i < m - offset - 1; i++) {
                ans.add(matrix[i][j]);
            }

            for (; j > offset; j--) {
                ans.add(matrix[i][j]);
            }

            for (; i > offset; i--) {
                ans.add(matrix[i][j]);
            }
            offset++;
            loop++;
        }

        if (min % 2 == 1) {
            if (min == m) {
                for (; j < n - offset - 1; j++) {
                    ans.add(matrix[m / 2][j]);
                }
            }
            if (min == n) {
                for (; i < m - offset - 1; i++) {
                    ans.add(matrix[i][n / 2]);
                }
            }
        }
        return ans;
    }
}