package twenty26;

//4. 寻找两个正序数组的中位数

public class February10_2 {
}

class Solution2_10_2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int total = len1 + len2;
        if (total % 2 == 1) {
            return getKthElement(nums1, nums2, total / 2 + 1);
        }
        return (getKthElement(nums1, nums2, total / 2) + getKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) return nums2[index2 + k - 1];
            if (index2 == len2) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);
            int h = k / 2;
            int newIndex1 = Math.min(index1 + h, len1) - 1;
            int newIndex2 = Math.min(index2 + h, len2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }
            else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}