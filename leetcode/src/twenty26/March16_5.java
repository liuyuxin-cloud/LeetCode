package twenty26;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class March16_5 {
}

class Solution3_16_5 {
    static class Pair {
        String cur;
        int num;
        public Pair(String cur, int num) {
            this.cur = cur;
            this.num = num;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        boolean[] visited = new boolean[wordList.size()];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair curWord = queue.poll();
            for (String str: wordList) {
                if (!visited[wordList.indexOf(str)] && isNext(curWord.cur, str)) {
                    if (str.equals(endWord)) {
                        return curWord.num + 1;
                    }
                    queue.offer(new Pair(str, curWord.num + 1));
                    visited[wordList.indexOf(str)] = true;
                }
            }
        }
        return 0;
    }

    private boolean isNext(String cur, String next) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}