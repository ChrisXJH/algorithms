package bfs;

import common.Solution;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree extends Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            ++count;

            while (len-- > 0) {
                TreeNode node = queue.remove();

                if (node.left == null && node.right == null) return count;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Integer[][] inputs = new Integer[][] {
                {3,9,20,null,null,15,7},
                {},
                {2}
        };
        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();

        for (Integer[] input : inputs) {
            System.out.println(solution.minDepth(buildBinaryTree(input)));
        }
    }
}
