package stack;

import common.Solution;

import java.util.Stack;

public class LongestValidParentheses extends Solution {
    private static boolean canMatch(String str, int lo, int hi) {
        return str.charAt(lo) == '(' && str.charAt(hi) == ')';
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for (int i = 0; i < s.length(); ++i) {
            if (stack.peek() != -1 && canMatch(s, stack.peek(), i)) {
                stack.pop();
                ans = Math.max(i - stack.peek(), ans);
            }
            else {
                stack.push(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        String[] inputs = new String[] {"(()", ")()())"};

        for (String input : inputs) {
            System.out.println(solution.longestValidParentheses(input));
        }
    }
}
