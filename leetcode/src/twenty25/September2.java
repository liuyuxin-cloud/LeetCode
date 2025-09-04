package twenty25;

//155. 最小栈

import java.util.*;

public class September2 {
}

class MinStack {

    List<Integer> list = new ArrayList<>();
    int min;

    public MinStack() {

    }

    public void push(int val) {
        if (list.size() == 0) {
            min = val;
        }
        list.add(val);
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        if (list.size() == 0) {
            return;
        }
        int val = list.get(list.size() - 1);
        if (val == min) {
            min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                }
            }
        }
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack1 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack1() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStack2 {

    Integer min = null;
    Stack<Long> data = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack2() {

    }

    public void push(int x) {
        if (data.isEmpty()) {
            data.push(0L);
            min = x;
        } else {
            //如果x是最小的数，这里可能越界，所以用Long来保存
            data.push(Long.valueOf(x) - min);
            min = Math.min(x, min);
        }
    }

    public void pop() {
        Long diff = data.pop();
        if (diff >= 0) {
            //return min + diff;
        } else {
            int res = min;
            min = (int) (min - diff);
            //return res;
        }
    }

    public int top() {
        Long diff = data.peek();
        if (diff >= 0) {
            return (int) (min + diff);
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }
}