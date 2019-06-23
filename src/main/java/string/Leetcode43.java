package string;

import array.Leetcode46;

/**
 * Created by chan
 * Date: 2019/6/22 16:24
 * Description:
 */
public class Leetcode43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0 ; i--) {
            for (int j = len2 - 1; j >= 0 ; j--) {
                int a = num1.charAt(i) - 48, b = num2.charAt(j) - 48;
                result[i+j] += a * b;  //i+j位置可能已经有值
                if (result[i+j] >= 10 && (i+j) != 0) {   //此处最关键，为0的位置不用进位了
                    result[i+j-1] = result[i+j-1] + result[i+j] /10;   //i+j-1位置可能已经有值,这两行的前后顺序也很重要
                    result[i+j] = result[i+j] % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= len1 + len2 - 2; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "52", num2 = "60";
        System.out.println(new Leetcode43().multiply(num1, num2));
    }
}
