package twenty22;

import java.util.Locale;

public class November11 {
}
class Solution11_11 {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0,s.length() / 2);
        a = a.toLowerCase();
        String b = s.substring(s.length() / 2);
        b = b.toLowerCase();
        int anum = 0, bnum = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == 'a' || a.charAt(i) == 'e' || a.charAt(i) == 'i'
            || a.charAt(i) == 'o' || a.charAt(i) == 'u'){
                anum++;
            }
        }
        for(int i = 0; i < b.length(); i++) {
            if(b.charAt(i) == 'a' || b.charAt(i) == 'e' || b.charAt(i) == 'i'
                    || b.charAt(i) == 'o' || b.charAt(i) == 'u'){
                bnum++;
            }
        }
        return anum == bnum;
    }
}