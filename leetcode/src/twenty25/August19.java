package twenty25;

//167. 两数之和 II - 输入有序数组

public class August19 {
}
class Solution8_19 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length-1;
        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        res[0] = left+1;
        res[1] = right+1;
        return res;
    }
}