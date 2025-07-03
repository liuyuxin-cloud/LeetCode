package twenty25;

//219. 存在重复元素 II

import java.util.HashSet;
import java.util.Set;

public class July3 {

}

class Solution7_3 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k -1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
