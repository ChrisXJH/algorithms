package linkedlist;

import common.ListNode;
import common.Solution;

public class ReverseNodesInKGroup extends Solution {
    private static ListNode[] reverseFirstK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        int len = 0;

        while (curr != null) {
            curr = curr.next;
            ++len;
        }

        if (len < k) return new ListNode[] {head, null};

        curr = head;

        while (k-- > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[] {prev, curr};
    }

    // 1->2->3->4->5, k = 2
    // 2 -> 1, 4 -> 3, 5
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode();
        ListNode curr = ans;

        while (head != null) {
            ListNode[] result = reverseFirstK(head, k);
            curr.next = result[0];
            curr = head;
            head = result[1];
        }

        return ans.next;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        int[] ks = new int[] {1, 2, 3};

        for (int k : ks) {
            printList(solution.reverseKGroup(buildList("1->2->3->4->5"), k));
        }
    }
}
