package twenty21;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
public class Fourth {

    //最简单的先平方再排序
    class MySolution {
        public int[] sortedSquares(int[] nums) {
            int t;
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = nums[i] * nums[i];
            }

            //Array.sort(nums);
            for(int i = 0 ; i < nums.length - 1 ; i++){
                for(int j = 0 ; j < nums.length - 1 - i ; j++){
                    if(nums[j] > nums[j + 1]){
                        t = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = t;
                    }
                }
            }
            return nums;
        }
    }

    //双指针（想到这个思路但不会写应该下笔实践的）

    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int negative = -1;
            for (int i = 0; i < n; ++i) {
                if (nums[i] < 0) {
                    negative = i;
                } else {
                    break;
                }
            }

            int[] ans = new int[n];
            int index = 0, i = negative, j = negative + 1;
            while (i >= 0 || j < n) {
                if (i < 0) {
                    ans[index] = nums[j] * nums[j];
                    ++j;
                } else if (j == n) {
                    ans[index] = nums[i] * nums[i];
                    --i;
                } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                    ans[index] = nums[i] * nums[i];
                    --i;
                } else {
                    ans[index] = nums[j] * nums[j];
                    ++j;
                }
                ++index;
            }

            return ans;
        }
    }

    class Solution2{
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    ans[pos] = nums[i] * nums[i];
                    ++i;
                } else {
                    ans[pos] = nums[j] * nums[j];
                    --j;
                }
                --pos;
            }
            return ans;
        }
    }



}
