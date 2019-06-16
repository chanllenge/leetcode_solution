package array;

/**
 * Created by chan
 * Date: 2019/6/15 13:33
 * Description:  寻找两个有序数组的中位数
 */
public class Leetcode4 {
    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m>n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;

            int temp = m;
            m = n;
            n = temp;
        }

        int imin = 0, imax = m; //i range [0,m], include
        while (imin <= imax) {  //i may be m
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;

            if (i < imax && nums2[j-1] > nums1[i]) {   //i too small
                imin = imin + 1;
            } else if (i > imin && nums1[i-1] > nums2[j]) {  // i too big
                imax = imax - 1;
            } else { // perfect
                //找出左半部分合适值
                int maxleft = 0, minright = 0;
                if (i == 0) maxleft = nums2[j-1];
                else if (j == 0) maxleft = nums1[i-1];
                else maxleft = Math.max(nums1[i-1], nums2[j-1]);

                if ((m + n) % 2 == 1) return maxleft;   // total length odd, maxleft is target

                if (i == m) minright = nums2[j];
                else if (j == n) minright = nums1[i];
                else minright = Math.min(nums1[i], nums2[j]);

                return (maxleft + minright) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 4};
        System.out.println(new Leetcode4().findMedianSortedArrays(a, b));
    }
}
