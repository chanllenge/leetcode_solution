package stack;

import java.util.Stack;

/**
 * Created by yuyuanhe
 * Date: 19-6-18 上午9:27
 * Description:
 */
public class Leetcode155 {

    private class MinStack {
        Stack<Integer> stack;
        Stack<Integer> stackMin;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int x) {
            stack.push(x);
            if (stackMin.isEmpty() || stackMin.peek() >= x) {
                stackMin.push(x);
            }
        }

        public void pop() {
            if (stackMin.peek().equals(stack.peek())) {
                stack.pop();
                stackMin.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }
    }
}
