package twenty21;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class October20_1 {
    public static void main(String[] args){
        int[] nums = new int[]{4,3,-5,2};
        System.out.println(new Solution10_20_1().maxSubArray(nums));
    }
}

class Solution10_20_1 {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
        }
        int max = sum[0];
        for(int s : sum){
            max = Math.max(s,max);
        }
        return sum[nums.length - 1];
    }
    //滚动数组
    public int maxSubArray1(int[] nums){
        int max = nums[0];
        int sum = 0;
        for(int num : nums){
            sum = Math.max(num, sum + num);
            max = Math.max(sum, max);
        }
        return max;
    }
}