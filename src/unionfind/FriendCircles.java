package unionfind;

import common.Solution;

import java.util.Arrays;

public class FriendCircles extends Solution {
    static class DisjointSet {
        private final int[] parent;

        DisjointSet(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        public int find(int node) {
            int ans = node;
            while (parent[ans] != -1) ans = parent[ans];
            return ans;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            int curr = y;
            while (parent[curr] != -1) {
                int next = parent[curr];
                parent[curr] = rootX;
                curr = next;
            }

            parent[curr] = rootX;
        }

        public int getSetCount() {
            int ans = 0;
            for (int num : parent) {
                if (num == -1) ++ans;
            }

            return ans;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        DisjointSet set = new DisjointSet(n);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (M[i][j] != 1) continue;
                set.union(i, j);
            }
        }

        return set.getSetCount();
    }

    public static void main(String[] args) {
        int[][][] inputs = new int[][][] {
                {{1,1,0},{1,1,0},{0,0,1}},
                {{1,1,0}, {1,1,1},{0,1,1}},
                {{1,1,1},{1,1,1},{1,1,1}}
        };
        FriendCircles solution = new FriendCircles();

        for (int[][] input : inputs) {
            System.out.println(solution.findCircleNum(input));
        }
    }
}
