package dfs;

import common.Solution;
import common.TreeNode;

import java.util.Stack;

public class SumOfLeftLeaves extends Solution {
    private static boolean isLeave(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;

        Stack<TreeNode> stack = new Stack<>();

        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (isLeave(node.left)) ans += node.left.val;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return ans;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        Integer[][] inputs = new Integer[][] {
                {3,9,20,null,null,15,7},
                {1}
        };

        for (Integer[] input : inputs) {
            System.out.println(solution.sumOfLeftLeaves(buildBinaryTree(input)));
        }
    }
}
