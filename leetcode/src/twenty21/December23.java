package twenty21;

import java.util.HashMap;
import java.util.Map;

/**
 * 先序中序创建二叉树
 */
public class December23 {
}

class Solution12_23{
    private Map<Integer, Integer> indexMap ;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left > preorder_right)  return null;
        //前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        //递归地构造左子树，并连接到根节点
        //先序遍历中从【左边界+1, 左边界+size_left_subtree】个元素对应中序遍历中【左边界， 根节点位置-1】的元素
        root.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left+1+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
}