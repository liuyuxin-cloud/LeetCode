package twenty23;

public class March23 {
}
class Solution3_23 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode temp = prehead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return prehead.next;
    }
}