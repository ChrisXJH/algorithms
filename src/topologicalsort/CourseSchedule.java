// https://leetcode.com/problems/course-schedule/

package topologicalsort;

import common.Solution;

import java.util.*;

public class CourseSchedule extends Solution {
    private static void buildGraph(int[][] prerequisites, Map<Integer, Set<Integer>> adj, int[] inorder) {
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];

            if (!adj.containsKey(u)) adj.put(u, new HashSet<>());
            adj.get(u).add(v);

            ++inorder[v];
        }
    }

    private static void topologicalSort(Map<Integer, Set<Integer>> adj, int[] inorder) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.remove();

            if (!adj.containsKey(u)) continue;

            for (int v : adj.get(u)) {
                --inorder[v];
                if (inorder[v] == 0) queue.add(v);
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[] inorder = new int[numCourses];

        buildGraph(prerequisites, adj, inorder);
        topologicalSort(adj, inorder);

        for (int order : inorder) {
            if (order > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][][] prerequisites = new int[][][] {
                {{1,0}},
                {{1,0},{0,1}}
        };
        int[] numCourses = new int[] {2, 2};
        CourseSchedule solution = new CourseSchedule();

        for (int i = 0; i < prerequisites.length; ++i) {
            System.out.println(solution.canFinish(numCourses[i], prerequisites[i]));
        }
    }
}
