/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class July14 {
    public static void main(String[] args){
        Solution7_14 s = new Solution7_14();
        System.out.println(s.climbStairs(3));
    }
}
//递归超时
class Solution7_14 {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        else{
            return climbStairs(n-1) + climbStairs(n-2);
        }
    }
}
//动态规划 滚动数组
class Solution7_14_1 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
