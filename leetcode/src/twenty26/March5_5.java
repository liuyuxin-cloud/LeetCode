package twenty26;

import java.lang.reflect.Array;
import java.util.Arrays;

//79. 单词搜索
public class March5_5 {
}

class Solution3_5_5 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[][] visited = new int[n][m];
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1) return false;

        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = 1; // 标记已访问
            boolean found = dfs(board, visited, i + 1, j, word, index + 1)
                    || dfs(board, visited, i - 1, j, word, index + 1)
                    || dfs(board, visited, i, j + 1, word, index + 1)
                    || dfs(board, visited, i, j - 1, word, index + 1);
            visited[i][j] = 0; // 回溯：取消标记
            return found;
        }
        return false;
    }
}