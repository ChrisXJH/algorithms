// https://leetcode.com/problems/rotting-oranges/

import common.Solution;

public class RottingOranges extends Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean hasFresh(int[][] grid) {
        for (int[] row : grid) {
            for (int col : row) {
                if (col == 1) return true;
            }
        }

        return false;
    }

    private static boolean nextGrid(int[][] grid) {
        boolean changed = false;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] != 2) continue;

                for (int[] dir : dirs) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[newI].length
                    && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 22;
                        changed = true;
                    }
                }
            }
        }

        for (int[] row : grid) {
            for (int i = 0; i < row.length; ++i) {
                if (row[i] == 22) row[i] = 2;
            }
        }

        return changed;
    }

    public int orangesRotting(int[][] grid) {
        int ans = 0;

        while (hasFresh(grid)) {
            ++ans;
            if (!nextGrid(grid)) return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][][] inputs = new int[][][] {
                {{2,1,1},{1,1,0},{0,1,1}},
                {{2,1,1},{0,1,1},{1,0,1}},
                {{0,2}}
        };
        RottingOranges solution = new RottingOranges();

        for (int[][] grid : inputs) {
            System.out.println(solution.orangesRotting(grid));
        }
    }
}
