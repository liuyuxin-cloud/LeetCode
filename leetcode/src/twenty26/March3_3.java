package twenty26;

//211. 添加与搜索单词 - 数据结构设计

public class March3_3 {
}

class WordDictionary {

    private WordDictionary[] items;
    boolean isEnd;
    public WordDictionary() {
        items = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.items[word.charAt(i) - 'a'] == null) {
                node.items[word.charAt(i) - 'a'] = new WordDictionary();
            }
            node = node.items[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(this, word, 0);
    }

    public boolean search(WordDictionary node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.items[i] != null) {
                    if (search(node.items[i], word, index + 1)) {
                        return true;
                    }
                }
            }
        } else {
            if (node.items[word.charAt(index) - 'a'] != null) {
                return search(node.items[word.charAt(index) - 'a'], word, index + 1);
            }
        }
        return false;
    }
}