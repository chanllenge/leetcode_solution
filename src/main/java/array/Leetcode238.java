package array;

/**
 * Created by chan
 * Date: 2019/6/23 19:11
 * Description: 除自身以外数组的乘积
 */
public class Leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = k;
            k = k * nums[i];  //result中存储的是当前位置左边元素的乘积
        }

        k = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            result[i] *= k;  //再乘以该元素右边位置的乘积
            k *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        new Leetcode238().productExceptSelf(a);
    }
}
