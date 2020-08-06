// https://leetcode.com/problems/basic-calculator-ii/

package stack;

import java.util.Stack;

public class BasicCalculatorTwo {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder("+");

        for (char c : s.toCharArray()) {
            if (c != ' ') sb.append(c);
        }

        char[] S = sb.toString().toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length; ++i) {
            char c = S[i];

            int num = 0;

            for (; i + 1 < S.length && Character.isDigit(S[i + 1]); ++i) {
                num *= 10;
                num += S[i + 1] - '0';
            }

            if (c == '+') {
                stack.push(num);
            }
            else if (c == '-') {
                stack.push(-num);
            }
            else if (c == '*') {
                stack.push(stack.pop() * num);
            }
            else if (c == '/') {
                stack.push(stack.pop() / num);
            }
        }

        int ans = 0;

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        BasicCalculatorTwo calculator = new BasicCalculatorTwo();
        String[] inputs = new String[] {"3+2*2", " 3/2 ", " 3+5 / 2 "};

        for (String input : inputs) {
            System.out.println(calculator.calculate(input));
        }
    }
}
