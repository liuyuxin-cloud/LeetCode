package twenty25;

//151. 反转字符串中的单词

import java.util.Arrays;
import java.util.List;

public class May1 {
    public static void main(String[] args) {
        Solution5_1 s = new Solution5_1();
        String ss = s.reverseWords("  hello world  ");
    }
}

class Solution5_1 {
    public String reverseWords(String s) {
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> list = Arrays.asList(s.split("\\s+"));
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            sb.append(" ").append(list.get(i));
        }
        return sb.toString();
    }
}