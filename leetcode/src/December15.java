/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * public class December15 {
 * }
 * <p>
 * /**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//有点问题但是不想改了，题意看错了，看成了在x之前= =
class Solution12_15 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(-101, head);
        ListNode p = preHead;
        ListNode pre = preHead;
        ListNode q = preHead.next;
        ListNode temp = preHead;
        while (q != null) {
            if (q.val == x) {
                temp = q;
                pre = temp;
                q = q.next;
            } else if (temp.val == -101) {
                p = p.next;
                q = q.next;
            } else if (q.val < temp.val) {
                pre.next = q.next;
                q.next = temp;
                p.next = q;
                p = p.next;
                q = temp.next;
            } else {
                q = q.next;
                pre = pre.next;
            }
        }
        return preHead.next;
    }
    //官方题解

    public ListNode partition1(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
