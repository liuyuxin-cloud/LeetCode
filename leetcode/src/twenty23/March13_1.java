package twenty23;

public class March13_1{
}
class Solution3_13_1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n - 1;
        m--;n--;
        while(m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;i--;
            } else {
                nums1[i] = nums2[n];
                n--;i--;
            }
        }
        while (m >= 0) {
            nums1[i--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }
    }
}