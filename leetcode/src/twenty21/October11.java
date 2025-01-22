package twenty21;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */

public class October11 {
    public static void main(String[] args){
        Solution10_11 s = new Solution10_11();
        System.out.println(s.lengthOfLastWord("a"));
    }

}
class Solution10_11 {
    public int lengthOfLastWord(String s) {
        int i = 0, j = 0;
        i = s.length()-1;
        while(true){
            if(s.charAt(i) == ' ')   i--;
            else break;
        }
        j = i;
        while(true){
            if(j >=0 && (s.charAt(j) >= 'a' && s.charAt(j) <= 'z' || s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'))    j--;
            else break;
        }
        return i - j;
    }
}