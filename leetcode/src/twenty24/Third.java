package twenty24;

import java.util.ArrayList;
import java.util.List;

public class Third {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> elem = new ArrayList<>();
        TreeNode t = root;
        makeList(t, elem);
        return t;
    }
    public void makeList(TreeNode root, List list) {
        if (root != null) {
            list.add(root.val);
            makeList(root.left, list);
            makeList(root.right, list);
        }
    }
}
