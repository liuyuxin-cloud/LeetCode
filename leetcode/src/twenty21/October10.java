package twenty21;

/**
 * 你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * <p>
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 */

public class October10 {
    public static void main(String[] args) {
        Solution10_10 s = new Solution10_10();
        System.out.println(s.arrangeCoins(6));
    }

}

class Solution10_10 {
    public int arrangeCoins(int n) {
        int count = 0;
        while (n >= count) {
            n -= count;
            count++;
        }
        return count - 1;
    }
}

/**
 * 可以通过二分查找计算 n 枚硬币可形成的完整阶梯行的总行数。
 * 因为 1 <n< 2^31−1，所以 n 枚硬币至少可以组成 1 个完整阶梯行，至多可以组成 n 个完整阶梯行（在 n=1 时得到）。
 */
class Solution10_10_1 {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}