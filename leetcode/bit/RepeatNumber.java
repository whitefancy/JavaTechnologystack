package leetcode.bit;

public class RepeatNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(n ^= 0);
        System.out.println(n ^= n);
        int[] A = new int[]{5, 6, 4, 7, 8, 4};
        n = new RepeatNumber().singleNumber(A);
        System.out.println(n);
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 异或运算^=
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum ^= nums[i];//数字跟自己异或等于0
            // 数字跟0异或等于其本身
            if (sum == 0) {
                return nums[i];
            }
        }
        return sum;
    }
}
