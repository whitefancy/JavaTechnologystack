package nowcoder;

import java.util.Scanner;

/**
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 请问该机器人能够达到多少个格子？
 * 一行三个正整数由空格分开，分别代表行数m，列数n，和坐标数位之和的阈值k，0 < m <= 100, 0 < n <= 100, 0 < k <= 20。
 */
public class ActivityRange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m, n, k;
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            boolean[][] map = new boolean[m][n];
            int count = 0;
            if (m == 0 || n == 0) {
                System.out.println(0);
                continue;
            }
            if (k == 0) {
                System.out.println(1);
                continue;
            }
            System.out.println(count);
        }
    }
}
