package twenty25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 12. 整数转罗马数字
 */

public class April26_1 {
}

class Solution4_26_1 {
    public String intToRoman(int num) {
        Integer[] nums = new Integer[]{-1, -1, -1, -1};
        int count = 0;
        String ans = "";
        while (num != 0) {
            nums[count] = (num % 10);
            num /= 10;
            count++;
        }
        if (nums[0] != -1) {
            ans += "M".repeat(nums[0]);
        }
        if (nums[1] != -1) {
            if (nums[1] == 4) {
                ans += "CD";
            } else if (nums[1] == 9) {
                ans += "CM";
            } else if (nums[1] >= 5) {
                ans += "D";
                ans += "C".repeat(nums[1] - 5);
            } else {
                ans += "C".repeat(nums[1]);
            }
        }
        if (nums[2] != -1) {
            if (nums[2] == 4) {
                ans += "XL";
            } else if (nums[2] == 9) {
                ans += "XC";
            } else if (nums[2] >= 5) {
                ans += "L";
                ans += "X".repeat(nums[2] - 5);
            } else {
                ans += "X".repeat(nums[2]);
            }
        }
        if (nums[3] != -1) {
            if (nums[3] == 4) {
                ans += "IV";
            } else if (nums[3] == 9) {
                ans += "IX";
            } else if (nums[3] >= 5) {
                ans += "V";
                ans += "I".repeat(nums[3] - 5);
            } else
                ans += "I".repeat(nums[3]);
        }
        return ans;
    }
}