package dp;

import common.Solution;

import java.util.Arrays;

public class PalindromePartitioningTwo extends Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n + 1][n + 1];
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i < n; ++i) {
            isPalindrome[i][i] = true;
            isPalindrome[i][i + 1] = true;
        }

        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                int j = i + k;
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j - 1);
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (!isPalindrome[j][i + 1]) continue;
                if (j == 0) dp[i] = 0;
                else dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningTwo solution = new PalindromePartitioningTwo();
        String[] inputs = new String[] {
                "aab",
                "abaabba"
        };

        for (String input : inputs) {
            System.out.println(solution.minCut(input));
        }
    }
}
