package twenty22;

import java.util.*;

public class April6 {
}
class Solution4_6 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }

    public void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i = begin; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }
}