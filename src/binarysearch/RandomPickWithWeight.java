//Given an array w of positive integers, where w[i] describes the weight of index i,
// write a function pickIndex which randomly picks an index in proportion to its weight.
//
//        Note:
//
//        1 <= w.length <= 10000
//        1 <= w[i] <= 10^5
//        pickIndex will be called at most 10000 times.
//        Example 1:
//
//        Input:
//        ["Solution","pickIndex"]
//        [[[1]],[]]
//        Output: [null,0]
//        Example 2:
//
//        Input:
//        ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//        [[[1,3]],[],[],[],[],[]]
//        Output: [null,0,1,1,1,0]

package binarysearch;

import java.util.Random;

public class RandomPickWithWeight {

    private class Solution {
        private int totalWeight;

        private int[] cdf;

        Random random;

        public Solution(int[] w) {
            totalWeight = 0;
            cdf = new int[w.length];
            random = new Random();

            for (int i = 0; i < w.length; ++i) {
                totalWeight += w[i];
                cdf[i] = totalWeight;
            }
        }

        public int pickIndex() {
            int target = random.nextInt(totalWeight);
            int lo = 0;
            int hi = cdf.length - 1;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (cdf[mid] <= target) lo = mid + 1;
                else hi = mid;
            }

            return lo;
        }
    }

    public static void main(String[] args) {

    }
}
