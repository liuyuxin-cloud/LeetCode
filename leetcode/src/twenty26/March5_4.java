package twenty26;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成
public class March5_4 {
}

class Solution3_5_4 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, "", res);
        return res;
    }
    void dfs(int n, int left, int right, String cur, List<String> res) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }
        if (left < n) dfs(n, left + 1, right, cur + "(", res);
        if (right < left) dfs(n, left, right + 1, cur + ")", res);
    }
}