package twenty23;

import java.util.HashMap;
import java.util.Map;

public class March21 {
}
class Solution3_21 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> note = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (note.containsKey(magazine.charAt(i))) {
                note.put(magazine.charAt(i), note.get(magazine.charAt(i))+1);
            } else {
                note.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (note.containsKey(ransomNote.charAt(i)) && note.get(ransomNote.charAt(i)) > 0) {
                note.put(ransomNote.charAt(i), note.get(ransomNote.charAt(i))-1);
            } else {
                return false;
            }
        }
        return true;
    }
}