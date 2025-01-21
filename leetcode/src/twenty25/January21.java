package twenty25;

import java.util.Stack;

public class January21 {
}

class Solution1_21 {
    public boolean isPalindrome(int x) {
        String str1 = String.valueOf(x);
        StringBuffer buffer = new StringBuffer();
        buffer.append(str1);
        return str1.equals(buffer.reverse().toString());
    }
}