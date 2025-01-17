package twenty25;

import java.util.HashMap;

/**
 * 四数相加 II
 * 分组 + 哈希表
 */
public class January14_1 {
}
class Solution1_14_1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k : nums1) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(k + nums2[j])) {
                    map.replace(k + nums2[j], map.get(k + nums2[j]) + 1);
                } else {
                    map.put(k + nums2[j], 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -(nums3[i] + nums4[j]);
                if (map.containsKey(sum)) {
                    ans += map.get(sum);
                }
            }
        }
        return ans;
    }
}