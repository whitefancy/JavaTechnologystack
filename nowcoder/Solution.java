package nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    Set<Integer> flag = new HashSet<>();
    List<Node> nodes = new ArrayList<>();
    List<Node> nodes1 = new ArrayList<>();
    List<Node> neighbors;
    List<Node> neighbors1;
    Node root;

    public Node cloneGraph(Node node) {
		root = new Node();
		neighbors = new ArrayList<>();
		root.neighbors = neighbors;
		root.val = node.val;
		DFS_Map(node, root, 1);
		addRef(nodes, nodes1);
        return root;
    }

    void addRef(List<Node> nodes, List<Node> nodes1) {
        for (int i = 0; i < nodes.size(); i++) {
			neighbors = nodes.get(i).neighbors;
			neighbors1 = nodes1.get(i).neighbors;
            for (int j = neighbors1.size(); j < neighbors.size(); j++) {
                Node neighbor = neighbors.get(j);
                Integer id = neighbor.val;
                if (flag.contains(id)) {
                    Node neig = DFSFind(nodes1, id);
					neighbors1.add(neig);
                }
            }
        }
    }

    void DFS_Map(Node node, Node root, int type) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(node);
        stack1.push(root);

        while (!stack.empty()) {
            Node cur = stack.pop();
			flag.add(cur.val);
            Node ans = stack1.pop();
			nodes.add(cur);
			nodes1.add(ans);
			neighbors = cur.neighbors;
			neighbors1 = ans.neighbors;
            for (int i = neighbors1.size(); i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);
                Integer id = neighbor.val;
                if (flag.contains(id)) {
                    Node neig = DFSFind(nodes1, id);
					neighbors1.add(neig);
                } else {
                    stack.push(neighbor);
                    Node nei = new Node();
                    nei.val = id;
                    List<Node> neigs = new ArrayList<>();
                    nei.neighbors = neigs;
					neighbors1.add(nei);
                    stack1.push(nei);
                    break;
                }
            }
        }
    }

    Node DFSFind(List<Node> nodes1, int val) {
        for (int i = 0; i < nodes1.size(); i++) {
            if (nodes1.get(i).val == val) {
                return nodes1.get(i);
            }
        }
        return nodes1.get(0);
    }
}