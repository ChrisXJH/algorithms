package unionfind;

import common.Solution;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor extends Solution {
    static class DSU {
        private final int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            parent[rootB] = rootA;
        }
    }

    public int largestComponentSize(int[] A) {
        int max = A[0];
        for (int num : A) {
            max = Math.max(num, max);
        }

        DSU dsu = new DSU(max + 1);

        for (int num : A) {
            double end = Math.sqrt(num);
            for (int i = 2; i <= end; ++i) {
                if (num % i == 0) {
                    dsu.union(i, num);
                    dsu.union(num / i, num);
                }
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int num : A) {
            int key = dsu.find(num);
            count.put(key, count.getOrDefault(key, 0) + 1);
            ans = Math.max(count.get(key), ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][] {
                {4,6,15,35},
                {20,50,9,63},
                {2,3,6,7,4,12,21,39}
        };
        LargestComponentSizeByCommonFactor solution = new LargestComponentSizeByCommonFactor();

        for (int[] input : inputs) {
            System.out.println(solution.largestComponentSize(input));
        }
    }
}
