package array;

/**
 * Created by chan
 * Date: 2019/6/15 19:07
 * Description:盛最多水的容器
 */
public class Leetcode11 {

    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i+1; j < height.length; j++) {
                //取高度低的
                int high = height[i] < height[j] ? height[i] : height[j];
                if (maxArea < high * (j - i)) {
                    maxArea = high * (j - i);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Leetcode11().maxArea(height));
    }
}
