import com.sun.source.tree.Tree;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class December15_2 {
    public static void main(String[] args){
        var s = new Solution12_15_2();
        List<List<Integer>> lists = s.levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))));
    }
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
class Solution12_15_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return null;
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = temp.remove(0);
                res.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}