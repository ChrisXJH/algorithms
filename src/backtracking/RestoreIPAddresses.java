// https://leetcode.com/problems/restore-ip-addresses/

package backtracking;

import common.Solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses extends Solution {
    private static void dfs(String s, int pos, Deque<String> path, List<String> ans) {
        if (pos == s.length()) {
            if (path.size() == 4) ans.add(String.join(".", path));
            return;
        }

        if (path.size() == 4) return;

        StringBuilder sb = new StringBuilder();

        for (int i = pos; i < s.length(); ++i) {
            sb.append(s.charAt(i));

            if (sb.length() > 1 && sb.charAt(0) == '0') break;

            String numStr = sb.toString();
            int num = Integer.parseInt(numStr);

            if (num > 255) break;

            path.addLast(numStr);
            dfs(s, i + 1, path, ans);
            path.removeLast();
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, new LinkedList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "25525511135",
                "0000",
                "010010"
        };
        RestoreIPAddresses solution = new RestoreIPAddresses();

        for (String input : inputs) {
            System.out.println(solution.restoreIpAddresses(input));
        }
    }
}
