package twenty26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//210. 课程表 II
public class March16_2 {
}
class Solution3_16_2 {
    List<List<Integer>> edges;
    int[] indeg;
    int[] res;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        if (index != numCourses) {
            return new int[0];
        }
        return res;
    }
}