package twenty26;

//221. 最大正方形

public class February2 {

}

class Solution2_3 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '0' ? 0 : 1;
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    boolean flag = true;
                    for (int k = i-matrix[i-1][j-1]; k < i; k++) {
                        if (matrix[k][j] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    for (int k = j-matrix[i-1][j-1]; k < j; k++) {
                        if (matrix[i][k] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
    return max * max;
    }
}