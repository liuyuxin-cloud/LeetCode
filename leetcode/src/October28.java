/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */

public class October28 {
    public static void main(String[] args){
        System.out.println(new Solution10_28().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
class Solution10_28 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            f[i][0] = 1;
        }
        //初始化第一行，只要碰到1，后面都无法到达
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            f[0][i] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if(obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                }else{
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[n - 1][m - 1];
    }
}