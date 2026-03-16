package twenty26;

import java.util.*;

//207. 课程表
public class March16_3 {
}

class Solution3_16_3 {
    List<List<Integer>> edges;
    int[] indeg;
    int[] res;
    int index;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        res = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;
            for (int v: edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return index == numCourses;
    }
}