package twenty26;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//433. 最小基因变化
public class March16_4 {
}

class Solution3_16_4 {
    static class Pair {
        String gene;
        int num;
        public Pair(String k, int v) {
            this.gene = k;
            this.num = v;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        boolean flag = false;
        for (String string : bank) {
            if (string.equals(endGene)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        boolean[] visited = new boolean[bank.length];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.gene.equals(endGene)) {
                return pair.num;
            }
            for (int i = 0; i < bank.length; i++) {
                if (!visited[i] && isChange(pair.gene, bank[i])) {
                    queue.offer(new Pair(bank[i], pair.num + 1));
                    visited[i] = true;
                }
            }
        }
        return -1;
    }

    private boolean isChange(String s1, String s2) {
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
            }
        }
        return num == 1;
    }
}
