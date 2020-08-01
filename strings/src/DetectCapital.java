// https://leetcode.com/problems/detect-capital/

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;

        char[] chars = word.toCharArray();

        if (Character.isLowerCase(chars[0])) {
            for (int i = 1; i < chars.length; ++i) {
                if (Character.isUpperCase(chars[i])) return false;
            }
        }
        else if (Character.isLowerCase(chars[1])) {
            for (int i = 2; i < chars.length; ++i) {
                if (Character.isUpperCase(chars[i])) return false;
            }
        }
        else {
            for (int i = 2; i < chars.length; ++i) {
                if (Character.isLowerCase(chars[i])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DetectCapital solution = new DetectCapital();
        String[] inputs = new String[] {"USA", "FlaG"};

        for (String input : inputs) {
            System.out.println(solution.detectCapitalUse(input));
        }
    }
}
