package twenty25;


import java.util.LinkedList;
import java.util.Queue;

// 112. 路径总和
public class July6 {

}


class TreeNode {
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

class Solution7_6 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    boolean dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) return false; // 处理空节点

        sum += root.val; // 更新当前路径和

        // 如果是叶子节点，检查路径和是否匹配
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        // 递归检查左子树或右子树是否存在有效路径
        return dfs(root.left, targetSum, sum) || dfs(root.right, targetSum, sum);
    }

    public boolean hasPath(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            int temp = queVal.poll();
            if (node.left == null && node.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queNode.offer(node.left);
                queVal.offer(node.left.val + temp);
            }
            if (node.right != null)
                queNode.offer(node.right);
                queVal.offer(node.right.val + temp);
        }
        return false;
    }
}