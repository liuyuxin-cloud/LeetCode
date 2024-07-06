package twenty24;

//有序数组的平方

public class July6_2 {
}
class Solution7_6_2 {
    public int[] sortedSquares(int[] nums) {
        int i;
        int[] ans = new int[nums.length];
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
        }
        if (i == 0) {
            for (int j = 0; j < nums.length; j++) {
                ans[j] = nums[j] * nums[j];
            }
            return ans;
        } else if (i == nums.length) {
            for (int j = 0; j < nums.length; j++) {
                ans[nums.length - j - 1] = nums[j] * nums[j];
            }
            return ans;
        }
        int k = i - 1;
        int j = 0;
        while (i < nums.length && k >= 0) {
            if (nums[i] * nums[i] < nums[k] * nums[k]) {
                ans[j++] = nums[i] * nums[i];
                i++;
            } else {
                ans[j++] = nums[k] * nums[k];
                k--;
            }
        }
        while (i < nums.length) {
            ans[j++] = nums[i] * nums[i];
            i++;
        }
        while (k >= 0) {
            ans[j++] = nums[k] * nums[k];
            k--;
        }
        return ans;
    }

    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0,j = n-1, pos = n-1; i <= j;){
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            pos--;
        }
        return ans;
    }
}