package twenty25;

//超过阈值的最少操作数 II

import java.util.Arrays;
import java.util.PriorityQueue;

public class January15 {
}

class Solution1_15 {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num: nums) {
            pq.offer(num);
        }
        while (pq.peek() < k) {
            long x =  pq.poll(), y = pq.poll();
            pq.offer(x+x+y);
            res++;
        }
        return res;
    }
}