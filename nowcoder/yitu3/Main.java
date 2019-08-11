package nowcoder.yitu3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            if (a < 3) {
                System.out.println(0);
            } else if (a < 6) {
                System.out.println(2);
            } else {
                int k = a / 3;
                System.out.println(2 * k * 2);
            }
        }
    }
}