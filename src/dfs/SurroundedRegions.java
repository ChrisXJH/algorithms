// https://leetcode.com/problems/surrounded-regions/

package dfs;

import common.Solution;

import java.util.Arrays;
import java.util.Stack;

public class SurroundedRegions extends Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void stackPush(int i, int j, char[][] board, Stack<int[]> stack) {
        board[i][j] = 'P';
        stack.push(new int[] {i, j});
    }

    private static void dfs(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') stackPush(i, 0, board, stack);
            if (board[i][n - 1] == 'O') stackPush(i, n - 1, board, stack);
        }

        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') stackPush(0, j, board, stack);
            if (board[m - 1][j] == 'O') stackPush(m - 1, j, board, stack);
        }

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();

            for (int[] dir : DIRECTIONS) {
                int newI = pos[0] + dir[0];
                int newJ = pos[1] + dir[1];

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == 'O') {
                    stackPush(newI, newJ, board, stack);
                }
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        dfs(board);

        for (char[] row : board) {
            for (int j = 0; j < row.length; ++j) {
                if (row[j] == 'O') row[j] = 'X';
                else if (row[j] == 'P') row[j] = 'O';
            }
        }
    }

    public static void main(String[] args) {
        char[][][] inputs = {
                {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}
        };
        SurroundedRegions solution = new SurroundedRegions();

        for (char[][] board : inputs) {
            solution.solve(board);
            System.out.println(Arrays.deepToString(board));
        }
    }
}
