package twenty26;

//129. 求根节点到叶节点数字之和
public class March9 {
}

class Solution3_9 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int pre = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return pre;
        }else {
            return dfs(root.left, pre) + dfs(root.right, pre);
        }
    }
    private class TreeNode {
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