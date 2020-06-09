// https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int ans = 0;

        for (int i = 1; i <= nums.length; ++i) {
            dp[i] = 1;
            for (int j = 1; j < i; ++j) {
                if (nums[j - 1] >= nums[i - 1]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}
