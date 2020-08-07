package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumTwo {
    private int[] candidates;
    private int target;
    private Stack<Integer> stack;
    private List<List<Integer>> ans;

    private void dfs(int pos, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        if (sum > target || pos == candidates.length) return;


        int num = candidates[pos++];

        while (pos < candidates.length && candidates[pos] == num) ++pos;

        dfs(pos, sum);

        stack.push(num);
        dfs(pos, sum + num);
        stack.pop();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        stack = new Stack<>();
        ans = new ArrayList<>();

        dfs(0, 0);

        return ans;
    }

    public static void main(String[] args) {
        CombinationSumTwo solution = new CombinationSumTwo();
        int[][] arrays = new int[][] {
                {10,1,2,7,6,1,5},
                {2,5,2,1,2}
        };
        int[] targets = new int[] {8, 5};

        for (int i = 0; i < arrays.length; ++i) {
            int[] candidates = arrays[i];
            int target = targets[i];

            System.out.println(solution.combinationSum2(candidates, target).toString());
        }
    }
}
