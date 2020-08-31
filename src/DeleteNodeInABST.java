import common.Solution;
import common.TreeNode;

public class DeleteNodeInABST extends Solution {
    private static TreeNode removeNext(TreeNode node) {
        TreeNode curr = node.right;
        TreeNode prev = node;

        if (curr == null) return null;

        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }

        if (prev == node) {
            node.right = curr.right;
        }
        else {
            prev.left = curr.right;
            curr.right = null;
        }

        return curr;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            TreeNode tmp = curr;

            if (curr.val == key) {
                TreeNode next = removeNext(curr);

                if (next != null) {
                    next.left = curr.left;
                    next.right = curr.right;
                }
                else {
                    next = curr.left;
                }

                if (prev != null) {
                    boolean isLeft = prev.val > curr.val;
                    if (isLeft) prev.left = next;
                    else prev.right = next;
                }
                else {
                    root = next;
                }

                break;
            }
            else if (key > curr.val) {
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }

            prev = tmp;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[][] inputs = new Integer[][] {
                {5,3,6,2,4,null,7},
                {5,3,6,2,4,null,7},
                {2,1}
        };
        int[] keys = {3, 5, 2};
        DeleteNodeInABST solution = new DeleteNodeInABST();

        for (int i = 0; i < inputs.length; ++i) {
            printBinaryTree(solution.deleteNode(buildBinaryTree(inputs[i]), keys[i]));
        }
    }
}
