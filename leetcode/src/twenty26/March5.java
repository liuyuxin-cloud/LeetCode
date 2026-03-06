package twenty26;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

//46. 全排列
public class March5 {
}

class Solution3_5 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(res, list, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> list, int first) {
        if (first == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i < list.size(); i++) {
            swap(list, first, i);
            dfs(res, list, first + 1);
            swap(list, first, i);
        }
    }

    void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}