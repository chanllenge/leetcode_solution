package string;

/**
 * Created by chan
 * Date: 2019/6/16 15:00
 * Description:
 */
public class Leetcode344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) return;
        int mid = s.length / 2;
        for (int i = 0; i < mid; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return;
    }

    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};
        new Leetcode344().reverseString(chars);
        return;
    }
}
