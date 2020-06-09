// https://leetcode.com/problems/first-missing-positive/

import java.util.Arrays;

public class FirstMissingPositive {
    // Space: O(n)
    public int firstMissingPositive(int[] nums) {
        boolean[] has = new boolean[nums.length];

        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                has[num - 1] = true;
            }
        }

        for (int i = 0; i < has.length; ++i) {
            if (!has[i]) return i + 1;
        }

        return has.length + 1;
    }

    // Space: O(1)
    public int firstMissingPositiveConstantSpace(int[] nums) {
        boolean[] has = new boolean[nums.length];

        int i = 0;
        while (i < nums.length) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
            ++i;
        }

        for (i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }

        return has.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        System.out.println(solution.firstMissingPositiveConstantSpace(new int[] {1,2,0}));
        System.out.println(solution.firstMissingPositiveConstantSpace(new int[] {3,4,-1,1}));
        System.out.println(solution.firstMissingPositiveConstantSpace(new int[] {7,8,9,11,12}));
        System.out.println(solution.firstMissingPositiveConstantSpace(new int[] {1,2,3}));
        System.out.println(solution.firstMissingPositiveConstantSpace(new int[] {1,1}));
    }
}
