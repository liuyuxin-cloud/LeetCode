package twenty25;

// 49. 字母异位词分组

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class August26 {
}
// 先用哈希表统计每个单词中字母出现的频率 c -> int
// 若两单词相同则为同一组
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int len = strs.length;
        HashMap<HashMap<Character, Integer>, Integer> map = new HashMap<HashMap<Character, Integer>, Integer>();
        for (int i = 0; i < len; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char c : strs[i].toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            } // 统计每个单词中字母出现的频率
            if (map.containsKey(temp)) { // 若存在相同则加入list
                ans.get(map.get(temp)).add(strs[i]);
            } else {
                map.put(temp, ans.size());
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(strs[i]);
            }
        }
        return ans;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> Arrays.toString(s.codePoints().sorted().toArray()))).values());
    }
}
