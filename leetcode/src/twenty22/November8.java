package twenty22;

import java.util.HashMap;
import java.util.Map;

public class November8 {
}
class Solution11_8 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        Map map = new HashMap();
        for(int i = 0; i < allowed.length(); i++) {
            map.put(allowed.charAt(i), 0);
        }
        int j;
        for(int i = 0; i < words.length; i++) {
            for(j = 0; j < words[i].length(); j++) {
                if(!map.containsKey(words[i].charAt(j))) {
                   break;
                }
            }
            if(j == words[i].length()) {
                res++;
            }
        }
        return res;
    }
}