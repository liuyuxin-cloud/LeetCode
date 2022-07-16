package twenty22;

public class July16 {
}
class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            for (int i = row1; i < row2; i++) {
                for (int j = col1; j < col2; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
        return 0;
    }
}

class NumMatrix1 {
    int[][] sums;

    public NumMatrix1(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
