// https://leetcode.com/problems/pancake-sorting/

package array;

import common.Solution;

import java.util.ArrayList;
import java.util.List;


public class PancakeSorting extends Solution {
    private static void reverse(int[] arr, int hi) {
        int lo = 0;
        while (lo < hi) {
            int tmp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = tmp;
        }
    }

    private static int findLargest(int[] arr, int hi) {
        int pos = 0;

        for (int i = 1; i <= hi; ++i) {
            if (arr[pos] < arr[i]) {
                pos = i;
            }
        }

        return pos;
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        int i = A.length - 1;
        while (i >= 0) {
            int j = findLargest(A, i);
            if (i == j) {
                --i;
                continue;
            }
            ans.add(j + 1);
            reverse(A, j);
            ans.add(i + 1);
            reverse(A, i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][] {
                {3,2,4,1}
        };
        PancakeSorting solution = new PancakeSorting();

        for (int[] input : inputs) {
            System.out.print(solution.pancakeSort(input).toString());
        }
    }
}
