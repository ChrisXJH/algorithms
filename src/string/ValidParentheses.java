// https://leetcode.com/problems/valid-parentheses/

package string;

import java.util.Stack;

public class ValidParentheses {
    private static boolean canMatch(char open, char close) {
        return open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']';
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && canMatch(stack.peek(), c)) stack.pop();
            else stack.add(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"()", "()[]{}", "(]", "([)]", "{[]}"};
        ValidParentheses solution = new ValidParentheses();

        for (String input : inputs) {
            System.out.println(solution.isValid(input));
        }
    }
}
