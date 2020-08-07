// https://leetcode.com/problems/longest-consecutive-sequence/

package array;

import common.Solution;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence extends Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) seen.add(num);

        for (int num : seen) {
            if (!seen.contains(num - 1)) {
                int count = 1;
                while (seen.contains(++num)) ++count;
                ans = Math.max(count, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[][] inputs = new int[][] {
                {100, 4, 200, 1, 3, 2}
        };

        for (int[] input : inputs) {
            System.out.println(solution.longestConsecutive(input));
        }
    }
}
