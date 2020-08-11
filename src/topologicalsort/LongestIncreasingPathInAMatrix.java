// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

package topologicalsort;

import common.Solution;

import java.util.*;

public class LongestIncreasingPathInAMatrix extends Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean isValidPosition(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private static void calculateInorder(int[][] matrix, int[][] inorder) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] dir : DIRS) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if (isValidPosition(newI, newJ, m, n) && matrix[newI][newJ] > matrix[i][j]) {
                        ++inorder[newI][newJ];
                    }
                }
            }
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[][] inorder = new int[m][n];
        int ans = 0;

        calculateInorder(matrix, inorder);

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (inorder[i][j] == 0) queue.add(new int[] {i, j});
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            ++ans;

            while (len-- > 0) {
                int[] pos = queue.remove();
                int i = pos[0];
                int j = pos[1];

                for (int[] dir : DIRS) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if (isValidPosition(newI, newJ, m, n) && matrix[newI][newJ] > matrix[i][j]) {
                        --inorder[newI][newJ];
                        if (inorder[newI][newJ] == 0) queue.add(new int[] {newI, newJ});
                    }
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][][] matrices = new int[][][] {
                {
                        {9,9,4},
                        {6,6,8},
                        {2,1,1}
                },
                {
                        {3,4,5},
                        {3,2,6},
                        {2,2,1}
                },
                {
                        {0},{1},{5},{5}
                }
        };
        LongestIncreasingPathInAMatrix solution = new LongestIncreasingPathInAMatrix();

        for (int[][] matrix : matrices) {
            System.out.println(solution.longestIncreasingPath(matrix));
        }
    }
}
