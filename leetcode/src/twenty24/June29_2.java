package twenty24;

//x的平方根

public class June29_2 {
}

class Solution6_29_2 {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 1, r = x / 2, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if ((long) m * m <= x) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}