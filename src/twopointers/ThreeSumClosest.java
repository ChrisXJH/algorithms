package twopointers;

import java.util.Arrays;

public class ThreeSumClosest {
    private static int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int d = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);

                if (diff == 0) return sum;
                if (diff < d) {
                    d = diff;
                    ans = sum;
                }

                if (sum < target) ++j;
                else --k;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }
}
