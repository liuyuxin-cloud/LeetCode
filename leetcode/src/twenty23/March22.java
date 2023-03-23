package twenty23;


import java.util.List;

public class March22 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode () {};
    ListNode (int val) {
        this.val = val;
        this.next = null;
    }
    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution3_22 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        ListNode p = new ListNode(0);
        p.next = head;
        fast.next = p.next;
        slow.next = p.next;
        int i = 0;
        while (fast.next != null) {
            fast = fast.next;
            i++;
            if (i % 2 == 0) {
                slow = slow.next;
            }
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}