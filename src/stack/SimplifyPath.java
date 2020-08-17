package stack;

import common.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath extends Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> deque = new LinkedList<>();

        for (String part : parts) {
            if (".".equals(part)) continue;
            if ("..".equals(part)) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
                continue;
            }
            if (!part.isBlank()) deque.addLast(part);
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append("/").append(deque.removeFirst());
        }

        if (sb.length() == 0) sb.append('/');

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/a/../../b/../c//.//", "/a//b////c/d//././/.."};
        SimplifyPath solution = new SimplifyPath();

        for (String input : inputs) {
            System.out.println(solution.simplifyPath(input));
        }
    }
}
