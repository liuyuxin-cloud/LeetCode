/**
 *泰波那契序列Tn定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数n，请返回第 n 个泰波那契数n 的值。
 * 0 1 1 2 4 7
 */

public class October13_1 {
    public static void main(String[] args){
        System.out.println(new Solution10_13_1().tribonacci(5));
    }
}

class Solution10_13_1{
    public int tribonacci(int n) {
        if(n < 2){
            return n;
        }
        if(n == 2) return 1;
        int p = 0,q = 1,r = 1,s = 2;
        for(int i = 3; i < n; i++){
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }
}
