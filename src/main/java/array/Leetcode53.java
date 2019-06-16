package array;

import string.Leetcode5;

/**
 * Created by chan
 * Date: 2019/6/16 19:33
 * Description:最大子序和
 */
public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Leetcode53().maxSubArray(a));
    }
}
