package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class RunMainFunc {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Node> nei = new ArrayList<>();
        List<Node> nei1 = new ArrayList<>();
        Node node = new Node(1, nei);
        Node node1 = new Node(2, nei1);
        node.neighbors.add(node1);
        node1.neighbors.add(node);
        CloneGraph1 so = new CloneGraph1();
        Node out = so.cloneGraph(node);
        System.out.println(out.val);
    }

}
