package twenty24;

//在排序数组中查找元素的第一个和最后一个位置

public class June29 {

}

class Solution6_29 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag == 0 && nums[i] == target) {
                res[0] = i;
                res[1] = i;
                flag = 1;
            }
            else if (flag == 1 && nums[i] == target) {
                res[1] = i;
            }
        }
        return res;
    }
}