package twenty21;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

public class October26 {
}
class Solution10_26 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(1);
        ans.add(item);
        int k = 1;
        while(k < numRows){
            List<Integer> items = new ArrayList<>();
            items.add(1);
            for(int i = 1; i < k; i++){
                items.add(ans.get(ans.size()-1).get(i-1) + ans.get(ans.size()-1).get(i));
            }
            items.add(1);
            ans.add(items);
            k++;
        }
        return ans;
    }
}