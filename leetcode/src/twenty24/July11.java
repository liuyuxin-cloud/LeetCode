package twenty24;

//最小覆盖子串

public class July11 {
}

class Solution7_11 {
    public String minWindow(String s, String t) {

        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        if (arrayS.length == 0 || arrayT.length == 0 || arrayS.length < arrayT.length) return "";

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        int left = 0, right = 0;
        int distance = 0;
        int begin = 0;
        int minL = s.length() + 1;

        for (char c: arrayT) {
            freqT[c]++;
        }

        while (right < arrayS.length) {
            char rightC = arrayS[right];

            if (freqT[rightC] == 0) { // 当前字符不在T中出现，窗口继续向右移动
                right++;
                continue;
            }

            if (freqS[rightC] < freqT[rightC]) { // 当前字符在T中出现，则匹配度加一
                distance++;
            }

            freqS[rightC]++;
            right++;

            while (distance == arrayT.length) { // 匹配度达标后，移动左窗口来寻找最小窗口

                char leftC = arrayS[left];

                if (right - left < minL) {
                    minL = right - left;
                    begin = left;
                }

                if (freqT[leftC] == 0) { // 左字符不包括则减小窗口
                    left++;
                    continue;
                }

                if (freqS[leftC] == freqT[leftC]) {
                    distance--;
                }
                left++;
                freqS[leftC]--;
            }
        }
        if (minL == arrayS.length + 1) return "";
        return s.substring(begin, begin + minL);
    }
}