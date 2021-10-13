import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * N皇后问题的递归解法
 */
public class July12 {
    public static void main(String[] args) {
        Solution7_12 s = new Solution7_12();
        List<List<String>> answer = new ArrayList<>();
        answer = s.solveNQueens(4);
        System.out.println(answer);
    }
}
class Solution7_12 {

    public List<List<String>> solveNQueens(int n) {
        int[][] cb = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            for (int j = 0; j < n; j++) {
                cb[i][j] = 0;
            }
        }
        NQueens(cb,0,n,ans);
        return ans;
    }
    public void printResult(int[][] cb,int n,List<List<String>> ans){
        int i,j;
        List<String> s = new ArrayList<>();
        for( i = 0 ; i < n ; i++ ){
            for( j = 0 ; j < n ; j++ ) {
                if (cb[i][j] == 1) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[j] = 'Q';
                    s.add(new String(row));
                }
            }
        }
        ans.add(s);
    }
    public void NQueens(int[][] cb,int row,int n,List<List<String>> ans){
        int col;
        if( row > n-1 ){
            printResult(cb,n,ans);
            return ;
        }
        for( col = 0 ; col < n ; col++ ){
            if(isDanger(cb,row,col,n)){
                cb[row][col] = 1;
                NQueens( cb,row + 1 ,n,ans);
                cb[row][col] = 0;
            }
        }
    }
    public boolean isDanger(int[][] cb, int row, int col,int n){
        int i,j;
        for( i = 0 ; i < n ; i++ ){//row
            if(cb[row][i] == 1)
                return false;
        }
        for( i = 0 ; i < n ; i++ ){//column
            if(cb[i][col] == 1)
                return false;
        }
        for( i = 0 ; i < n ; i++ ){
            for( j = 0 ; j < n ; j++ ){
                if( cb[i][j] == 1 && abs(i-row) == abs(j-col) )
                    return false;
            }
        }
        return true;
    }
    public int abs(int a) {
        return (a < 0) ? -a : a;
    }
}