// https://leetcode.com/problems/excel-sheet-column-number/

package string;

import common.Solution;

public class ExcelSheetColumnNumber extends Solution {
    private static final int BASE = 26;

    public int titleToNumber(String s) {
        int ans = 0;

        for (char c : s.toCharArray()) {
            ans *= BASE;
            ans += c - 'A' + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"A", "AB", "ZY"};
        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();

        for (String input : inputs) {
            System.out.println(solution.titleToNumber(input));
        }
    }
}
