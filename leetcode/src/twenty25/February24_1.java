package twenty25;

//205. 同构字符串

import java.util.HashMap;

public class February24_1 {
}

class Solution2_24_1 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int m = s.length(), n = t.length();
        if (m != n) return false;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
            else {
                if (t.charAt(i) != map.get(s.charAt(i))) return false;
            }
        }
        return true;
    }
}