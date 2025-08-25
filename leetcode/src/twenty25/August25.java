package twenty25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 438. 找到字符串中所有字母异位词

public class August25 {
}

class Solution8_25 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        if (sMap.equals(pMap)) list.add(0);

        for (int i = 1; i <= s.length() - p.length(); i++) {
            sMap.put(s.charAt(i + p.length() - 1), sMap.getOrDefault(s.charAt(i + p.length() - 1), 0) + 1);
            sMap.put(s.charAt(i - 1), sMap.get(s.charAt(i - 1)) - 1);
            if (sMap.get(s.charAt(i - 1)) <= 0) sMap.remove(s.charAt(i - 1));
            if (sMap.equals(pMap)) list.add(i);
        }
        return list;

    }
}
