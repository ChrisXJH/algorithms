import common.Solution;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz extends Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 != 0 && i % 5 != 0) {
                ans.add(Integer.toString(i));
                continue;
            }
            String str = "";
            if (i % 3 == 0) str = str.concat("Fizz");
            if (i % 5 == 0) str = str.concat("Buzz");
            ans.add(str);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] inputs = new int[] {15};
        FizzBuzz solution = new FizzBuzz();

        for (int input : inputs) {
            System.out.println(solution.fizzBuzz(input).toString());
        }
    }
}
