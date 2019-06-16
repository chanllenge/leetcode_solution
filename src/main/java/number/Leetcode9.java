package number;

/**
 * Created by chan
 * Date: 2019/6/15 17:17
 * Description: 回文数
 */
public class Leetcode9 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int mid = str.length();
        int length = str.length();
        int i;
        for (i = 0; i < mid; i++) {
            if (str.charAt(i) == str.charAt(length - i -1)) continue;
            else break;
        }
        return i == mid;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode9().isPalindrome(-121));
    }
}
