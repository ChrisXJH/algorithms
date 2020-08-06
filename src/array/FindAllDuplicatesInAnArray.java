package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    // Use the nums array as a hashmap
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != -1 && nums[i] != i + 1) {
                int num = nums[i];
                int tmp = nums[num - 1];

                if (tmp == num) {
                    ans.add(num);
                    nums[i] = -1;
                    break;
                }
                else {
                    nums[num - 1] = num;
                    nums[i] = tmp;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray solution = new FindAllDuplicatesInAnArray();
        int[][] inputs = new int[][] {
                {4,3,2,7,8,2,3,1}
        };

        for (int[] input : inputs) {
            System.out.println(solution.findDuplicates(input).toString());
        }
    }
}
