import common.Solution;
import common.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTreeBFS extends Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                sb.append("null,");
            }
        }

        sb.setLength(sb.length() - 1);

        return "[" + sb.toString() + "]";
    }

    private static TreeNode parseNode(String str) {
        return "null".equals(str) ? null : new TreeNode(Integer.parseInt(str));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = parseNode(parts[0]);;
        int i = 1;

        if (root != null) queue.add(root);

        while (!queue.isEmpty() && i < parts.length) {
            TreeNode node = queue.remove();
            TreeNode left = parseNode(parts[i++]);
            TreeNode right = i < parts.length ? parseNode(parts[i++]) : null;

            if (left != null) {
                node.left = left;
                queue.add(left);
            }

            if (right != null) {
                node.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTreeBFS solution = new SerializeAndDeserializeBinaryTreeBFS();
        Integer[][] inputs = new Integer[][] {
                {1,2,3,null,null,4,5},
                {}
        };

        for (Integer[] input : inputs) {
            String serialized = solution.serialize(buildBinaryTree(input));
            System.out.println(serialized);
            TreeNode root = solution.deserialize(serialized);
            printBinaryTree(root);
        }
    }
}
