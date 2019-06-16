package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chan
 * Date: 2019/6/16 16:03
 * Description:存在重复元素
 */
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        int[] b = {1,2,3,4};
        int[] c = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(new Leetcode217().containsDuplicate(a));
        System.out.println(new Leetcode217().containsDuplicate(b));
        System.out.println(new Leetcode217().containsDuplicate(c));
    }
}
