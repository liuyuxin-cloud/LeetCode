/**
 *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class December2 {
    public static void main(String[] args){
        Solution12_2 s = new Solution12_2();
        System.out.println(s.mergeTwoLists(new ListNode(-9,new ListNode(3)), new ListNode(5,new ListNode(7))));
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
class Solution12_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode p = new ListNode();
        p = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.val = l1.val;
                l1 = l1.next;
            }
            else {
                p.val = l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode();
            p = p.next;
        }
        while(l1 != null){
            p.val = l1.val;
            l1 = l1.next;
            if(l1 != null){
                p.next = new ListNode();
                p = p.next;
            }
        }
        while(l2 != null){
            p.val = l2.val;
            l2 = l2.next;
            if(l2 != null){
                p.next = new ListNode();
                p = p.next;
            }
        }
        return ans;
    }
}