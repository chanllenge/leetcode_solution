package string;

/**
 * Created by chan
 * Date: 2019/6/15 19:15
 * Description:最长公共前缀
 */
public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        while (i < strs[0].length()) {
            boolean common = true;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    common = false;
                    break;
                }
                if (strs[j].charAt(i) == ch) continue;
                else {
                    common = false;
                    break;
                }
            }
            if (common) stringBuilder.append(ch);
            else break;
            i++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower","","flight"};
        System.out.println(new Leetcode14().longestCommonPrefix(strings));
    }
}
