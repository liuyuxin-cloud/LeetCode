package twenty24;

//比较含有退格符的字符

public class July6 {
}

class Solution7_6 {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    //重建
    public String build(String str) {
        StringBuilder ret = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
    //双指针
    public boolean backspaceCompare1(String s, String t) {
        int idxs = s.length() - 1, idxt = t.length() - 1;
        int skips = 0, skipt = 0;
        while (idxs >= 0 || idxt >= 0) {
            while (idxs >= 0) {
                if (s.charAt(idxs) == '#') {
                    skips++;
                    idxs--;
                } else if (skips > 0) {
                    skips--;
                    idxs--;
                } else {
                    break;
                }
            }
            while (idxt >= 0) {
                if (s.charAt(idxt) == '#') {
                    skipt++;
                    idxt--;
                } else if (skipt > 0) {
                    skipt--;
                    idxt--;
                } else {
                    break;
                }
            }
            if (idxs >= 0 && idxt >= 0) {
                if (s.charAt(idxs) != t.charAt(idxt)) return false;
            } else {
                if (idxs >= 0 || idxt >= 0) return false;
            }
            idxs--;
            idxt--;
        }
        return true;
    }
}
