import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**给定一个二叉树，返回它的 后序 遍历。*/

public class November19 {
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
class Solution11_19{
    List<Integer> mList = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            mList.add(root.val);
        }
        return mList;
    }
    //主要思想：
    //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
    //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
    //现在需要确定的是是否有右子树，或者右子树是否访问过
    public List<Integer> postorderTraversal1(TreeNode root) {
        if(root == null)    return mList;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //从栈中弹出的元素，左子树一定是访问完了的
            root = stack.pop();
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            //说明可以访问当前节点
            //如果右子树没有被访问，那么将当前节点压栈，访问右子树
            if(root.right == null || root.right == pre){
                mList.add(root.val);
                pre = root;
                root = null;
            }else{
                root = root.right;
            }
        }
        return mList;
    }
}