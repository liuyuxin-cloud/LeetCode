package twenty21;

import java.util.Arrays;

/**
 * 给你一个m x n的矩阵mat和一个整数 k ，请你返回一个矩阵answer，其中每个answer[i][j]是所有满足下述条件的元素mat[r][c] 的和：
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c)在矩阵内。
 */

public class November2 {
    public static void main(String[] args){
        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] ans = new Solution11_2().matrixBlockSum(test,1);
        System.out.println(Arrays.deepToString(ans));
    }
}

class Solution11_2 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] p = prefixSum(mat);
        int[][] answer = new int[m][n];
        int rmin,cmin,cmax,rmax;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rmin = Math.max(i-k, 0);
                rmax = Math.min(m-1, i+k);
                cmin = Math.max(j-k, 0);
                cmax = Math.min(n-1, j+k);
                if(cmin - 1 < 0 && rmin - 1 < 0){
                    answer[i][j] = p[rmax][cmax];
                }
                else if(cmin - 1 < 0 ){
                    answer[i][j] = p[rmax][cmax] - p[rmin-1][cmax];
                }else if(rmin - 1 < 0){
                    answer[i][j] = p[rmax][cmax] - p[rmax][cmin-1];
                }else{
                    answer[i][j] = p[rmax][cmax] - p[rmax][cmin-1] - p[rmin-1][cmax] + p[rmin-1][cmin-1];
                }
            }
        }
        return answer;
    }

    public int[][] prefixSum(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] p = new int[m][n];
        p[0][0] = mat[0][0];
        for(int i = 1; i < m; i++){
            p[i][0] = p[i-1][0] + mat[i][0];
        }
        for(int i = 1; i < n; i++){
            p[0][i] = p[0][i-1] + mat[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + mat[i][j];
            }
        }
        return p;
    }
}