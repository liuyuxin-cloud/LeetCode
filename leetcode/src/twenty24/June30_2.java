package twenty24;

//移动零

public class June30_2 {
}

class Solution6_30_2 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int c = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[l] != 0) {
                nums[l++] = nums[i];
                c++;
                continue;
            }
            l++;
        }
        while (c > 0) {
            nums[nums.length - c] = 0;
            c--;
        }
    }
}
