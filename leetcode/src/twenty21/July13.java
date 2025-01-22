package twenty21;

import java.util.Arrays;

/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 */
public class July13 {
    public static void main(String[] args){
        Solution7_13 s = new Solution7_13();
        String str = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(s.shortestToChar(str, c)));
    }
}
//我的解法
class Solution7_13 {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            int left=i,right=i;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == c){
                    ans[i] = abs(left - i);
                    break;
                }
                if(s.charAt(right) == c){
                    ans[i] = abs(right - i);
                    break;
                }
                left--;
                right++;
            }
            while(left >= 0 && right == s.length()){
                if(s.charAt(left) == c){
                    ans[i] = abs(left - i);
                    break;
                }
                left--;
            }
            while(left < 0 && right < s.length()){
                if(s.charAt(right) == c){
                    ans[i] = abs(right - i);
                    break;
                }
                right++;
            }
        }
        return ans;
    }
    public int abs(int a) {
        return (a < 0) ? -a : a;
    }
}
//贪心算法
class Solution7_13_2 {
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}