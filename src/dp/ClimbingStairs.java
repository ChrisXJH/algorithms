package dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[2];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; ++i) {
            dp[i % 2] = dp[(i - 2) % 2] + dp[(i - 1) % 2];
        }

        return dp[(n - 1) % 2];
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int[] inputs = new int[] {2, 3, 6, 10};

        for (int input : inputs) {
            System.out.println(solution.climbStairs(input));
        }
    }
}
