//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//        Output: 1
//        Example 2:
//
//        Input:
//        11000
//        11000
//        00100
//        00011
//
//        Output: 3

package dfs;

import java.util.Stack;

public class NumberOfIslands {
    private char[][] grid;

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void dfs(int i, int j) {
        Stack<int[]> stack = new Stack<>();

        grid[i][j] = '0';
        stack.push(new int[] {i, j});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();

            for (int[] dir : dirs) {
                int newI = pos[0] + dir[0];
                int newJ = pos[1] + dir[1];

                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[newI].length
                        && grid[newI][newJ] == '1') {
                    grid[newI][newJ] = '0';
                    stack.push(new int[] {newI, newJ});
                }
            }
        }
    }

    private int numIslands(char[][] grid) {
        this.grid = grid;

        int ans = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '0') continue;

                ++ans;
                dfs(i, j);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        System.out.println(solution.numIslands(
                new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}
        ));
    }
}
