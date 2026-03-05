package twenty26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. 电话号码的字母组合
public class March4 {
}

class Solution3_4 {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, 0, "", res, map);
        return res;
    }

    public void dfs(String digits, int index, String cur, List<String> res, Map<Character, String> map) {
        if (index == digits.length())
            res.add(cur);
        else {
            char c = digits.charAt(index);
            for (int i = 0; i < map.get(c).length(); i++) {
                char ch = map.get(c).charAt(i);
                dfs(digits, index + 1, cur + ch, res, map);
            }
        }
    }
}