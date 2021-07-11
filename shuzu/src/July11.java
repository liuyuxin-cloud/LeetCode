import java.util.ArrayList;
import java.util.List;

public class July11 {
    public static void main(String[] args) {
        Solution7_11 s = new Solution7_11();
        List<String> ans = new ArrayList<>();
        int[] nums = new int[]{0,2,3,4,5,7,8,9};
        ans = s.summaryRanges(nums);
        System.out.println(ans);
    }
}

class Solution7_11 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}

