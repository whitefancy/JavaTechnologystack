package javacore;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2, 0};
        int[] A1 = {3, 4, -1, 1};
        int[] A2 = {7, 8, 9, 11, 12};
        int mi = Main.minN(A2);
        System.out.println(mi);
    }

    private static int minN(int[] A) {
        Queue queue = new PriorityQueue();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {

                queue.add(A[i]);
            }
        }
        int min = (Integer) queue.remove();
        for (int i = 1; i < A.length; i++) {
            if (i == min) {
                if (!queue.isEmpty()) {
                    min = (Integer) queue.remove();
                } else {
                    return i + 1;
                }
            } else if (i < min) {
                return i;
            } else if (i > min) {
                return i;
            }
        }
        return 1;
    }
}
