package twenty23;

public class March21_2 {
}
class Solution3_21_2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())   return false;
        int[] vb = new int[26];
        for (int i = 0; i < s.length(); i++) {
            vb[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            vb[t.charAt(i) - 'a']--;
        }
        for (int j : vb) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}