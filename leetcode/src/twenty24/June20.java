package twenty24;

//美丽下标对的数目

public class June20 {
}
class Solution6_20 {
    public int countBeautifulPairs (int[] nums) {
        int res = 0;
        int[] cnt = new int[10];
        for (int x: nums) {
            for (int y = 1; y <= 9; y++) {
                if (gcd(x % 10, y) == 1) {
                    res += cnt[y];
                }
            }
            while (x >= 10) {
                x /= 10;
            }
            cnt[x]++;
        }
        return res;
    }

    private int gcd (int a, int b) { // 9 6
        return b == 0 ? a : gcd(b, a % b);
    }
}