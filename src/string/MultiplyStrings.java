// https://leetcode.com/problems/multiply-strings/

package string;

import common.Solution;

import java.util.Arrays;

/*
    1 2 3
    4 5 6
 --------
      1 8
    1 2
  0 6
*/

public class MultiplyStrings extends Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || "".equals(num1) || num2 == null || "".equals(num2)) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];

        for (int j = n - 1; j >= 0; --j) {
            for (int i = m - 1; i >= 0; --i) {
                int pLo = i + j + 1;
                int pHi = i + j;
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product[pLo] + num;
                product[pHi] += sum / 10;
                product[pLo] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < product.length - 1 && product[i] == 0) ++i;
        for (; i < product.length; ++i) {
            sb.append(product[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[][] inputs = new String[][] {
                {"2", "3"},
                {"123", "456"},
                {"0", "0"},
                {"", ""},
                {"9133", "0"}
        };
        MultiplyStrings solution = new MultiplyStrings();

        for (String[] input : inputs) {
            System.out.println(solution.multiply(input[0], input[1]));
        }
    }
}
