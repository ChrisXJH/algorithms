package dfs;

import java.util.Stack;

public class Minesweeper {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private static int countMines(char[][] board, int x, int y) {
        int ans = 0;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[newX].length
                    && board[newX][newY] == 'M') {
                ++ans;
            }
        }

        return ans;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {click[0], click[1]});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int x = pos[0];
            int y = pos[1];

            int mines = countMines(board, x, y);
            if (mines > 0) {
                board[x][y] = (char) (mines + '0');
                continue;
            }

            board[x][y] = 'B';

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'E') {
                    stack.push(new int[] {newX, newY});
                }
            }
        }

        return board;
    }
}
