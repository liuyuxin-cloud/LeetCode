/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 */
public class December20_2 {
}
class Solution12_20_2 {
    public void recoverTree(TreeNode root) {
        midOrder(root);
    }
    public void midOrder(TreeNode root){
        if(root != null){
            midOrder(root.left);
            midOrder(root.right);
        }
    }
}