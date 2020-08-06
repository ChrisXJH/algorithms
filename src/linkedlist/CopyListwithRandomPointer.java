// https://leetcode.com/problems/copy-list-with-random-pointer/

package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Map<Node, Node> visited;

    private Node doCopyRecursive(Node head) {
        if (head == null) return head;
        if (visited.containsKey(head)) return visited.get(head);

        Node newNode = new Node(head.val);

        visited.put(head, newNode);
        newNode.next = doCopyRecursive(head.next);
        newNode.random = doCopyRecursive(head.random);

        return newNode;
    }

    public Node copyRandomListRecursive(Node head) {
        visited = new HashMap<>();

        return doCopyRecursive(head);
    }

    public static void main(String[] args) {

    }
}
