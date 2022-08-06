package twenty22;

public class SegmentTree<E> {
    private E[] tree; //线段树
    private E[] data; //原有数据
    private Merge<E> merger;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        tree = (E[]) new Object[arr.length * 4];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) throws IllegalAccessException {
        if(index < 0 || index > data.length) {
            throw new IllegalAccessException("Index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    //在treeIndex的位置创建表示区间【l，r】的线段树
    private void buildSegmentTree (int treeIndex, int l, int r) {
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = (l + r) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public interface Merge<E> {
        E merge (E a, E b);
    }

    public E query(int treeIndex, int l, int r, int ql, int qr) {
        if(l == ql && r == qr) {
            return tree[treeIndex];
        }
        int mid = (l + r) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(ql > mid) {
            return query(rightTreeIndex, mid + 1, r, ql, qr);
        }
        if(qr <= mid) {
            return query(leftTreeIndex, l, mid, ql, qr);
        }
        E leftResult = query(leftTreeIndex, l, mid, ql, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, qr);

        return merger.merge(leftResult,rightResult);
    }

    public void update(int index, E e) throws IllegalAccessException {
        if(index < 0 || index >= data.length) {
            throw new IllegalAccessException("Index is illegal");
        }
        data[index] = e;
        updateTree(0, 0, data.length - 1, index, e);
    }

    private void updateTree(int treeIndex, int l, int r, int index, E e) {
        if(l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = (l + r) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index > mid) {
            updateTree(rightTreeIndex, mid + 1, r, index, e);
        }else {
            updateTree(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
}
