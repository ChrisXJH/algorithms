import java.util.Arrays;

public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int k = 0; k < coins.length; ++k)
            for (int i = coins[k]; i <= amount; ++i)
                dp[i] += dp[i - coins[k]];

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeTwo solution = new CoinChangeTwo();

        System.out.println(solution.change(5, new int[] {1, 2, 5}));
    }
}
