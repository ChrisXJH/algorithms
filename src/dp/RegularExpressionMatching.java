// https://leetcode.com/problems/regular-expression-matching/

package dp;

public class RegularExpressionMatching {
    public boolean isMatch(String str, String pattern) {
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        boolean[][] dp = new boolean[s.length + 1][p.length + 1];

        dp[0][0] = true;

        for (int j = 1; j <= p.length; ++j) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length; ++i) {
            for (int j = 1; j <= p.length; ++j) {
                char sc = s[i - 1];
                char pc = p[j - 1];

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pc == '*') {
                    if (sc != p[j - 2] && p[j - 2] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length][p.length];
    }

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        String[][] inputs = new String[][] {
                {"aa", "a"},
                {"aa", "a*"},
                {"ab", ".b"},
                {"aab", "c*a*b"},
                {"mississippi", "mis*is*p*."},
                {"aaa", "ab*a"}
        };

        for (String[] input : inputs) {
            System.out.println(solution.isMatch(input[0], input[1]));
        }
    }
}
