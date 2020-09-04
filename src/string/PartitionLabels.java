package string;

import common.Solution;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels extends Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] last = new int['z' - 'a' + 1];

        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int end = 0;
        int prev = -1;

        for (int i = 0; i < S.length(); ++i) {
            end = Math.max(last[S.charAt(i) - 'a'], end);
            if (end == i) {
                ans.add(i - prev);
                prev = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "ababcbacadefegdehijhklij"
        };
        PartitionLabels solution = new PartitionLabels();

        for (String input : inputs) {
            System.out.println(solution.partitionLabels(input).toString());
        }
    }
}
