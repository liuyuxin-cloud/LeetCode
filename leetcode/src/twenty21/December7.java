package twenty21;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */

public class December7 {
    public static void main(String[] args){
        Solution12_7 s = new Solution12_7();
        s.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);
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
class Solution12_7 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)    return head;
        ListNode newTail = head;
        ListNode tail = head;
        ListNode newHead = null;
        int len = 1;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        int temp = len > k ? k : (k % len);
        for(int i = 0; i < (len - temp) - 1; i++){
            newTail = newTail.next;
        }
        tail.next = head;
        newHead = newTail.next;
        newTail.next = null;
        System.out.println(temp);
        return newHead;

    }
}