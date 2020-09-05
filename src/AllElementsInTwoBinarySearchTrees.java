import common.Solution;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsInTwoBinarySearchTrees extends Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curr1 = root1;
        TreeNode curr2 = root2;

        while (curr1 != null || !stack1.isEmpty() || curr2 != null || !stack2.isEmpty()) {
            if (curr1 != null) {
                stack1.push(curr1);
                curr1 = curr1.left;
                continue;
            }
            if (curr2 != null) {
                stack2.push(curr2);
                curr2 = curr2.left;
                continue;
            }
            if (stack1.isEmpty()) {
                curr2 = stack2.pop();
                ans.add(curr2.val);
                curr2 = curr2.right;
            }
            else if (stack2.isEmpty()) {
                curr1 = stack1.pop();
                ans.add(curr1.val);
                curr1 = curr1.right;
            }
            else if (stack1.peek().val <= stack2.peek().val) {
                curr1 = stack1.pop();
                ans.add(curr1.val);
                curr1 = curr1.right;
            }
            else {
                curr2 = stack2.pop();
                ans.add(curr2.val);
                curr2 = curr2.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer[][][] inputs = new Integer[][][] {
                {{2,1,4}, {1,0,3}},
                {{0, -10, 10}, {5, 1, 7, 0, 2}},
                {{}, {5,1,7,0,2}},
                {{0,-10,10}, {}},
                {{1,null,8}, {8,1}}
        };
        AllElementsInTwoBinarySearchTrees solution = new AllElementsInTwoBinarySearchTrees();

        for (Integer[][] input : inputs) {
            System.out.println(solution.getAllElements(buildBinaryTree(input[0]), buildBinaryTree(input[1])).toString());
        }
    }
}
