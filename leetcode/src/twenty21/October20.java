package twenty21;

/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 */

public class October20 {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new Solution10_20().canJump1(nums));
    }
}
class Solution10_20 {
    public int canJump1(int[] nums) {
        int count = 0;
        int n = nums.length;
        int rightmost = 0;

        return count;
    }
}