package string;

/**
 * Created by chan
 * Date: 2019/6/22 16:45
 * Description:
 */
public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0")) return num2;
        if (num2.equals("0")) return num1;

        int len1 = num1.length(), len2 = num2.length();
        if (len1 < len2) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //短的字符串左侧补齐0,始终补num2
        if (len1 != len2) {
            int offset = (len1 - len2) > 0 ? len1 - len2 : len2 - len1;
            StringBuilder sb = new StringBuilder();
            while (offset > 0) {
                sb.append("0");
                offset--;
            }
            num2 = sb.toString() + num2;
        }
        int[] result = new int[len1 + len2];
        int i = Math.max(len1, len2) - 1;
        int len = i;
        while (i >= 0) {
            int a = num1.charAt(i) - 48, b = num2.charAt(i) - 48;
            result[i] += a + b;
            if (result[i] >= 10 && i != 0) {
                result[i-1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
            i--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i <= len; i++) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str1 = "99", str2 = "9";
        System.out.println(new Leetcode415().addStrings(str1, str2));
    }

}
