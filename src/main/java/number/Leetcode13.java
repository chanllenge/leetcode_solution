package number;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chan
 * Date: 2019/6/23 20:47
 * Description:
 */
public class Leetcode13 {
    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);
        int res = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && romanMap.containsKey(s.substring(i, i+2))) {
                res += romanMap.get(s.substring(i, i+2));
                i += 2;
            } else {
                res += romanMap.get(s.substring(i, i+1));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        for (final String s : str) {
            System.out.println(new Leetcode13().romanToInt(s));
        }
    }
}
