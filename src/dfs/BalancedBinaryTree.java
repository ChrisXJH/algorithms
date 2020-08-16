package dfs;

import common.Solution;
import common.TreeNode;

public class BalancedBinaryTree extends Solution {
    private boolean ans;

    private int solve(TreeNode root) {
        if (root == null || !ans) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        if (Math.abs(left - right) > 1) ans = false;

        return 1 + Math.max(left , right);
    }

    public boolean isBalanced(TreeNode root) {
        ans = true;
        solve(root);

        return ans;
    }

    public static void main(String[] args) {
        Integer[][] inputs = new Integer[][] {
                {3,9,20,null,null,15,7},
                {1,2,2,3,3,null,null,4,4},
                {1,2,2,3,null,null,3,4,null,null,4}
        };
        BalancedBinaryTree solution = new BalancedBinaryTree();

        for (Integer[] input : inputs) {
            System.out.println(solution.isBalanced(buildBinaryTree(input)));
        }
    }
}
