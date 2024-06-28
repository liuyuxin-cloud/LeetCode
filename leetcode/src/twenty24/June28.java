package twenty24;

//二分查找

public class June28 {
}
class Solution6_28 {
    public int search(int[] nums, int target) {
        return searchLR(nums,target, 0, nums.length-1);
    }
    private int searchLR (int[] nums, int target, int l, int r) {
        if (l <= r) {
            int m = (l+r) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) return searchLR(nums, target, m+1, r);
            else return searchLR(nums, target, l, m-1);
        }
        else return -1;
    }
}