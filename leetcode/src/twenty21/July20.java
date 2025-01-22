package twenty21;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */

public class July20 {
    public static void main(String[] args){
        Solution7_20 s = new Solution7_20();
        System.out.println(s.reverse(123));
    }
}

class Solution7_20 {
    public int reverse(int x) {
        int res = 0;
        while(x!=0) {
            int tmp = x%10;
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}