package twenty22;

import java.util.HashMap;
import java.util.Map;

public class July14 {
    public static void main(String[] args) {
        String[] words = {"apple"};
        String p = "b";
        String s = "e";
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f(p,s));
    }
}

class WordFilter { //暴力超时

    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String pref, String suff) {
        int index = -1;
        int leng = words.length;
        for (int i = 0; i < leng ; i++){
            String word = words[i];
            int j = 0;
            int len1 = pref.length();
            int len2 = suff.length();
            int len = word.length();
            while(j < len1){
                if(word.charAt(j) != pref.charAt(j)){
                    break;
                }
                j++;
            }
            if(j != len1) continue;
            j = len - len2;
            int k = 0;
            while(j < len) {
                if(word.charAt(j) != suff.charAt(k)){
                    break;
                }
                j++;k++;
            }
            if(j != len ) continue;
            index = i;
        }
        return index;
    }
}

class WordFilter1 {//哈希表
    Map<String, Integer> dictionary;

    public WordFilter1(String[] words) {
        dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                    dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return dictionary.getOrDefault(pref + "#" + suff, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */