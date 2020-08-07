package array;

import java.util.Arrays;

public class NextPermutation {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    // 1 2 5 8 7 6
    // 1 2 6 8 7 5 -> 1 2 6 5 7 8
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) --i;

        if (i >= 0) {
            int j = n - 1;

            while (j > i && nums[j] <= nums[i]) --j;

            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[][] inputs = new int[][] {
                {1,2,3},
                {3,2,1},
                {1,1,5}
        };

        for (int[] input : inputs) {
            int[] nums = Arrays.copyOf(input, input.length);
            solution.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
