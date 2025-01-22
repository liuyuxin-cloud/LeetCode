package twenty21;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
public class December16 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution12_16 {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        //将二叉搜索树通过中序遍历变成数组，则会得到一个递增数组
        treeToArray(root);
        int temp = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }

        return true;

    }

    void treeToArray(TreeNode root) {
        if (root == null) return;
        treeToArray(root.left);
        list.add(root.val);
        treeToArray(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}

