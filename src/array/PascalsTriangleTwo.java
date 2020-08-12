// https://leetcode.com/problems/pascals-triangle-ii/

package array;

import common.Solution;

import java.util.ArrayList;
import java.util.List;

/*
[1]
[1,1]
[1,2,1]
[1,3,3,1]
[1,4,6,4,1]
*/

public class PascalsTriangleTwo extends Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();

        to.add(1);

        for (int i = 1; i <= rowIndex; ++i) {
            List<Integer> tmp = from;

            from = to;
            to = tmp;
            to.clear();

            for (int j = 0; j <= from.size(); ++j) {
                int a = j > 0 ? from.get(j - 1) : 0;
                int b = j < from.size() ? from.get(j) : 0;

                to.add(a + b);
            }
        }

        return to;
    }

    public static void main(String[] args) {
        int[] inputs = new int[] {3, 0};
        PascalsTriangleTwo solution = new PascalsTriangleTwo();

        for (int input : inputs) {
            System.out.println(solution.getRow(input).toString());
        }
    }
}
