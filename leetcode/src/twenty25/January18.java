package twenty25;

import java.util.HashMap;

public class January18 {
}
class Solution1_18 {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int at = map.get(c);
            ans += Math.abs(at - i);
        }
        return ans;
    }
}