/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 */
public class December14_2 {
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
class Solution12_14_2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode preHead = new ListNode(-101, head);
        ListNode p = preHead;
        ListNode q = head;
        int temp = -101;
        while(q.next != null){
            if(q.val == q.next.val || q.val == temp){
                temp = q.val;
                p.next = q.next;
            }else {
                p = p.next;
            }
            q = q.next;
        }
        if(q.val == temp){
            p.next = null;
        }
        return preHead.next;
    }
}