// https://leetcode.com/problems/add-and-search-word-data-structure-design/

package design;

import java.util.*;

public class WordDictionary {
    private static class TrieNode {
        private static final int BASE = 'a';
        private final TrieNode[] children;
        private boolean isLeave;

        TrieNode() {
            children = new TrieNode[26];
        }

        public List<TrieNode> getChildren() {
            List<TrieNode> ans = new ArrayList<>();

            for (TrieNode child : children) {
                if (child != null) ans.add(child);
            }

            return ans;
        }

        public boolean hasNode(char c) {
            return children[c - BASE] != null;
        }

        public TrieNode getNode(char c) {
            return children[c - BASE];
        }

        public TrieNode insertNode(char c) {
            int key = c - BASE;

            if (children[key] == null) {
                children[key] = new TrieNode();
            }

            return children[key];
        }

        public boolean isLeave() {
            return isLeave;
        }

        public void setLeave(boolean leave) {
            isLeave = leave;
        }
    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        root.setLeave(true);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode nextNode = root;

        for (char c : word.toCharArray()) {
            nextNode = nextNode.insertNode(c);
        }

        nextNode.setLeave(true);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();

        queue.add(root);

        for (char c : word.toCharArray()) {
            int len = queue.size();

            while (len-- > 0) {
                TrieNode node = queue.remove();

                if (c == '.') {
                    queue.addAll(node.getChildren());
                }
                else if (node.hasNode(c)) {
                    queue.add(node.getNode(c));
                }
            }
        }

        while (!queue.isEmpty()) {
            if (queue.remove().isLeave()) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println(dictionary.search("pad")); // false
        System.out.println(dictionary.search("bad")); // true
        System.out.println(dictionary.search(".ad")); // true
        System.out.println(dictionary.search("b..")); // true
    }
}
