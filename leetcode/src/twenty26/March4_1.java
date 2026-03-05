package twenty26;

//77. 组合

import java.util.ArrayList;
import java.util.List;

public class March4_1 {
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list, res);
        return res;
    }

    private void dfs(int n, int k, int i, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(i);
        dfs(n, k, i + 1, cur, res);
        cur.remove((Integer) cur.size() - 1);
        dfs(n, k, i + 1, cur, res);
    }
}