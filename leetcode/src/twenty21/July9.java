package twenty21;

public class July9 {
    public static void main(String[] args){
        Solution7_9 s = new Solution7_9();
        int[] ans = new int[2];
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        ans = s.twoSum(nums,target);
        System.out.println(ans);
    }
}
class Solution7_9 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            for (int j = i ; j < len ; j++){
                if(nums[i] + nums[j] == target){
                    int[] answer = new int[2];
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return null;
    }
}
