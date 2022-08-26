package twenty22;

import javax.management.ObjectName;

public class SegmentTree {
    private int[] tree; //线段树
    private int[] data; //原有数据
    private int[] lazy; //标记数组
    private Merge<Integer> merger;

    public SegmentTree(int[] arr) {
        data = new int[arr.length];
        tree = new int[arr.length * 4];
        lazy = new int[arr.length * 4];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        for(int i : lazy) {
            i = -1;
        }
        buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public int get(int index) throws IllegalAccessException {
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

    public int query(int treeIndex, int l, int r, int ql, int qr) {
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
        int leftResult = query(leftTreeIndex, l, mid, ql, mid);
        int rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, qr);

        return merger.merge(leftResult,rightResult);
    }

    public void update(int index, int e) throws IllegalAccessException {
        if(index < 0 || index >= data.length) {
            throw new IllegalAccessException("Index is illegal");
        }
        data[index] = e;
        updateTree(0, 0, data.length - 1, index, e);
    }

    private void updateTree(int treeIndex, int l, int r, int index, int e) {
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

    public void add(int ql, int qr, int num, int l, int r, int treeIndex) {
        if(ql <= l && r <= qr) {
            tree[treeIndex] += (r - l + 1) * num;
            lazy[treeIndex] += num;
            return;
        }
        int mid = (l + r) / 2;
        pushDown(l, r, treeIndex);
        if(ql <= mid) {
            add(ql, qr, num, l, mid, treeIndex * 2 + 1);
        }
        if(qr > mid) {
            add(ql, qr, num, mid + 1, r, treeIndex * 2 + 2);
        }
        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }

    public void pushDown(int l, int r, int treeIndex) {
        if(lazy[treeIndex] != -1) {
            int mid = (l + r) / 2;
            lazy[treeIndex * 2 + 1] = lazy[treeIndex];
            lazy[treeIndex * 2 + 2] = lazy[treeIndex];
            tree[treeIndex * 2 + 1] = (mid - l + 1) * lazy[treeIndex];
            tree[treeIndex * 2 + 2] = (r - mid) * lazy[treeIndex];
            lazy[treeIndex] = -1;
        }
    }
}
