package array;

/**
 * Created by chan
 * Date: 2019/6/16 13:05
 * Description:搜索旋转排序数组
 * 二分查找旋转位置，找到位置后在左右部分分别再二分查找
 */
public class Leetcode33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0, high = nums.length - 1;
        int index = findRotateIndex(nums, low, high);
        if (nums[index] == target) return index;
        if (index == 0) {
            return binarySearch(nums, index, high, target);
        }
        if (target < nums[0]) {
            return binarySearch(nums, index, high, target);
        }
        return binarySearch(nums, 0, index, target);
    }

    private int findRotateIndex(int[] nums, int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] > nums[index+1]) {
                return index + 1;
            } else {
                if (nums[index] >= nums[left]) {  //有可能index就是left
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] a = {8,9,2,3,4};
        int target = 9;
        System.out.println(new Leetcode33().search(a, target));
        int[] b = {4,5,6,7,0,1,2};
        target = 3;
        System.out.println(new Leetcode33().search(b, target));
    }
}
