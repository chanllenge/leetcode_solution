package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/21 22:27
 * Description:
 */
public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrace(nums, 0, result, temp);
        return result;
    }

    private void backTrace(int[] nums, int begin, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrace(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Leetcode78().subsets(nums));
    }
}
