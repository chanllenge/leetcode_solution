package array;

/**
 * Created by yuyuanhe
 * Date: 19-6-19 上午7:57
 * Description:
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = 0;
        int i = 0;
        while (i < prices.length) {
            while (prices[i] >= min && i + 1 <= prices.length - 1) i++;
            min = prices[i];
            while (i + 1 <= prices.length - 1 && prices[i + 1] > prices[i]) i++;
            if (prices[i] - min > max) max = prices[i] - min;
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int[] b = {7,6,4,3,1};
        int[] c = {8,1,4,2,7};

        System.out.println(new Leetcode121().maxProfit(a));
        System.out.println(new Leetcode121().maxProfit(b));
        System.out.println(new Leetcode121().maxProfit(c));
    }
}
