package twenty25;

//117. 填充每个节点的下一个右侧节点指针 II

import java.util.Deque;
import java.util.LinkedList;

public class September9 {
}


// Definition for a Node.
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution9_9 {
    public Node1 connect(Node1 root) {
        if (root == null) {
            return root;
        }
        Deque<Node1> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node1 n = q.poll();
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
                if (i == len - 1) {
                    n.next = null;
                    continue;
                }
                n.next = q.peek();
            }
        }
        return root;
    }
}

