package twenty25;

//189. 轮转数组

import java.util.Arrays;

public class February23 {
    public static void main(String[] args) {
        Solution2_23 c = new Solution2_23();
        int[] n = new int[]{-1, -100, 3, 99};
        c.rotate2(n, 2);
    }
}

class Solution2_23 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, n);
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // 防止 k 大于 n
        int count = 0;

        // 遍历每个环
        for (int start = 0; count < n; start++) {
            int cur = start;
            int prv = nums[start];
            // 如果当前起始点已经被访问过，跳过
            //if (nums[cur] == nums[start] && count != 0) continue;

            do {
                int nxt = (cur + k) % n;
                int tmp = nums[nxt];
                nums[nxt] = prv;
                cur = nxt;
                prv = tmp;
                count++;
                System.out.println(Arrays.toString(nums));
            } while (cur != start); // 当前环完成后跳出

        }
    }


    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
