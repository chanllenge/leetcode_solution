package number;

/**
 * Created by chan
 * Date: 2019/6/15 16:03
 * Description:整数反转,int 取值范围(-2147483648 ~ 2147483647)
 * 转换不难，难得是特殊、边界条件的判断，在result*10之前进行判断
 */
public class Leetcode7 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int left = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && left > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && left < -8)) return 0;
            result = result * 10 + left;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode7().reverse(-2147483648));
    }
}
