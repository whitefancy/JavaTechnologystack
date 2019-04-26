package leetcode.graph;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    Object val;
    List<TreeNode> children;
    public TreeNode(Object i) {
        val=i;
    }
    public void addChild(TreeNode node){
        if(children==null){
            children = new LinkedList<>();
        }
        children.add(node);
    }
}
