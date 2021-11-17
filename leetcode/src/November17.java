import java.util.List;

/**给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
*/
public class November17 {
    public static void main(String[] args){
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = new ListNode(n1);
        ListNode p = new ListNode();
        p.showList(head);
        Solution11_17 s = new Solution11_17();
        s.reverseList(head);
        p.showList(head);


    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(ListNode next){
        this.next = next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public void showList(ListNode head){
        ListNode node = head.next;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
class Solution11_17 {
    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode();
        ListNode q = new ListNode();
        p = head.next;
        q = head.next;
        p = q.next;
        q.next = null;
        while(p != null){
            q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
        return head;
    }

    //
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}