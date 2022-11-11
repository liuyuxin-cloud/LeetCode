package twenty22;

public class November10 {
    public static void main(String[] args) {
        String[] word1 = new String[2], word2 = new String[2];
        word1[0] = "ab";
        word1[1] = "c";
        word2[0] = "a";
        word2[1] = "bc";
        Solution11_10 s = new Solution11_10();
        s.arrayStringsAreEqual(word1, word2);
    }
}
class Solution11_10 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder(""), w2 = new StringBuilder("");
        for (String s : word1) {
            w1.append(s);
        }
        for (String s : word2) {
            w2.append(s);
        }
        System.out.println(w1);
        System.out.println(w2);
        String s1 = w1.toString();
        String s2 = w2.toString();
        return s1.equals(s2);
    }
}