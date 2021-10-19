/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */

public class October19_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 0};
        System.out.println(new Solution10_19_2().canJump(nums));
    }
}

class Solution10_19_2 {
    public boolean canJump(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                flag++;
            }
        }
        if (flag == 0) return true;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == 0) {
                int j = i - 1;
                flag = 0;
                while (i < nums.length - 1 && nums[i] == 0) {
                    i++;
                    flag = 1;
                }
                if (flag == 1) {
                    i--;
                }
                while (j >= 0) {
                    if (nums[j] > i - j) {
                        break;
                    }
                    j--;
                }
                if (j < 0) return false;
            }
            i++;
        }
        return true;
    }
    //贪心算法官方题解
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}


