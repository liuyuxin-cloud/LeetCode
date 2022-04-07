package twenty22;

public class April7 {
}
class Solution4_7 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while(left<right){
            if(nums[left] == val){
                nums[left] = nums[--right];
            }
            else{
                left++;
            }
        }
        return left;
    }
}