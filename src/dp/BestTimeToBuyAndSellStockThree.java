package dp;

import common.Solution;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockThree extends Solution {
    private static final int INF = Integer.MIN_VALUE / 3;

    public int maxProfit2(int[] prices) {
        int[] hold = new int[3];
        int[] sold = new int[3];

        Arrays.fill(hold, INF);
        Arrays.fill(sold, INF);

        for (int p : prices) {
            int oldSold1 = sold[1];

            sold[1] = Math.max(sold[1], hold[1] + p);
            sold[2] = Math.max(sold[2], hold[2] + p);
            hold[1] = Math.max(hold[1], -p);
            hold[2] = Math.max(hold[2], oldSold1 - p);
        }

        return Math.max(Math.max(sold[1], sold[2]), 0);
    }

    public int maxProfit(int[] prices) {
        int sold1 = 0;
        int hold1 = -INF;
        int sold2 = 0;
        int hold2 = -INF;

        for (int price : prices) {
            sold2 = Math.max(hold2 + price, sold2);
            hold2 = Math.max(sold1 - price, hold2);
            sold1 = Math.max(hold1 + price, sold1);
            hold1 = Math.max(-price, hold1);
        }

        return sold2;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][] {
                {3,3,5,0,0,3,1,4},
                {1,2,3,4,5},
                {7,6,4,3,1}
        };
        BestTimeToBuyAndSellStockThree solution = new BestTimeToBuyAndSellStockThree();

        for (int[] input : inputs) {
            System.out.println(solution.maxProfit(input));
        }
    }
}
