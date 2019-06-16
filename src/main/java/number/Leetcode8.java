package number;

/**
 * Created by chan
 * Date: 2019/6/15 16:20
 * Description: 字符串转换整数 (atoi)
 * 特殊条件判断
 */
public class Leetcode8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        String[] format = str.trim().split(" ");
        String input = format[0];
        String target = input;
        int result = 1;
        if (input.length() == 0) return 0;
        if (input.charAt(0) == '-' || input.charAt(0) == '+') {
            target = input.substring(1);
            result = input.charAt(0) == '-' ? -1 : 1;
        }
        if (target.length() == 0) return 0;
        int value = -1;
        int i = 0;
        while (i < target.length() && target.charAt(i) >= '0' && target.charAt(i) <= '9'){
            i++;
        }
        if (i == 0) return 0;
        target = target.substring(0, i);
        if (target.charAt(0) >= '0' && target.charAt(0) <= '9') {
            try {
                value = Integer.valueOf(target);
            } catch (NumberFormatException ex) {
                if (target.contains(".")) {
                    value = Float.valueOf(target).intValue();
                }
            } finally {
                if (value != -1) return result*value;
                int data = result == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                return data;
            }

        } else return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode8().myAtoi("42"));
//        Float fl = Float.valueOf("3.14159");
//        System.out.println(fl);
    }
}
