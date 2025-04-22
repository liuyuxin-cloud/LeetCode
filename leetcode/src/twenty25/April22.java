package twenty25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * H指数
 */
public class April22 {
}

class Solution4_22 {
    public int hIndex(int[] citations) {
        Integer[] integers = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, (a, b) -> b - a);
        int ans = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] > i) {
                ans = i + 1;
            }
        }
        return ans;
    }
}