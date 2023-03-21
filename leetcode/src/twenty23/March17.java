package twenty23;

import java.util.Arrays;

public class March17 {
    public static void main (String[] args) {
        Solution3_17 s = new Solution3_17();
        s.setZeroes(new int[][]{{0,1}});
    }
}
class Solution3_17 {
    public void setZeroes(int[][] matrix) {
        int firstRow = 1, firstColumn = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = 0;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = 0;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow == 0) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColumn == 0) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}