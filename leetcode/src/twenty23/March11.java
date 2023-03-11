package twenty23;

import java.util.HashMap;
import java.util.Map;

public class March11 {
    public static void main(String[] args) {
        Solution3_11 s = new Solution3_11();
        System.out.println(s.containsDuplicate(new int[]{1,5,2, 3,}));
    }
}
class Solution3_11 {
    public boolean containsDuplicate(int[] nums) {
        Map map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }else{
                return true;
            }
        }
        return false;
    }
}