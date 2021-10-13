import java.util.Arrays;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。
 */

public class October12 {
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        Solution10_12 s = new Solution10_12();
        System.out.println(Arrays.toString(s.findWords(words)));
    }
}

class Solution10_12 {

    static String one = "qwertyuiopQWERTYUIOP";
    static String two = "asdfghjklASDFGHJKL";
    static String three = "zxcvbnmZXCVBNM";

    public String[] findWords(String[] words) {
        String[] ans = new String[words.length];
        int index = 0;
        for (String s : words) { //枚举所有字符串
            int base = 0; //记录字符串s中字符属于第几行，初始化为0
            boolean flag = true; //标记字符串s中所有字符是否属于同一字符
            for (int i = 0; i < s.length(); i++) {
                if (base == 0) base = f(s.charAt(i)); //初始化
                else {
                    if (f(s.charAt(i)) != base) { //如果不是同一行，则标记为false
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ans[index++] = s; //flag为true表示字符串s中所有字符属于同一字符
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

    public int f(char c) { //查找某字符c属于第几行
        if (one.indexOf(c) != -1) return 1;
        if (two.indexOf(c) != -1) return 2;
        if (three.indexOf(c) != -1) return 3;
        return -1;
    }
}