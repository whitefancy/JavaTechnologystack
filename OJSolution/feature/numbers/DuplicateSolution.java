package OJSolution.feature.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class DuplicateSolution {

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。
     * 如果数组中每个元素都不相同，则返回 false。
     * *bwftag  一般特性 重复数据 状态ok
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}
