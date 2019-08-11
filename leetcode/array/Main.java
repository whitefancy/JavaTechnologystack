package leetcode.array;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 1, 1};
        MajorityChecker majorityChecker = new MajorityChecker(arr);
        System.out.println(majorityChecker.query(0, 5, 4)); // 返回 1
        System.out.println(majorityChecker.query(0, 3, 3)); // 返回 -1
        System.out.println(majorityChecker.query(2, 3, 2)); // 返回 2
    }
}
