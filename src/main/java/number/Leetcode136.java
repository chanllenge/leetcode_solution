package number;

/**
 * Created by chan
 * Date: 2019/6/16 15:45
 * Description:只出现一次的数字
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int[] a = {2,2,1};
        int[] b = {4,1,2,1,2};
        System.out.println(new Leetcode136().singleNumber(a));
        System.out.println(new Leetcode136().singleNumber(b));
    }
}

