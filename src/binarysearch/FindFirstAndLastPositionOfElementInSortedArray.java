//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]

package binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private static int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > target || (left && nums[mid] == target)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private static int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);

        if (left >= nums.length || nums[left] != target) return new int[]{-1, -1};

        int right = binarySearch(nums, target, false) - 1;

        return new int[] {left, right};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8,
                8, 10}, 8)));
    }
}
