package string;

/**
 * Created by chan
 * Date: 2019/6/16 15:06
 * Description:
 */
public class Leetcode557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        int i = 0;
        for (final String word : words) {
            sb.append(reverse(word));
            i++;
            if (i < words.length) sb.append(" ");
        }
        return sb.toString();
    }

    private String reverse(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) return str;
        int mid = str.length() / 2;
        char[] chars = str.toCharArray();
        for (int i = 0; i < mid; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(new Leetcode557().reverseWords(str));
    }
}
