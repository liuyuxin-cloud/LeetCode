package twenty26;

//172. 阶乘后的零

public class February6_3 {
}

class Solution2_6_3 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}