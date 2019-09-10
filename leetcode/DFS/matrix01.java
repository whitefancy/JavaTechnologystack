package leetcode.DFS;

import java.util.*;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1
 */
public class matrix01 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public static void main(String[] args) {
        int[][] A = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] A1 = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] B = new matrix01().updateMatrix(A1);
        B = B;
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == Integer.MAX_VALUE) {
                    int[] pos = {i, j};
                    queue.offer(pos);
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            DFS(pos[0], pos[1], ans);
            if (ans[pos[0]][pos[1]] == Integer.MAX_VALUE) {
                queue.offer(pos);
            }
        }
        return ans;
    }

    private void DFS(int i, int j, int[][] ans) {
        if (ans[i][j] < Integer.MAX_VALUE) {
            return;
        }
        int distance = Integer.MAX_VALUE;
        for (int[] d : matrix01.dirs
        ) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (ans[x][y] == 0) {
                    distance = 1;
                    break;
                }
                if (ans[x][y] != Integer.MAX_VALUE) {
                    distance = Math.min(distance, ans[x][y] + 1);
                }
            }
        }
        if (distance != Integer.MAX_VALUE) {
            ans[i][j] = distance;
            for (int[] d : matrix01.dirs
            ) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    DFS(x, y, ans);
                }
            }
        }
    }
}
