package OJSolution.unsolve;

import java.util.ArrayList;
import java.util.List;

class BinaryWatch {
    int[] hours = new int[4];
    int[] minutes = new int[6];
    int[] led1 = {8, 4, 2, 1};
    int[] led2 = {32, 16, 8, 4, 2, 1};

    public static void main(String[] args) {
        new BinaryWatch().readBinaryWatch(1);
    }

    /**
     * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
     * 8 4 2 1 32 16 8 4 2 1
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {

        if (num < 2) {
            return null;
        }
        List<String> list = new ArrayList<>();
        walk(num, 0, 0, list, 0, 0);
        return list;
    }

    void walk(int num, int ind1, int ind2, List<String> list, int count1, int count2) {
        stepA(num, ind1, ind2, list, count1, count2);
        stepB(num, ind1, ind2, list, count1, count2);
        stepC(num, ind1, ind2, list, count1, count2);
        stepD(num, ind1, ind2, list, count1, count2);
    }

    void stepA(int num, int ind1, int ind2, List<String> list, int count1, int count2) {
        hours[ind1] = led1[ind1];
        count1 += led1[ind1];
        num--;
        ind1++;
        travel(num, ind1, ind2, list, count1, count2);
    }

    void stepB(int num, int ind1, int ind2, List<String> list, int count1, int count2) {
        ind1++;
        travel(num, ind1, ind2, list, count1, count2);
    }

    void stepC(int num, int ind1, int ind2, List<String> list, int count1, int count2) {
        minutes[ind1] = led2[ind1];
        count2 += led2[ind1];
        num--;
        ind2++;
        travel(num, ind1, ind2, list, count1, count2);
    }

    void stepD(int num, int ind1, int ind2, List<String> list, int count1, int count2) {
        ind2++;
        travel(num, ind1, ind2, list, count1, count2);
    }

    void travel(int num, int ind1, int ind2, List<String> list, int count1, int count2) {
        if (count1 >= 24 || count2 >= 60) {
            return;
        }
        if (num == 0) {
            String s;
            int hour = 0;
            for (int i = 0; i < ind1; i++) {
                hour += hours[i];
            }
            if (hour < 10) {
                s = "0" + hour + ":";
            } else {
                s = hour + ":";
            }
            int minute = 0;
            for (int i = 0; i < ind2; i++) {
                minute += minutes[i];
            }
            if (hour < 10) {
                s = s + "0" + minute;
            } else {
                s = s + minute;
            }
            list.add(s);
            return;
        }
        walk(num, ind1, ind2, list, count1, count2);
    }
}