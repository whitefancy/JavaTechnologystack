package leetcode.DFSBFS;

/**
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class MaxTreeDepth {
    private int maxDepth = 0;

    public static void main(String[] args) {

    }

    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        DFS(root, 0);
        return maxDepth;
    }

    private void DFS(Node root, int i) {
        if (root == null) {
            return;
        }
        i++;
        if (i > maxDepth) {
            maxDepth = i;
        }
        for (Node child : root.children) {
            DFS(child, i);
        }
    }
}
