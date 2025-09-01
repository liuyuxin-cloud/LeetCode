package twenty25;

import java.util.ArrayDeque;
import java.util.Deque;

//71. 简化路径
public class September1 {
}

class Solution9_1 {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String name: names) {
            if (name.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!name.equals(".") && !name.equals("")) {
                deque.offerLast(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}