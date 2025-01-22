package twenty21;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */

public class December6 {
    public static void main(String[] args){
        Solution12_6 s = new Solution12_6();
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        s.reverseKGroup(head, 2);
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
class Solution12_6 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode start = dummyHead.next;
        ListNode end = dummyHead.next;
        ListNode neew = dummyHead.next;
        int flag = 0;
        for(int i = 0; i < k - 1; i++){
            end = end.next;
        }
        while(end != null){
            ListNode temp = end.next;
            ListNode res = reverseList(start, end, k);
            if(flag == 0){
                head = res;
                flag = 1;
            }
            neew = res;
            start.next = temp;
            start = temp;
            end = temp;
            neew = start;
            for(int i = 0; i < k - 1; i++){
                if(end == null){
                    break;
                }
                end = end.next;
            }
        }
        return neew;
    }

    public ListNode reverseList(ListNode start, ListNode end, int k) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode temp = end.next;
        while (curr != temp && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode t = prev;
        for(int i = 0; i < k-1; i++){
            t = t.next;
        }
        t.next = curr;
        return prev;
    }
}