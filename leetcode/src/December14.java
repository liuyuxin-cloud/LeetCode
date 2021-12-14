/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class December14 {
    public static void main(String[] args){
        Solution12_14 s = new Solution12_14();
        s.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(3))));
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution12_14 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode preHead = new ListNode(-101, head);
        ListNode p = preHead;
        ListNode q = head;
        while(q.next != null){
            if(q.val == q.next.val){
                p.next = q.next;
            }else {
                p = p.next;
            }
            q = q.next;
        }
        return preHead;
    }
}