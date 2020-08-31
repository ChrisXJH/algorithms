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

    protected static List<List<Integer>> arrayToList2D(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> curr = new ArrayList<>();
            for (int num : row) curr.add(num);
            list.add(curr);
        }

        return list;
    }

    // [3,9,20,null,null,15,7]
    protected static TreeNode buildBinaryTree(String str) {
        str = str.substring(1, str.length() - 1);
        String[] parts = str.split("\\s*,\\s*");
        Integer[] nodes = new Integer[parts.length];

        for (int i = 0; i < parts.length; ++i) {
            if ("null".equals(parts[i])) continue;
            nodes[i] = Integer.valueOf(parts[i]);
        }

        return buildBinaryTree(nodes);
    }

    protected static TreeNode buildBinaryTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) return null;

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        int curr = 1;

        queue.add(root);

        while (!queue.isEmpty() && curr < nodes.length) {
            TreeNode node = queue.remove();

            if (nodes[curr] != null) {
                node.left = new TreeNode(nodes[curr]);
                queue.add(node.left);
            }

            if (++curr >= nodes.length) break;

            if (nodes[curr] != null) {
                node.right = new TreeNode(nodes[curr]);
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
