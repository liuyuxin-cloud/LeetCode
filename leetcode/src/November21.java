/**给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点*/

public class November21 {
}
class Solution11_21 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int point1 = 0, point2 = 0;
//        TreeNode root = new TreeNode(3);
//        for(int i = 1; i < inorder.length; i++){
//            if(inorder[i] == preorder[point1]){
//                point2 = i;
//                break;
//            }
//        }
//        for(; point1 < point2; point1++){
//            root.left = new TreeNode(preorder[point1]);
//        }
//
//    }
    public void buildNode(TreeNode root, int[] preorder, int index, int end){
        root.left = new TreeNode(preorder[index]);
        if(index < end){
            buildNode(root.left, preorder, index++, end);
        }
        root.right = new TreeNode(preorder[index++]);
    }
}