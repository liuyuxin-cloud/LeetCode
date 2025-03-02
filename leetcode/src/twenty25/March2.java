package twenty25;

//290. 单词规律

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.StreamSupport;

public class March2 {
    public static void main(String[] args) {
        Solution3_2 solu = new Solution3_2();
        System.out.println(solu.wordPattern("abc", "b c a"));
    }
}

class Solution3_2 {
    public boolean wordPattern(String pattern, String s) {
        List<String> list = new ArrayList<>();
        HashMap map = new HashMap();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                String str = s.substring(start, i);
                list.add(str);
                start = i+1;
            }
            if (i == s.length()-1) {
                String str = s.substring(start, i+1);
                list.add(str);
            }
        }

        if (pattern.length() != list.size()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String string = list.get(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(string)) return false;
            } else {
                if (map.containsValue(string)) return false;
                else map.put(c, string);
            }
        }
        return true;
    }
}