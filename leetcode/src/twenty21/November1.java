package twenty21;

import java.util.Arrays;

/**
 *给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class November1 {
}

class Solution11_1 {
    //双指针
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    //动态规划
    public boolean isSubsequence1(String s, String t) {
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        Arrays.fill(dp[0],true);
        int row = 0;
        while (++row<=s.length()){
            int col = 0;{
                while (++col<=t.length()){
                    dp[row][col] = s.charAt(row-1) == t.charAt(col-1)?dp[row-1][col-1]:dp[row][col-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    //状态压缩一维数组
    public boolean isSubsequence2(String s, String t) {
        boolean[] dp = new boolean[t.length()+1];
        Arrays.fill(dp,true);
        int sIdx = -1;
        boolean preStatus = true;
        while (++sIdx<s.length()){
            int tIdx = 0;
            dp[0] = false;
            preStatus = sIdx==0;
            while (++tIdx <= t.length()){
                boolean current = dp[tIdx];
                dp[tIdx] = s.charAt(sIdx)==t.charAt(tIdx-1)?preStatus:dp[tIdx-1];
                preStatus = current;
            }
        }
        return dp[t.length()];
    }
}

