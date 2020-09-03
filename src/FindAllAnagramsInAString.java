import common.Solution;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString extends Solution {
    private static boolean isMatch(int[] count) {
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        int[] count = new int['z' - 'a' + 1];

        for (int i = 0; i < pLen; ++i) {
            ++count[p.charAt(i) - 'a'];
        }

        for (int i = 0; i < s.length(); ++i) {
            char sc = s.charAt(i);
            if (i >= pLen) {
                ++count[s.charAt(i - pLen) - 'a'];
            }

            --count[sc - 'a'];

            if (isMatch(count)) {
                ans.add(i - pLen + 1);
            }
        }

        return ans;
    }
}
