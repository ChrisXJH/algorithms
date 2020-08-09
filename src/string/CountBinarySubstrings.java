// https://leetcode.com/problems/count-binary-substrings/

package string;

import common.Solution;

public class CountBinarySubstrings extends Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int last = 0;
        char prev = s.charAt(0);
        int start = 0;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != prev) {
                int count = i - start;
                ans += Math.min(last, count);
                start = i;
                prev = s.charAt(i);
                last = count;
            }
        }

        ans += Math.min(s.length() - start, last);

        return ans;
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "00110011",
                "10101"
        };
        CountBinarySubstrings solution = new CountBinarySubstrings();

        for (String input : inputs) {
            System.out.println(solution.countBinarySubstrings(input));
        }
    }
}
