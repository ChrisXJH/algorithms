// https://leetcode.com/problems/word-ladder-ii/

package bfs;

import common.Solution;

import java.util.*;

public class WordLadderTwo extends Solution  {
    private List<List<String>> ans;

    private static String replaceChar(String word, int i, char chr) {
        return word.substring(0, i) + chr + word.substring(i + 1);
    }

    private static Set<String> getNeighbours(String word, Set<String> wordDict) {
        Set<String> neighbours = new HashSet<>();

        for (int i = 0; i < word.length(); ++i) {
            for (int k = 0; k < 26; ++k) {
                String neighbour = replaceChar(word, i, (char) (k + 'a'));

                if (word.equals(neighbour) || !wordDict.contains(neighbour)) continue;
                neighbours.add(neighbour);
            }
        }

        return neighbours;
    }

    private void dfsFindPaths(String target, Map<String, Set<String>> adj, Deque<String> path, Set<String> seen, int k) {
        if (k == 0) return;

        String word = path.getLast();

        if (target.equals(word)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (!adj.containsKey(word)) return;

        for (String neighbour : adj.get(word)) {
            if (seen.contains(neighbour)) continue;

            path.addLast(neighbour);
            seen.add(neighbour);

            dfsFindPaths(target, adj, path, seen, k - 1);

            seen.remove(neighbour);
            path.removeLast();
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        Map<String, Set<String>> adj = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        boolean reached = false;
        int levels = 0;

        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int len = queue.size();

            ++levels;

            while (len-- > 0) {
                String word = queue.remove();

                if (word.equals(endWord)) {
                    reached = true;
                    continue;
                }

                Set<String> neighbours = getNeighbours(word, wordDict);

                adj.put(word, neighbours);

                for (String neighbour : neighbours) {
                    if (seen.contains(neighbour)) continue;

                    seen.add(neighbour);
                    queue.add(neighbour);
                }
            }

            if (reached) break;
        }

        Deque<String> path = new LinkedList<>();

        seen.clear();
        path.addLast(beginWord);
        seen.add(beginWord);
        dfsFindPaths(endWord, adj, path, seen, levels);

        return ans;
    }

    public static void main(String[] args) {
        WordLadderTwo solution = new WordLadderTwo();
        String[][] words = new String[][] {
                {"hit", "cog"},
                {"hit", "cog"}
        };
        String[][] wordLists = new String[][] {
                {"hot","dot","dog","lot","log","cog"},
                {"hot","dot","dog","lot","log"}
        };

        for (int i = 0; i < wordLists.length; ++i) {
            System.out.println(solution.findLadders(words[i][0], words[i][1],
                    Arrays.asList(wordLists[i])).toString());
        }
    }
}
