package twenty26;

import java.util.HashMap;

//138. 随机链表的复制
public class March16_1 {
}

class Solution3_16_1 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {

            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node clone = map.get(cur);
            clone.next = map.get(cur.next);
            clone.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}