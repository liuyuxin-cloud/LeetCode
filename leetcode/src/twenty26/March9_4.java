package twenty26;

//530. 二叉搜索树的最小绝对差
public class March9_4 {
}

class Solution9_4 {
    int pre = -1;
    int dif = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return dif;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            dif = Math.min(dif, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
