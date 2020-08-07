package common;

import java.util.*;

public class Solution {
    protected static ListNode buildList(String str) {
        String[] parts = str.split("->");
        ListNode result = new ListNode();
        ListNode curr = result;

        for (String part : parts) {
            curr.next = new ListNode(Integer.parseInt(part));
            curr = curr.next;
        }

        return result.next;
    }

    protected static void printList(ListNode head) {
        List<String> listNodes = new ArrayList<>();

        while (head != null) {
            listNodes.add(Integer.toString(head.val));
            head = head.next;
        }

        System.out.println(String.join("->", listNodes));
    }

    // [3,9,20,null,null,15,7]
    protected static TreeNode buildBinaryTree(String str) {
        str = str.substring(1, str.length() - 1);
        String[] parts = str.split("\\s*,\\s*");

        if (parts.length == 0 || "null".equals(parts[0])) return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int curr = 1;

        queue.add(root);

        while (!queue.isEmpty() && curr < parts.length) {
            TreeNode node = queue.remove();

            if (!"null".equals(parts[curr])) {
                node.left = new TreeNode(Integer.parseInt(parts[curr]));
                queue.add(node.left);
            }
            ++curr;

            if (!"null".equals(parts[curr])) {
                node.right = new TreeNode(Integer.parseInt(parts[curr]));
                queue.add(node.right);
            }
            ++curr;
        }

        return root;
    }

    protected static void printBinaryTree(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        List<String> levelNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            boolean allNulls = true;

            levelNodes.clear();

            while (len-- > 0) {
                TreeNode node = queue.remove();

                if (node == null) {
                    levelNodes.add("null");
                    continue;
                }

                allNulls = false;
                levelNodes.add(Integer.toString(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }

            if (!allNulls) nodes.addAll(levelNodes);
        }

        System.out.println("[" + String.join(",", nodes) + "]");
    }
}
