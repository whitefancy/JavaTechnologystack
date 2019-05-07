package leetcode.tree;

public class TreeBuilder {
    String[] nodes;
    int n;
    TreeNode root;
    public TreeNode buildByArray(String s){
        if(s.equals(""))return root;
        nodes = s.split(",");
        n =nodes.length;
        int val = Integer.valueOf(nodes[0]);
        root= new TreeNode(val);
        creatTree(0,root);
        return root;
    }
    private void creatTree(int i,TreeNode cur){
        int k =2*i+1;
        if(k<n&&!nodes[k].equals("null")){
            int val = Integer.valueOf(nodes[k]);
            TreeNode node = new TreeNode(val);
            cur.left=node;
            creatTree(k,node);
        }
        k++;
        if(k<n&&!nodes[k].equals("null")){
            int val = Integer.valueOf(nodes[k]);
            TreeNode node = new TreeNode(val);
            cur.right=node;
            creatTree(k,node);
        }
    }
}
