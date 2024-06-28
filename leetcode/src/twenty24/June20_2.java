package twenty24;

//删除有序数组中的重复项

public class June20_2 {

}

class Solution6_20_2 { //  0 1 1 2 2 3 3 4
    public int removeDuplicates(int[] nums) {
        int res = nums.length; // 8
        for (int i = 1; i < res; i++) {     //i
            if (nums[i] == nums[i-1]) {     //
                for (int j = i+1; j < res; j++) {
                    nums[j-1] = nums[j]; //0 1 1 1 2 2 3 3 4
                }
                res--;
            }
        }
        return res;
    }

    public int removeDuplicates1(int[] nums) {
        int pre = 0, cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pre]) {
                nums[++pre] = nums[i];
            }
        }
        return pre-1;
    }
}