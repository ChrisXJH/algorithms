package linkedlist;

import common.ListNode;
import common.Solution;

public class ReorderList extends Solution {
    private static ListNode split(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode ans = slow.next;
        slow.next = null;

        return ans;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode head2 = split(head);
        head2 = reverse(head2);

        ListNode curr = head;
        ListNode p2 = head2;

        while (p2 != null) {
            ListNode next = curr.next;
            curr.next = p2;
            p2 = p2.next;
            curr = curr.next;
            curr.next = next;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "1->2->3->4",
                "1->2->3->4->5"
        };
        ReorderList solution = new ReorderList();

        for (String input : inputs) {
            ListNode list = buildList(input);
            solution.reorderList(list);
            printList(list);
        }
    }
}
