package dfs;

import common.Solution;

import java.util.Arrays;
import java.util.Stack;

public class FloodFill extends Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {sr, sc});
        image[sr][sc] = -1;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();

            for (int[] dir : dirs) {
                int newR = pos[0] + dir[0];
                int newC = pos[1] + dir[1];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n && image[newR][newC] == originalColor) {
                    stack.push(new int[] {newR, newC});
                    image[newR][newC] = -1;
                }
            }
        }

        for (int[] row : image) {
            for (int i = 0; i < row.length; ++i) {
                if (row[i] == -1) row[i] = newColor;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][][] images = new int[][][] {
                {{1,1,1},{1,1,0},{1,0,1}},
                {{0,0,0},{0,1,1}}
        };
        int[][] sources = {
                {1,1,2},
                {1,1,1}
        };
        FloodFill solution = new FloodFill();

        for (int i = 0; i < images.length; ++i) {
            System.out.println(Arrays.deepToString(solution.floodFill(images[i], sources[i][0], sources[i][1], sources[i][2])));
        }
    }
}
