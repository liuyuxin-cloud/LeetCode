package twenty26;

//130. 被围绕的区域
public class March12_1 {
}

class Solution3_12_1 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int[][] flag = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, flag, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, flag, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, flag, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, flag, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O' && flag[i][j] == 0)
                    board[i][j] = 'X';
        }
    }

    void dfs(char[][] board, int[][] flag, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || flag[i][j] == 1) {
            return;
        }
        flag[i][j] = 1;
        dfs(board, flag, i - 1, j);
        dfs(board, flag, i + 1, j);
        dfs(board, flag, i, j - 1);
        dfs(board, flag, i, j + 1);
    }
}
