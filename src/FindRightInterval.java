import common.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval extends Solution {

    // TreeMap method
    public int[] findRightIntervalTreeMap(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] ans = new int[intervals.length];

        Arrays.fill(ans, -1);

        for (int i = 0; i < intervals.length; ++i) {
            treeMap.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            int[] interval = intervals[i];
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(interval[1]);

            if (entry != null) {
                ans[i] = entry.getValue();
            }
        }

        return ans;
    }

    private static int binarySearch(int[][] intervals, int target) {
        int lo = 0;
        int hi = intervals.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (intervals[mid][0] == target) return intervals[mid][1];
            if (intervals[mid][0] < target) lo = mid + 1;
            else hi = mid;
        }

        if (lo == intervals.length) return -1;
        return intervals[lo][1];
    }

    // Binary Search Method
    public int[] findRightInterval(int[][] intervals) {
        int[][] sorted = new int[intervals.length][2];
        int[] ans = new int[intervals.length];

        for (int i = 0; i < intervals.length; ++i) {
            sorted[i][0] = intervals[i][0];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; ++i) {
            ans[i] = binarySearch(sorted, intervals[i][1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][][] inputs = new int[][][] {
                {{1,2}},
                {{3,4}, {2,3}, {1,2}},
                {{1,4}, {2,3}, {3,4}}
        };
        FindRightInterval solution = new FindRightInterval();

        for (int[][] input : inputs) {
            System.out.println(Arrays.toString(solution.findRightInterval(input)));
        }
    }
}
