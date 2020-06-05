import java.util.Stack;


public class BasicCalculator {
    private static int calculate(String s) {
        Stack<int[]> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int sum = 0;
        int op = 1;

        for (int i = 0; i < arr.length; ++i) {
            char c = arr[i];

            if (c == '+') {
                op = 1;
            }
            else if (c == '-') {
                op = -1;
            }
            else if (c == '(') {
                stack.push(new int[] {op, sum});
                op = 1;
                sum = 0;
            }
            else if (c == ')') {
                int[] saved = stack.pop();

                sum *= saved[0];
                sum += saved[1];
            }
            else if (Character.isDigit(c)) {
                int num = 0;

                while (i < arr.length) {
                    num *= 10;
                    num += arr[i] - '0';
                    if (i + 1 >= arr.length || !Character.isDigit(arr[i + 1])) break;
                    ++i;
                }
                sum += op * num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "1 + 1",
                " 2-1 + 2 ",
                "(1+(4+5+2)-3)+(6+8)",
                "-(1+(4+5+2)-3)+(6+8)",
                "2147483647"
        };

        for (String input : inputs)
            System.out.println(calculate(input));
    }
}
