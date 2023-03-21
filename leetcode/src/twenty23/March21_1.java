package twenty23;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class March21_1 {
    public static void main(String[] args) {
        Solution3_21_1 s = new Solution3_21_1();
        s.firstUniqChar("leetcode");
    }
}
class Solution3_21_1 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
                index.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        int in = -1;
        for (char c: map.keySet()) {
            if (map.get(c) == 1) {
                if (in == -1) in = index.get(c);
                else in = Math.min(in, index.get(c));
            }
        }
        return in;
    }
}