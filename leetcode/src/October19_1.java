/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除所有等于nums[i] - 1 和 nums[i] + 1的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */

public class October19_1 {
    public static void main(String[] args){
        int[] nums = new int[]{4};
        System.out.println(new Solution10_19_1().deleteAndEarn(nums));
    }
}

/**
 *此题看似无头绪，与动态规划无关，但是注意到除去点数左右的数也会被删除，可将nums数组中的各数分别计数总和，从而转化为小偷问题。
 */
class Solution10_19_1 {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1)    return nums[0];
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for(int s : sum){
            sum[s] = 0;
        }
        for (int num : nums) {
            sum[num] += num;
        }
        int first = sum[0];
        int second = Math.max(sum[0],sum[1]);
        for(int j = first+2; j <= 10000; j++){
            int temp = second;
            second = Math.max(second, first + sum[j]);
            first = temp;
        }
        return second;
    }
}