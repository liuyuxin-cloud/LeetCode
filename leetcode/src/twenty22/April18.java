package twenty22;

public class April18 {
    public static void main(String[] args){
        int[] nums = {0,2,4,7,8,9,5,6,3};
        new Solution4_18().wiggleSort(nums);
    }
}
class Solution4_18{
    int n = -1;
    public void wiggleSort(int[] nums) {
        //找到中位数索引
        int midIndex = this.quickSelect(nums, 0, nums.length-1);
        //中位数
        int mid = nums[midIndex];
        n = nums.length;
        //三分法
        for(int i = 0, j = 0, k = nums.length - 1; j <= k;){
            if(nums[V(j)] > mid){
                swap(nums, V(j++), V(i++));
            }else if(nums[V(j)] < mid){
                swap(nums, V(j), V(k--));
            }else{
                j++;
            }
        }
    }

    public int V(int i){
        return (1+2*i) % (n | 1);
    }

    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int quickSelect(int[] nums, int left, int right){
        //快速选择
        int pivot = nums[left];
        int l = left;
        int r = right;
        while(l < r){
            while(l < r && nums[r] >= pivot){
                r--;
            }
            if(l < r){
                nums[l++] = nums[r];
            }
            while(l < r && nums[l] <= pivot){
                l++;
            }
            if(l < r){
                nums[r--] = nums[l];
            }
        }
        nums[l] = pivot;
        if(l == nums.length / 2){
            return l;
        }else if(l > nums.length / 2){
            return quickSelect(nums, left, l-1);
        }else{
            return quickSelect(nums, l+1, right);
        }
    }
}