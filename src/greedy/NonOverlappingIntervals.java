package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = 0;
        int prev = Integer.MIN_VALUE;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int[] interval : intervals) {
            if (interval[0] >= prev) {
                ++max;
                prev = interval[1];
            }
        }

        return intervals.length - max;
    }

    public static void main(String[] args) {
        int[][][] inputs = new int[][][] {
                {{1,2},{2,3},{3,4},{1,3}},
                {{1,2},{1,2},{1,2}},
                {{1,2},{2,3}}
        };
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        for (int[][] input : inputs) {
            System.out.println(solution.eraseOverlapIntervals(input));
        }
    }
}
