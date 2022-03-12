package twenty22;
//前序后序创建二叉树

public class March12_2 {
}
class Solution12_2 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildNode(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode buildNode(int[] preorder,int start1, int end1, int[] postorder, int start2,int end2 ){
        if(start1>end1) return null;
        TreeNode root = new TreeNode(preorder[start1]);
        if(start1 == end1) return root;
        int nextHeadVal = preorder[start1+1];
        int index = 0;
        for(int i = start2;i<=end2;i++){
            if(postorder[i] == nextHeadVal){
                index = i;
                break;
            }
        }
        root.left = buildNode(preorder,start1+1,start1+1+index-start2,postorder,start2,index);
        root.right = buildNode(preorder,start1+1+index-start2+1,end1,postorder,index+1,end2-1);
        return root;
    }
}