import java.util.ArrayList;
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
}