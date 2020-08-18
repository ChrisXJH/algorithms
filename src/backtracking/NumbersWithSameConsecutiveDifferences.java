package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    private static void dfs(int num, int n, int k, List<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }

        int digit = num % 10;

        for (int i = 0; i <= 9; ++i) {
            if (Math.abs(digit - i) == k) dfs(num * 10 + i, n - 1, k, result);
        }
    }

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = new ArrayList<>();

        if (N == 1) result.add(0);

        for (int i = 1; i <= 9; ++i) {
            dfs(i, N - 1, K, result);
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); ++i) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][] {
                {3, 7},
                {2, 1},
                {1, 0}
        };
        NumbersWithSameConsecutiveDifferences solution = new NumbersWithSameConsecutiveDifferences();

        for (int[] input : inputs) {
            System.out.println(Arrays.toString(solution.numsSameConsecDiff(input[0], input[1])));
        }
    }
}
