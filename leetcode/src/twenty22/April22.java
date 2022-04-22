package twenty22;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class April22 {
    public static void main(String[] args){
        int[][] a = new int[2][2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 1;
        a[1][1] = 1;
        System.out.println(new Solution4_22().minPathSum(a));
    }
}
class Solution4_22{
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] ans = new int[m][n];
        ans[0][0] = grid[0][0];
        for(int i = 1; i < n; i++){
            ans[0][i] = ans[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            ans[i][0] = ans[i-1][0] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                ans[i][j] = Math.min(ans[i-1][j], ans[i][j-1]) + grid[i][j];
            }
        }
        return ans[m-1][n-1];
    }
}