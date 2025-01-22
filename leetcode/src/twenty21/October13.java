package twenty21;

/**
 * 开始动态规划的学习！！！
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 */
public class October13 {
    public static void main(String[] args){
        System.out.println(new Solution10_13().fib(2));
    }
}

class Solution10_13{
    public int fib(int n) {
        if(n < 2){
            return 1;
        }
        int p=0,q=0,r=1;
        for(int i = 2; i <= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
