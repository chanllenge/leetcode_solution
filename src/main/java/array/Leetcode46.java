package array;

import list.Leetcode61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/22 11:53
 * Description:
 */
public class Leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (final int num : nums) {
            temp.add(num);
        }
        backTrace(0, temp, result, nums.length);
        return result;
    }

    private void backTrace(int first, List<Integer> temp, List<List<Integer>> result, int n) {
        if (first == n) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(temp, i, first);
            backTrace(first+1, temp, result, n);
            Collections.swap(temp, i, first);
        }
    }

    public static void main(String[] args) {
        int[] a= {1, 2, 3};
        System.out.println(new Leetcode46().permute(a));
    }
}
