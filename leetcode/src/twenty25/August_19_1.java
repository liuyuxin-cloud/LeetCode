package twenty25;

//3. 无重复字符的最长子串

import java.util.HashMap;

public class August_19_1 {
}

class Solution8_19_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        int left = 0;
        HashMap map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, (int) map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}