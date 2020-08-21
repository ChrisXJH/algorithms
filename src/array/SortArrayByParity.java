package array;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int curr = 0;

        for (int num : A) {
            if (num % 2 == 0) {
                ans[curr++] = num;
            }
        }

        for (int num : A) {
            if (num % 2 != 0) {
                ans[curr++] = num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][] {
                {3,1,2,4},
                {2,4,6,5,7},
                {},
                {2},
                {1}
        };
        SortArrayByParity solution = new SortArrayByParity();

        for (int[] input : inputs) {
            System.out.println(Arrays.toString(solution.sortArrayByParity(input)));
        }
    }
}
