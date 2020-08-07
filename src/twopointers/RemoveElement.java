package twopointers;

import common.Solution;

import java.util.Arrays;

public class RemoveElement extends Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] == val) ++j;
            else nums[i++] = nums[j++];
        }

        return i;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[][] arrays = new int[][] {
                {3,2,2,3},
                {0,1,2,2,3,0,4,2}
        };
        int[] vals = new int[] {3, 2};

        for (int i = 0; i < arrays.length; ++i) {
            int[] nums = arrays[i];
            int val = vals[i];

            int result = solution.removeElement(nums, val);
            System.out.println(Arrays.toString(Arrays.copyOf(nums, result)));
        }
    }
}
