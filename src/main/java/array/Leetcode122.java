package array;

/**
 * Created by yuyuanhe
 * Date: 19-6-19 上午7:45
 * Description:买卖股票的最佳时机 II
 */
public class Leetcode122 {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(new Leetcode122().maxProfit(a));
    }
}
