package twenty24;

// 螺旋矩阵 II

public class July12 {
}

class Solution7_12 {
    public int[][] generateMatrix(int n) {

        int[][] nums = new int[n][n];
        int offset = 1, count = 1;
        int loop = 1;
        int i = 0, j = 0;

        while (loop <= n / 2) {
            for (j = offset - 1; j < n - offset; j++) {
                nums[offset-1][j] = count++;
            }
            for (i = offset - 1; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            for (; j > offset - 1; j--) {
                nums[i][j] = count++;
            }
            for (; i > offset - 1; i--) {
                nums[i][j] = count++;
            }
            offset++;
            loop++;
        }

        if (n % 2 == 1) {
            nums[n / 2][n / 2] = count;
        }
        return nums;
    }
}