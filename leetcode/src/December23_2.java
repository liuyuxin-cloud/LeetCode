import java.util.HashMap;
import java.util.Map;

/**
 * 中序后序创建二叉树
 */
public class December23_2 {
}
class Solution12_23_2 {
    private Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            index.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n-1, 0, n-1);
    }
    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if(postorder_left > postorder_right)    return null;
        int postorder_root = postorder_right;
        int inorder_root = index.get(postorder[postorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        TreeNode root = new TreeNode(postorder[postorder_root]);
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root-1, postorder_left, postorder_left+size_left_subtree-1);
        root.right = myBuildTree(inorder, postorder, inorder_root+1, inorder_right, postorder_left+size_left_subtree, postorder_right-1);
        return root;
    }
}
