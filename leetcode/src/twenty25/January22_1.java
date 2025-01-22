package twenty25;

public class January22_1 {
}

class Solution1_22_1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 2;
        }
        int left = 2, right = 2;
        while (right < n) {
            if (nums[right] != nums[left-2]) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }
}