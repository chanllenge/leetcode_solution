package array;

/**
 * Created by chan
 * Date: 2019/6/16 12:29
 * Description:删除排序数组中的重复项
 */
public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; ) {
            while ((i + 1 < nums.length) && nums[i+1] == nums[i]) i++;
            if (i + 1 == nums.length) break;
            nums[++index] = nums[++i];
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] num = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Leetcode26().removeDuplicates(num));
    }
}
