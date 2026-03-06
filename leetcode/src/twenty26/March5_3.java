package twenty26;

//52. N 皇后 II

import java.util.ArrayList;
import java.util.List;

public class March5_3 {
}

class Solution5_3_4 {
    public int totalNQueens(int n) {
        List<Integer> list = new ArrayList<>();
        int[][] queens = new int[n][n];
        place(queens, 0, n, list);
        return list.size();
    }
    void place(int[][] queens, int row, int n, List<Integer> res) {
        if(row == n) {
            res.add(1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(queens, row, i)) {
                queens[row][i] = 1;
                place(queens, row + 1, n, res);
                queens[row][i] = 0;
            }
        }
    }
    boolean isValid(int[][] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i][col] == 1) return false;
            if (col - row + i >= 0 && queens[i][col - row + i] == 1) return false;
            if (col + row - i < queens.length && queens[i][col + row - i] == 1) return false;
        }
        return true;
    }

}
