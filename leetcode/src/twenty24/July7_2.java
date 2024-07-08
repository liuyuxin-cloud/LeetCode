package twenty24;

//水果成篮

import java.util.HashMap;
import java.util.Map;

public class July7_2 {
}

class Solution7_7_2 {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) return 1;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int left = 0, right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left] - 1));
                if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}