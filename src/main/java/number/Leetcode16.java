package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/16 9:38
 * Description:最接近的三数之和
 */
public class Leetcode16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minClose = Integer.MAX_VALUE;
        int closeSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    int nowClose = Math.abs(sum - target);
                    if (minClose > nowClose) {
                        minClose = nowClose;
                        closeSum = sum;
                    }
                    if (0 == sum - target) {
                        return closeSum;
                    } else if (0 > sum - target) {
                        while (l < r && nums[l] == nums[l+1]) l++;
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return closeSum;
    }


    public static void main(String[] args) {
        int[] numbers = {0, 2,1, -3};
        int target = 1;
        System.out.println(new Leetcode16().threeSumClosest(numbers, target));

    }
}
