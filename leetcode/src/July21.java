public class July21 {
    public static void main(String[] args){
        Solution7_21 s = new Solution7_21();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}

class Solution7_21 {
    public String longestCommonPrefix(String[] strs) {
        int min = strs[0].length();
        int i,j;
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            if (min > str.length()) {
                min = str.length();
            }
        }
        for(i = 0 ; i < min ; i++){
            for(j = 0 ; j < strs.length ; j++){
                char temp = strs[0].charAt(i);
                if(strs[j].charAt(i) != temp){
                    break;
                }
            }
            if(j != strs.length){
                break;
            }
        }
        for(int k = 0 ; k < i ; k++){
            stringBuilder.append(strs[0].charAt(k));
        }
        return String.valueOf(stringBuilder);
    }
}