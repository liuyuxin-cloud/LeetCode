package twenty23;

public class March14_1 {
}
class Solution3_14_1 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r * c != mat.length * mat[0].length) return mat;
        int[] f = new int[r * c];
        int index = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                f[index++] = ints[j];
            }
        }
        index = 0;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = f[index++];
            }
        }
        return ans;
    }
}