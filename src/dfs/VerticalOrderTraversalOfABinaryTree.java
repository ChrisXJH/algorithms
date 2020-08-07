// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

package dfs;

import common.Solution;
import common.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree extends Solution {
    private static class QueueItem {
        TreeNode node;
        int x;
        int y;

        public QueueItem(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<QueueItem> stack = new Stack<>();
        List<QueueItem> items = new ArrayList<>();

        stack.push(new QueueItem(root, 0, 0));

        while (!stack.isEmpty()) {
            QueueItem item = stack.pop();
            TreeNode node = item.node;
            int x = item.x;
            int y = item.y;

            items.add(item);

            if (node.left != null) stack.push(new QueueItem(node.left, x - 1, y + 1));
            if (node.right != null) stack.push(new QueueItem(node.right, x + 1, y + 1));
        }

        items.sort(new Comparator<QueueItem>() {
            @Override
            public int compare(QueueItem o1, QueueItem o2) {
                if (o1.x == o2.x && o1.y == o2.y) return o1.node.val - o2.node.val;
                if (o1.x == o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });

        Integer currX = null;
        List<Integer> column = null;

        for (QueueItem item : items) {
            if (currX == null || item.x != currX) {
                column = new ArrayList<>();
                ans.add(column);
                currX = item.x;
            }

            column.add(item.node.val);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "[3,9,20,null,null,15,7]",
                "[1,2,3,4,5,6,7]",
                "[0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]"
        };
        VerticalOrderTraversalOfABinaryTree solution = new VerticalOrderTraversalOfABinaryTree();

        for (String input : inputs) {
            TreeNode root = buildBinaryTree(input);
            List<List<Integer>> res = solution.verticalTraversal(root);
            System.out.println(res.toString());
        }
    }
}
