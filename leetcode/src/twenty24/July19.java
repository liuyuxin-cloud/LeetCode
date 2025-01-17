package twenty24;

public class July19 {
}

class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        ListNode head = new ListNode(0);
    }

    public int get(int index) {
        if (index > size - 1) return -1;
        ListNode cur = head;
        while (index >= 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {
        int time = size;
        ListNode node = new ListNode(val);
        ListNode cur = head;
        while (time > 0) {
            cur = cur.next;
            time--;
        }
        cur.next = node;
        node.next = null;
    }

    public void addAtIndex(int index, int val) {
        if (index < size) {
            ListNode cur = head;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            ListNode pre = cur;
            cur = cur.next;
            ListNode node = new ListNode(val);
            node.next = cur;
            pre.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < size - 1) {
            ListNode cur = head;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            cur.next = cur.next.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
