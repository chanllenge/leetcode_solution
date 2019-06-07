package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by chan
 * Date: 2019/6/7 10:59
 * Description: 有效的括号
 */
public class LeetcodeNo20 {

    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character) && !stack.isEmpty() &&
                    map.get(character) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String str = ")[";
        System.out.println(new LeetcodeNo20().isValid(str));
    }
}
