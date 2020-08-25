package dp;

import common.Solution;

import java.util.Arrays;

public class MinimumCostForTickets extends Solution {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int mincostTickets2(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; ++i) {
            int curr = i;
            int start = days[curr - 1];
            int basePrice = dp[i - 1];

            while (curr <= n && days[curr - 1] - start + 1 <= 30) {
                int diff = days[curr - 1] - start + 1;

                if (diff <= 1) {
                    dp[curr] = Math.min(basePrice + costs[0], dp[curr]);
                }
                if (diff <= 7) {
                    dp[curr] = Math.min(basePrice + costs[1], dp[curr]);
                }
                dp[curr] = Math.min(basePrice + costs[2], dp[curr]);

                ++curr;
            }
        }

        return dp[n];
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        int[] durations = new int[] {1, 7, 30};

        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; --i) {
            int start = days[i];
            int j = i;

            for (int k = 0; k < durations.length; ++k) {
                while (j < n && days[j] - start + 1 <= durations[k]) {
                    ++j;
                }
                dp[i] = Math.min(costs[k] + dp[j], dp[i]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[][][] inputs = new int[][][] {
                {{1,4,6,7,8,20}, {2,7,15}},
                {{1,2,3,4,5,6,7,8,9,10,30,31}, {2,7,15}}
        };
        MinimumCostForTickets solution = new MinimumCostForTickets();

        for (int[][] input : inputs) {
            System.out.println(solution.mincostTickets(input[0], input[1]));
        }
    }
}
