// https://leetcode.com/problems/add-strings/

package strings;

public class AddStrings {
    public String addStrings(String n1, String n2) {
        StringBuilder sb = new StringBuilder();
        char[] num1 = n1.toCharArray();
        char[] num2 = n2.toCharArray();
        int overflow = 0;
        int i  = num1.length - 1;
        int j = num2.length - 1;

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1[i--] - '0' : 0;
            int b = j >= 0 ? num2[j--] - '0' : 0;
            int sum = a + b + overflow;

            overflow = sum / 10;
            sum %= 10;

            sb.append(sum);
        }

        if (overflow != 0) sb.append(overflow);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings solution = new AddStrings();
        String[][] inputs = new String[][] {{"13", "29"}, {"0", "0"}};

        for (String[] input : inputs) {
            System.out.println(solution.addStrings(input[0], input[1]));
        }
    }
}
