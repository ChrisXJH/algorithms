// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

package topologicalsort;

import common.Solution;

import java.util.*;

public class SortItemsByGroupsRespectingDependencies extends Solution {
    private static void buildGraph(int[] group, List<List<Integer>> beforeItems, Map<Integer, Set<Integer>> adj, int[] itemInDegree, int[] groupInDegree) {
        for (int v = 0; v < beforeItems.size(); ++v) {
            for (int u : beforeItems.get(v)) {
                if (group[u] != group[v]) ++groupInDegree[group[v]];
                if (!adj.containsKey(u)) adj.put(u, new HashSet<>());
                adj.get(u).add(v);
                ++itemInDegree[v];
            }
        }
    }

    private static Map<Integer, Set<Integer>> buildGroupMap(int[] group) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < group.length; ++i) {
            if (!map.containsKey(group[i])) map.put(group[i], new HashSet<>());
            map.get(group[i]).add(i);
        }

        return map;
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m;
                ++m;
            }
        }

        Map<Integer, Set<Integer>> groupMap = buildGroupMap(group);
        Map<Integer, Set<Integer>> itemAdj = new HashMap<>();
        int[] groupInDegree = new int[m];
        int[] itemInDegree = new int[n];

        buildGraph(group, beforeItems, itemAdj, itemInDegree, groupInDegree);

        Queue<Integer> groupQueue = new LinkedList<>();
        Queue<Integer> itemQueue = new LinkedList<>();
        int[] ans = new int[n];
        int curr = 0;

        for (int i = 0; i < m; ++i) {
            if (groupInDegree[i] == 0) groupQueue.add(i);
        }

        while (!groupQueue.isEmpty()) {
            int g = groupQueue.remove();

            if (!groupMap.containsKey(g)) continue;
            for (int i : groupMap.get(g)) {
                if (itemInDegree[i] == 0) itemQueue.add(i);
            }

            while (!itemQueue.isEmpty()) {
                int i = itemQueue.remove();

                ans[curr++] = i;

                if (!itemAdj.containsKey(i)) continue;
                for (int j : itemAdj.get(i)) {
                    if (--itemInDegree[j] == 0 && group[i] == group[j]) itemQueue.add(j);
                    if (--groupInDegree[group[j]] == 0 && group[i] != group[j]) groupQueue.add(group[j]);
                }
            }
        }

        if (curr != n) return new int[0];
        return ans;
    }

    public static void main(String[] args) {
        int[] ns = new int[] {8, 8, 5, 5};
        int[] ms = new int[] {2, 2, 5, 3};
        int[][] groups = new int[][] {
                {-1,-1,1,0,0,1,0,-1},
                {-1,-1,1,0,0,1,0,-1},
                {2,0,-1,3,0},
                {0,0,2,1,0}
        };
        int[][][] beforeItems = new int[][][] {
                {{},{6},{5},{6},{3,6},{},{},{}},
                {{},{6},{5},{6},{3},{},{4},{}},
                {{2,1,3},{2,4},{},{},{}},
                {{3},{},{},{},{1,3,2}}
        };
        SortItemsByGroupsRespectingDependencies solution = new SortItemsByGroupsRespectingDependencies();

        for (int i = 0; i < ns.length; ++i) {
            int[] ans = solution.sortItems(ns[i], ms[i], groups[i], arrayToList2D(beforeItems[i]));
            System.out.println(Arrays.toString(ans));
        }
    }
}
