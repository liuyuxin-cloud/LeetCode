package twenty21;

import java.util.Arrays;

public class July5 {
    public static void main(String args[]) {
        int[] a = {8,9,3,9};
        Solution7_5 s = new Solution7_5();

        System.out.println(Arrays.toString(s.plusOne(a)));
    }
}

class Solution7_5 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] temp = new int[len + 1];
        if (digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        }
        for (int i = len - 1; i >= 0; i--) {
            if ((digits[i] == 9 && i == len-1) || digits[i] == 10) {
                if (i == 0) {
                    temp[0] = 1;
                    for (int j = 1; j <= len - 1; j++) {
                        temp[j] = 0;
                    }
                    return temp;
                }
                digits[i] = 0;
                digits[i - 1]++;
            }

        }
        return digits;
    }
}
