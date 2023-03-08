package twenty23;

import java.util.Arrays;

public class March7 {
    public static void main(String[] args) {
        Solution3_7 s = new Solution3_7();
        System.out.println(s.PredictTheWinner(new int[]{1,5,2}));
    }

}

class Solution3_7 {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total (int[] nums, int l, int r, int turn) {
        if (l == r) {
            return nums[l] * turn; // 递归最里层
        }
        int scoreStart = nums[l] * turn + total(nums, l+1, r, -turn); // 选择第一个递归下一次
        int scoreEnd = nums[r] * turn + total(nums, l, r-1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn; // 递归最外层返回结果
    }
}