package twenty23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class March23_1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        Solution3_23_1 s = new Solution3_23_1();
        s.reverseList(head);
    }
}
class Solution3_23_1 {
    public ListNode reverseList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(i, head);
            i++;
            head = head.next;
        }
        ListNode ans = new ListNode(-1);
        ListNode pre = ans;
        for (i = map.size()-1; i >= 0; i--) {
            pre.next = map.get(i);
            pre = pre.next;
        }
        pre.next = null;
        return ans.next;
    }
}