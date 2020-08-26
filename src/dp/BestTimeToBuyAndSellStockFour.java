package dp;

import common.Solution;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockFour extends Solution {
    private static final int INF = Integer.MAX_VALUE / 2;

    private static int greedyMaxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int ans = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            buy = Math.min(prices[i], buy);
            if (buy < prices[i]) {
                ans += prices[i] - buy;
                buy = prices[i];
            }
        }

        return ans;
    }

    public int maxProfit(int K, int[] prices) {
        int n = prices.length;

        if (n < 2 * K) return greedyMaxProfit(prices);

        int[][] hold = new int[n + 1][K + 1];
        int[][] sold = new int[n + 1][K + 1];

        Arrays.fill(hold[0], -INF);

        for (int i = 1; i <= n; ++i) {
            int price = prices[i - 1];

            for (int k = 1; k <= K; ++k) {
                hold[i][k] = Math.max(hold[i - 1][k], sold[i - 1][k - 1] - price);
                sold[i][k] = Math.max(sold[i - 1][k], hold[i - 1][k] + price);
            }
        }

        return sold[n][K];
    }

    public static void main(String[] args) {
        int[][] prices = new int[][] {
                {2,4,1},
                {3,2,6,5,0,3}
        };
        int[] ks = new int[] {2, 2};

        BestTimeToBuyAndSellStockFour solution = new BestTimeToBuyAndSellStockFour();

        for (int i = 0; i < prices.length; ++i) {
            System.out.println(solution.maxProfit(ks[i], prices[i]));
        }
    }
}
