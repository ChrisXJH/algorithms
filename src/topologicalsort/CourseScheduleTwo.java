// https://leetcode.com/problems/course-schedule-ii/

package topologicalsort;

import common.Solution;

import java.util.*;

public class CourseScheduleTwo extends Solution {
    private static void buildGraph(int[][] prerequisites, Map<Integer, Set<Integer>> adj, int[] inorder) {
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];

            if (!adj.containsKey(u)) adj.put(u, new HashSet<>());
            adj.get(u).add(v);
            ++inorder[v];
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[] inorder = new int[numCourses];

        buildGraph(prerequisites, adj, inorder);

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];
        int curr = 0;

        for (int n = 0; n < inorder.length; ++n) {
            if (inorder[n] == 0) queue.add(n);
        }

        while (!queue.isEmpty()) {
            int u = queue.remove();

            ans[curr++] = u;

            if (!adj.containsKey(u)) continue;

            for (int v : adj.get(u)) {
                --inorder[v];

                if (inorder[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (curr != numCourses) return new int[0];
        return ans;
    }

    public static void main(String[] args) {
        int[][][] prerequisites = new int[][][] {
                {{1,0}},
                {{1,0},{2,0},{3,1},{3,2}},
                {{1,0},{1,2},{0,1}}
        };
        int[] numCourses = new int[] {2, 4, 3};
        CourseScheduleTwo solution = new CourseScheduleTwo();

        for (int i = 0; i < prerequisites.length; ++i) {
            System.out.println(Arrays.toString(solution.findOrder(numCourses[i], prerequisites[i])));
        }
    }
}
