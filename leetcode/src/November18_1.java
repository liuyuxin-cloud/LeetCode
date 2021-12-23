import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**给定一个二叉树的根节点 root ，返回它的 中序 遍历。*/
public class November18_1 {
}
class Solution11_18_1 {
    List<Integer> mList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            mList.add(root.val);
            inorderTraversal(root.right);
        }
        return mList;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null)    return mList;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            mList.add(root.val);
            root = root.right;
        }
        return mList;
    }
}