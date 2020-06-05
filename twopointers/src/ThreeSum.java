import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;

        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];

            while (j < k) {
                int sum = nums[j] + nums[k];

                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while (j < nums.length && nums[j - 1] == nums[j]) ++j;
                    while (k > j && nums[k + 1] == nums[k]) --k;
                }
                else if (sum < target) {
                    ++j;
                }
                else {
                    --k;
                }
            }

            ++i;
            while (i < nums.length && nums[i - 1] == nums[i]) ++i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
