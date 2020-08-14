package greedy;

import common.Solution;

public class LongestPalindrome extends Solution {
    public int longestPalindrome(String s) {
        int[] count = new int['z' - 'A' + 1];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'A'];
        }

        int ans = 0;
        boolean single = false;
        for (char c = 'A'; c <= 'z'; ++c) {
            ans += 2 * (count[c - 'A'] / 2);
            single |= count[c - 'A'] % 2 == 1;
        }

        if (single) ++ans;

        return ans;
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"abccccdd"};
        LongestPalindrome solution = new LongestPalindrome();

        for (String input : inputs) {
            System.out.println(solution.longestPalindrome(input));
        }
    }
}
