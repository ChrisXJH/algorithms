//Given two words (beginWord and endWord), and a dictionary's word list,
// find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time.
//        Each transformed word must exist in the word list.
//        Note:
//
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Example 1:
//
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        Output: 5
//
//        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//        Example 2:
//
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        Output: 0
//
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

package bfs;

import java.util.*;

public class WordLadder {
    private static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        int ans = 0;

        q.add(beginWord);

        while (!q.isEmpty()) {
            int len = q.size();

            ++ans;

            while (len-- > 0) {
                String w = q.remove();

                if (w.equals(endWord)) return ans;

                for (int i = 0; i < w.length(); ++i) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (w.charAt(i) == c) continue;

                        String newW = w.substring(0, i) + c + w.substring(i + 1);

                        if (words.contains(newW)) q.add(newW);
                        words.remove(newW);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength1("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLength1("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
