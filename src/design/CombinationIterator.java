package design;

import common.Solution;

public class CombinationIterator extends Solution {
    private final String characters;
    private final int[] positions;
    private boolean ended;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        positions = new int[combinationLength];
        for (int i = 0; i < positions.length; ++i) {
            positions[i] = i;
        }
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int pos : positions) {
            sb.append(characters.charAt(pos));
        }

        int i = positions.length - 1;
        for (; i >= 0; --i) {
            if (positions[i] != characters.length() - (positions.length - i)) {
                ++positions[i];

                for (int j = i + 1; j < positions.length; ++j) {
                    positions[j] = positions[i] + (j - i);
                }

                break;
            }
        }

        ended = i == -1;

        return sb.toString();
    }

    public boolean hasNext() {
        return !ended;
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }
}
