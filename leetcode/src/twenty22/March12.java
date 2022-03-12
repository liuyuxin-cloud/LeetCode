package twenty22;
//有序列表转平衡二叉树

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class March12 {
}
class Solution3_12 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedList(head, null);
    }

    public TreeNode sortedList(ListNode left, ListNode right){
        if(left == right) return null;
        ListNode mid = midNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedList(left, mid);
        root.right = sortedList(mid.next, right);
        return root;
    }

    public ListNode midNode(ListNode left, ListNode right){
        ListNode fast = left, slow = left;
        while(fast != right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class Solution3_12_1{
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head){
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }
    public int getLength(ListNode head){
        int ret = 0;
        while(head != null){
            ret++;
            head = head.next;
        }
        return ret;
    }
    public TreeNode buildTree(int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid-1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}