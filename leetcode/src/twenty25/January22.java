package twenty25;

import java.util.Arrays;

public class January22 {
}

class Solution1_25 {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int ans = 0;
        for (int i = n/3; i < n-1; i+=2) {
            ans += piles[i];
        }
        return ans;
    }
}