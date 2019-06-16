package number;

/**
 * Created by chan
 * Date: 2019/6/16 13:07
 * Description:  2的幂，满足条件的数有什么特点？ x & (x - 1) == 0
 */
public class Leetcode231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode231().isPowerOfTwo(1));
        System.out.println(new Leetcode231().isPowerOfTwo(16));
        System.out.println(new Leetcode231().isPowerOfTwo(218));
    }
}
