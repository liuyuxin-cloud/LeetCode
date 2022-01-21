package twenty22;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */

public class January21 {
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
class Solution1_21 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return mySortedArrayToBST(nums, 0, nums.length-1);
    }
    public TreeNode mySortedArrayToBST(int[] nums, int left, int right){

        if(left <= right){
            TreeNode root = new TreeNode();
            int mid = (left + right) / 2;
            root.val = nums[mid];
            root.left = mySortedArrayToBST(nums, left, mid - 1);
            root.right = mySortedArrayToBST(nums, mid + 1, right);
            return root;
        }
        return null;
    }
}