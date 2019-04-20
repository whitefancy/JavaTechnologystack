package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class PossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        TreeNode root =new TreeNode(0);
        List<TreeNode> list = new LinkedList<>();
        if(N%2==0)return list;
        int i = 1;
        while (i<N){
            LinkedList<TreeNode> queue= new LinkedList<>();
            queue.add(root);
            int n = queue.size();
            while (n>0){
                TreeNode cur = queue.poll();

            }
        }
        return list;
    }

}
