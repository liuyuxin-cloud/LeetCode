package twenty26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//133. 克隆图
public class March16 {
}

class Solution3_16 {
    private HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node ans = new Node(node.val, new ArrayList<>());
        map.put(node, ans);
        for (Node neighbor : node.neighbors) {
            ans.neighbors.add(cloneGraph(neighbor);
        }
        return ans;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}