package leetcode.tree;

import java.util.*;

public class TreeBuilder {
    private String[] nodes;
    private int n;
    private TreeNode root;

    /**
     * @param s 3,1,4,null,null,2
     * @return
     */
    public TreeNode buildByArray(String s) {
        if (s.equals("")) return root;
        nodes = s.split(",");
        n = nodes.length;
        int val = Integer.valueOf(nodes[0]);
        root = new TreeNode(val);
        creatTree(0, root);
        return root;
    }

    private void creatTree(int i, TreeNode cur) {
        int k = 2 * i + 1;
        if (k < n && !nodes[k].equals("null")) {
            int val = Integer.valueOf(nodes[k]);
            TreeNode node = new TreeNode(val);
            cur.left = node;
            creatTree(k, node);
        }
        k++;
        if (k < n && !nodes[k].equals("null")) {
            int val = Integer.valueOf(nodes[k]);
            TreeNode node = new TreeNode(val);
            cur.right = node;
            creatTree(k, node);
        }
    }

    public String tree2Array(TreeNode root) {
        List<String> list = new ArrayList<>();
        int i = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return "[]";
        queue.offer(root);
        list.add(String.valueOf(root.val));
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();

            if (p.left != null) {
                list.add(String.valueOf(p.left.val));
                queue.offer(p.left);
            }
        }
        levelOrder(root, list);
        return Arrays.deepToString(list.toArray());
    }

    private void levelOrder(TreeNode root, List<String> list) {

    }
}
