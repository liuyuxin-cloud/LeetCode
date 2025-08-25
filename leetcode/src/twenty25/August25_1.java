package twenty25;

// 30. 串联所有单词的子串

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class August25_1 {
}

class Solution8_25_1 {
    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wLen = words.length;
        int wordLen = words[0].length();
        if (s.length() == 0 || words.length == 0 || sLen < wLen * wordLen) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        HashMap<String, Integer> wMap = new HashMap<>();
        for (String word : words) {
            wMap.put(word, wMap.getOrDefault(word, 0) + 1);
        }

        for (int j = 0; j < wordLen; j++) { // 滑动窗口的起始位置
            HashMap<String, Integer> sMap = new HashMap<>();
            for (int i = j; i < j + wLen * wordLen; i += wordLen) {
                if (j + wLen * wordLen > sLen) break;
                sMap.put(s.substring(i, i + wordLen), sMap.getOrDefault(s.substring(i, i + wordLen), 0) + 1);
            }
            if (sMap.equals(wMap)) list.add(j);
            for (int i = j; i + wLen * wordLen + wordLen <= sLen; i += wordLen) {
                sMap.put(s.substring(i + wordLen * wLen, i + wordLen * wLen + wordLen), sMap.getOrDefault(s.substring(i + wordLen * wLen, i + wordLen * wLen + wordLen), 0) + 1);
                sMap.put(s.substring(i, i + wordLen), sMap.get(s.substring(i, i + wordLen)) - 1);
                if (sMap.get(s.substring(i, i + wordLen)) <= 0) sMap.remove(s.substring(i, i + wordLen));
                if (sMap.equals(wMap)) list.add(i + wordLen);
            }
        }
        return list;
    }
}