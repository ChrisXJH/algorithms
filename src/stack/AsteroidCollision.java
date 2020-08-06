// https://leetcode.com/problems/asteroid-collision/

package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int num : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && num < 0) {
                int prev = stack.pop();
                int numAbs = Math.abs(num);
                int prevAbs = Math.abs(prev);

                if (numAbs == prevAbs) {
                    num = 0;
                    break;
                }
                num = prevAbs > numAbs ? prev : num;
            }

            if (num != 0) stack.push(num);
        }

        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0; --i)
            ans[i] = stack.pop();

        return ans;
    }

    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{8, -8})));
    }
}
