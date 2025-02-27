package twenty21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class July6 {
    public static void main(String arg[]){
        Solution1 s = new Solution1();
        int[] nums = {1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        res = s.permute(nums);
        for(List<Integer> n : res){
            System.out.println(n);
        }
    }

}
class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
        }
    }
}

