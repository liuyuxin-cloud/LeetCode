package twenty21;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */

public class July24 {
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        Solution7_24 so = new Solution7_24();
        System.out.println(so.isPalindrome(s));
    }
}
class Solution7_24{
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                stringBuilder.append(s.charAt(i));
            }
        }
        int i = 0,j = stringBuilder.length()-1;
        String str = stringBuilder.toString();
        str = str.toLowerCase();
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--)){
                i--;
                j++;
                break;
            }
        }
        return i == j || i > j;
    }
}

//善于使用String类的API
class Solution7_24_2 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
