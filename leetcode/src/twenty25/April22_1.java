package twenty25;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 */

public class April22_1 {
    public static void main(String[] args) {
        Solution4_22_1 s = new Solution4_22_1();
        s.productExceptSelf(new int[]{1, 2, 3, 4});
    }
}
class Solution4_22_1 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(ans));
        int sum = nums[nums.length-1];
        for (int i = nums.length-2; i > 0; i--) {
            ans[i] = ans[i] * sum;
            sum *= nums[i];
        }
        return ans;
    }
}