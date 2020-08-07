// https://leetcode.com/problems/combination-sum/

package backtracking;

import common.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum extends Solution {
    private int target;
    private int[] candidates;
    private List<List<Integer>> ans;
    private Stack<Integer> stack;

    private void dfs(int pos, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        if (sum > target || pos == candidates.length) return;

        dfs(pos + 1, sum);

        stack.push(candidates[pos]);
        dfs(pos, sum + candidates[pos]);
        stack.pop();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        ans = new ArrayList<>();
        stack = new Stack<>();

        dfs(0, 0);

        return ans;
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[][] arrays = new int[][] {
                {2,3,6,7},
                {2,3,5}
        };
        int[] targets = new int[] {7, 8};

        for (int i = 0; i < arrays.length; ++i) {
            int[] candidates = arrays[i];
            int target = targets[i];

            System.out.println(solution.combinationSum(candidates, target).toString());
        }
    }
}
