package twenty26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. 组合总和
public class March5_2 {
}

class Solution3_5_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, list, res);
        return res;
    }
    void dfs(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res)  {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }
}