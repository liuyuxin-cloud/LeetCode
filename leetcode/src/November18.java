import java.util.ArrayList;
import java.util.List;

/**给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
*/
public class November18 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        Solution11_18 s = new Solution11_18();
        List<Integer> mList = s.preorderTraversal(root);
        System.out.println(mList);
    }
}

// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution11_18 {
    List<Integer> mList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            mList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return mList;
    }
}