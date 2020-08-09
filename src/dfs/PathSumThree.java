package dfs;

import common.Solution;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumThree extends Solution {
    private static int dfs(TreeNode root, int sum, int target, Map<Integer, Integer> prefixCount) {
        if (root == null) return 0;

        sum += root.val;

        int prefixes = prefixCount.getOrDefault(sum - target, 0);

        prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);

        int ans = prefixes + dfs(root.left, sum, target, prefixCount) +
                dfs(root.right, sum, target, prefixCount);

        prefixCount.put(sum, prefixCount.get(sum) - 1);

        return ans;
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        return dfs(root, 0, sum, prefixCount);
    }

    public static void main(String[] args) {
        String[] trees = new String[] {
                "[10,5,-3,3,2,null,11,3,-2,null,1]",
                "[10]",
                "[1]",
                "[1,-2,-3]"
        };
        int[] sums = new int[] {8, 10, 0, -1};
        PathSumThree solution = new PathSumThree();

        for (int i = 0; i < trees.length; ++i) {

            TreeNode root = buildBinaryTree(trees[i]);
            int sum = sums[i];

            System.out.println(solution.pathSum(root, sum));
        }
    }
}
