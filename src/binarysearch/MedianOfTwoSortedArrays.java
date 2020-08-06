package binarysearch;

public class MedianOfTwoSortedArrays {
    private float getKth(int[] nums1, int lo1, int hi1, int[] nums2, int lo2, int hi2, int k) {
        int len1 = hi1 - lo1;
        int len2 = hi2 - lo2;

        if (len2 < len1) return getKth(nums2, lo2, hi2, nums1, lo1, hi1, k);

        if (len1 == 0) return nums2[lo2 + k - 1];
        if (k == 1) return Math.min(nums1[lo1], nums2[lo2]);

        int mid1 = lo1 + Math.min(len1, k / 2) - 1;
        int mid2 = lo2 + Math.min(len2, k / 2) - 1;

        if (nums1[mid1] < nums2[mid2]) {
            return getKth(nums1, mid1 + 1, hi1, nums2, lo2, hi2, k - (mid1 - lo1 + 1));
        }

        return getKth(nums1, lo1, hi1, nums2, mid2 + 1, hi2, k - (mid2 - lo2 + 1));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = (n1 + n2 + 1) / 2;
        int right = (n1 + n2 + 2) / 2;

        float leftNum = getKth(nums1, 0, n1, nums2, 0, n2, left);
        float rightNum = getKth(nums1, 0, n1, nums2, 0, n2, right);

        return (leftNum + rightNum) / 2;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[][][] inputs = new int[][][] {
                {{1, 3}, {2}},
                {{1, 2}, {3, 4}},
                {{1, 2}, {-1, 3}}
        };

        for (int[][] input : inputs) {
            System.out.println(solution.findMedianSortedArrays(input[0], input[1]));
        }
    }
}
