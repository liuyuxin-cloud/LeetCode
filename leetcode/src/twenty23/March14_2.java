package twenty23;

import java.util.ArrayList;
import java.util.List;

public class March14_2 {
}
class Solution3_14_2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            for (int j = 1; j < i; j++) {
                ans.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            if(i >= 1) ans.add(1);
            list.add(ans);
        }
        return list;
    }
}