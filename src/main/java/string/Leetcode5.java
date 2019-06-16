package string;

/**
 * Created by chan
 * Date: 2019/6/15 14:34
 * Description: 最长回文子串
 */
public class Leetcode5 {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        if (s == null || s.length() == 1) return s;
        String maxString = "";
        for(int k = 0; k < s.length() - maxlen; k++) {
            for (int j = k + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(k,j))) {
                    if ((j-k) > maxlen) {
                        maxlen = j - k;
                        maxString = s.substring(k, j);
                    }
                }
            }
        }
        return maxString;
    }

    private boolean isPalindrome(String str) {
        int mid = str.length() / 2;
        int i;
        for (i = 0; i<mid; i++) {
            if (str.charAt(i) == str.charAt(str.length()-i-1)) continue;
            else break;
        }
        if (i == mid) return true;
        return false;
    }

    /**
     * 另有中心扩展和动态规划法
     * @param args
     */

    public static void main(String[] args) {
        String str = "ac";
        System.out.println(new Leetcode5().longestPalindrome(str));
    }
}
