package array;

import list.Leetcode61;

/**
 * Created by chan
 * Date: 2019/6/22 10:32
 * Description:
 */
public class Leetcode88 {
    /**
     * 这种解法容易陷入死循环，怎么判断退出条件是个问题？？
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = 0, j = 0;
//        while (j < n) {
//            if (nums1[i] == 0 && i == m -1 + j ) break;
//            if (nums1[i] <= nums2[j]) {  //nums1值小于等于nums2，nums1直接向后移动即可
//                i++;
//            } else {  //需要将nums2[j]大于nums1[i],移动nums1元素，将nums2[j]插入
//                System.arraycopy(nums1, i, nums1, i+1, m+j-i);
//                nums1[i] = nums2[j];
//                j++;
//            }
//        }
//        if (j != n) {
//            System.arraycopy(nums2, j, nums1, i, n - j);
//        }
//    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;  //合并后
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        //nums1中的元素就不用copy了，如果是nums2中元素已经处理完，此步骤也无效
        System.arraycopy(nums2,0, nums1, 0, p2 + 1);
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2, 5, 6};
        new Leetcode88().merge(nums1, 3, nums2, 3);
        return;
    }
}
