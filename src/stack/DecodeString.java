package stack;

import common.Solution;

import java.util.Stack;

public class DecodeString extends Solution {
    private static class Frame {
        int k;
        String str;
        public Frame(int k, String str) {
            this.k = k;
            this.str = str;
        }
    }

    public String decodeString(String s) {
        Stack<Frame> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                k *= 10;
                k += (c - '0');
            }
            else if (c == '[') {
                stack.push(new Frame(k, sb.toString()));
                sb.setLength(0);
                k = 0;
            }
            else if (c == ']') {
                Frame frame = stack.pop();
                String str = sb.toString();
                k = frame.k;

                sb.replace(0, sb.length(), frame.str);
                while (k-- > 0) {
                    sb.append(str);
                }
                k = 0;
            }
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String[] inputs = { "3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz", "100[leetcode]", "3[a]2[bc]" };

        for (String input : inputs) {
            System.out.println(solution.decodeString(input));
        }
    }
}
