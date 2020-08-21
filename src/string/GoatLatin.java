package string;

public class GoatLatin {
    private static boolean isVowel(String word) {
        char c = Character.toLowerCase(word.charAt(0));
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }

    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+");

        for (int i = 0; i < words.length; ++i) {
            StringBuilder sb = new StringBuilder();
            if (!isVowel(words[i])) {
                sb.append(words[i].substring(1)).append(words[i].charAt(0));
            }
            else {
                sb.append(words[i]);
            }

            sb.append("ma");
            sb.append("a".repeat(i + 1));

            words[i] = sb.toString();
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "I speak Goat Latin",
                "The quick brown fox jumped over the lazy dog"
        };
        GoatLatin solution = new GoatLatin();

        for (String input : inputs) {
            System.out.println(solution.toGoatLatin(input));
        }
    }
}
