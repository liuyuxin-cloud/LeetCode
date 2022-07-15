package twenty22;

public class TrieTree {

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) p.children[i] = new TrieNode();
            p = p.children[i];
        }
        p.val = true;
    }
    //递归
    public TrieNode insert(TrieNode node, String word, int index) {

        if (node == null) node = new TrieNode();

        if (index == word.length()) {
            node.val = true;
            return node;
        }
        int i = word.charAt(index) - 'a';
        node.children[i] = insert(node.children[i], word, index + 1);
        return node;
    }

    public boolean query1(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(p.children[i] == null) return false;
            p = p.children[i];
        }
        return p.val;
    }

    //递归
    public boolean query(TrieNode node, String word, int index) {

        if(node == null) return false;

        if(index == word.length()) return node.val;

        int i = word.charAt(index) - 'a';
        return query(node.children[i], word, index + 1);
    }
}

class TrieNode {
    boolean val;
    TrieNode[] children = new TrieNode[26];
}
