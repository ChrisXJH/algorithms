// https://leetcode.com/problems/cheapest-flights-within-k-stops/

package dp;

import java.util.*;

public class CheapestFlightsWithinKStops {
    private static final int INF = Integer.MAX_VALUE / 3;

    // Dijkstra method
    public int findCheapestPriceDijkstra(int n, int[][] flights, int src, int dst, int K) {
        // [city, len, cost]
        Queue<int[]> pq = new PriorityQueue<>(1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        Map<Integer, Set<int[]>> adj = new HashMap<>();

        for (int[] edge : flights) {
            if (!adj.containsKey(edge[0])) adj.put(edge[0], new HashSet<>());
            adj.get(edge[0]).add(edge);
        }

        pq.add(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] probe = pq.remove();
            int city = probe[0];
            int len = probe[1];
            int cost = probe[2];

            if (city == dst) return cost;
            if (len > K || !adj.containsKey(city)) continue;

            for (int[] edge : adj.get(city)) {
                pq.add(new int[] {edge[1], len + 1, cost + edge[2]});
            }
        }

        return -1;
    }

    // DP method
    public int findCheapestPriceDP(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[2][n];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
            row[src] = 0;
        }

        for (int[] edge : flights)
            if (edge[0] == src) dp[0][edge[1]] = edge[2];

        for (int k = 1; k <= K; ++k) {
            for (int[] edge : flights) {
                int price = Math.min(dp[(k - 1) % 2][edge[1]], dp[(k - 1) % 2][edge[0]] + edge[2]);
                if (price < dp[k % 2][edge[1]]) dp[k % 2][edge[1]] = price;
            }
        }

        return dp[K % 2][dst] != INF ? dp[K % 2][dst] : -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
        System.out.println(solution.findCheapestPriceDijkstra(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0 , 2, 1));
        System.out.println(solution.findCheapestPriceDijkstra(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0 , 2, 0));
    }
}
