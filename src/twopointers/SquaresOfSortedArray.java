package twopointers;

import java.util.Arrays;

public class SquaresOfSortedArray {
    private static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i)
            A[i] = A[i] * A[i];

        int[] ans = new int[A.length];
        int i = 0, j = A.length - 1;
        int k = ans.length - 1;

        while (i <= j) {
            if (A[i] > A[j]) ans[k--] = A[i++];
            else ans[k--] = A[j--];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {-4,-1,0,3,10},
                {-7,-3,2,3,11}
        };

        for (int[] input : inputs)
            System.out.println(Arrays.toString(sortedSquares(input)));
    }
}
