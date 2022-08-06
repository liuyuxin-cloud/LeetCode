package twenty22;

public class August6 {
}
class NumArray {

    int[] data;
    int[] tree;
    public NumArray(int[] nums) {
        data = new int[nums.length];
        tree = new int[4 * nums.length];
        for(int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        buildTree(0, 0, data.length - 1);
    }

    public void buildTree(int index, int left, int right) {
        if(left == right) {
            tree[index] = data[left];
            return;
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int mid = (left + right) / 2;
        buildTree(leftIndex, left, mid);
        buildTree(rightIndex, mid + 1, right);
        tree[index] = tree[leftIndex] + tree[rightIndex];
    }

    public void updateTree(int treeIndex, int val, int left, int right, int index) {
        if(left == right) {
            tree[treeIndex] = val;
        }
        int mid = (left + right) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        if(index <= mid) {
            updateTree(leftIndex, val, left, mid, index);
        }else {
            updateTree(rightIndex, val, mid + 1, right, index);
        }
        tree[treeIndex] = tree[leftIndex] + tree[rightIndex];
    }

    public void update(int index, int val) {
        data[index] = val;
        updateTree(0, val, 0, data.length - 1, index);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, data.length - 1, left, right);
    }

    public int query(int treeIndex, int l, int r, int ql, int qr) {
        if(l == ql && r == qr) {
            return tree[treeIndex];
        }
        int mid = (l + r) / 2;
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;

        if(ql > mid) {
            return query(rightTreeIndex, mid + 1, r, ql, qr);
        }
        if(qr <= mid) {
            return query(leftTreeIndex, l, mid, ql, qr);
        }
        int leftResult = query(leftTreeIndex, l, mid, ql, mid);
        int rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, qr);

        return leftResult + rightResult;
    }
}