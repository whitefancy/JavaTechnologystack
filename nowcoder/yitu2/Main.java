package nowcoder.yitu2;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            int n = chars.length;
            int ans = 1;
            int max = 0;
            Counter task = new Counter(chars, 0, n);
            Future<Integer> result = Main.pool.submit(task);
            if (max < ans) {
                max = ans;
            }
            if (max % 2 == 1) {
                max--;
            }
            System.out.print(max);
        }
    }
}

class Counter implements Callable<Integer> {
    List<Future<Integer>> results = new ArrayList<>();
    private int first;
    private int end;
    private char[] chars;

    Counter(char[] chars, int first, int end) {
        this.chars = chars;
        this.first = first;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int n = chars.length;
        int tc = 0;
        int yc = 0;
        for (int i = first; i < end; i++) {
            if (chars[i] == 'T') {
                tc++;
            } else {
                yc++;
            }
        }
        if (tc == yc) {
            return n;
        } else {
            Counter task = new Counter(chars, first + 1, end);
            Counter task1 = new Counter(chars, first, end - 1);
        }
        return 0;
    }
}