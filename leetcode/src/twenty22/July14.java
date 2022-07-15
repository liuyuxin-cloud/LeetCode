package twenty22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

class WordFilter2 {

    class TrieNode {
        List<Integer> list = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode prefix = new TrieNode();
    private TrieNode suffix = new TrieNode();

    public WordFilter2(String[] words){
        build(prefix, words, true);
        build(suffix, words, false);
    }

    public int f(String pref, String suff) {
        List<Integer> preList = query(prefix, pref, true);
        List<Integer> suffList = query(suffix, suff, false);
        int i = preList.size() - 1, j = suffList.size() - 1;
        while(i >= 0 && j >= 0) {
            int l1 = preList.get(i), l2 = suffList.get(j);
            if(l1 == l2) return l1;
            else if (l1 > l2) i--;
            else j--;
        }
        return -1;
    }

    private void build(TrieNode root, String[] words, boolean isPref) {
        for(int i = 0; i < words.length; i++) {
            TrieNode p = root;
            int len = words[i].length();
            for(int j = isPref ? 0 : len - 1; j >= 0&& j < len; j = isPref ? j + 1 : j - 1) {
                int cur = words[i].charAt(j) - 'a';
                if(p.children[cur] == null) p.children[cur] = new TrieNode();
                p = p.children[cur];
                p.list.add(i);
            }
        }
    }

    private List<Integer> query(TrieNode root, String s, boolean isPref) {
        TrieNode p = root;
        int len = s.length();
        for (int i = isPref ? 0 : len - 1; i >= 0 && i < len; i = isPref ? i + 1: i - 1) {
            int cur = s.charAt(i) - 'a';
            if(p.children[cur] == null) return new ArrayList<>();
            p = p.children[cur];
        }
        return p.list;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */