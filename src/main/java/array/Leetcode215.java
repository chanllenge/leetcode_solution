package array;

/**
 * Created by chan
 * Date: 2019/6/20 7:46
 * Description:数组中的第K个最大元素
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int partition = partition(nums, low, high);
            if (partition == k - 1) return nums[partition];
            else if (partition > k - 1) {
                high = partition - 1;
            } else {
                low = partition + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int bound = nums[low];
        int index = low;
        low = low + 1;
        while (low <= high) {
            while (low < high && nums[low] >= bound) low++;
            while (nums[high] < bound) high--;
            if (low < high) {
                swap(nums, low, high);
                low++; high--;
            } else {
                break;
            }

        }
        swap(nums, index, high);  //记住初始index的位置
        return high;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(new Leetcode215().findKthLargest(a, k));

        int[] b = {3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println(new Leetcode215().findKthLargest(b, k));
    }
}
