package twenty24;

//有效的完全平方数

public class June30 {
}

class Solution6_30 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int l = 1, r = num / 2;
        while (l <= r) {
            int m = (l + r) / 2;
            if ((long)m * m == num) return true;
            else if ((long)m * m < num) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}