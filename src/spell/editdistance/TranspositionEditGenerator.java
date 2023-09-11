package spell.editdistance;

import java.util.HashSet;
import java.util.Set;

public class TranspositionEditGenerator extends EditGenerator {

    /**
     * Generate a Set of versions of the root word with two adjacent characters
     * transposed.
     *
     * Applies every possible "transposition" edit to the root word, where a
     * transposition edit is defined as swapping the locations of two adjacent
     * characters in the word. If the root word is less than two chars long,
     * an empty set is returned.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    @Override
    public Set<String> generate(String rootWord) {
        Set<String> editSet = new HashSet<>();

        if (rootWord.length() < 2) {
            return editSet;
        }

        for (int leftIndexToSwap = 0; leftIndexToSwap < rootWord.length() - 1; leftIndexToSwap++) {
            String prefix = rootWord.substring(0, leftIndexToSwap);
            String suffix = rootWord.substring(leftIndexToSwap + 2);
            Character leftChar = rootWord.charAt(leftIndexToSwap);
            Character rightChar = rootWord.charAt(leftIndexToSwap + 1);
            String editedWord = prefix + rightChar.toString() + leftChar.toString() + suffix;
            editSet.add(editedWord);
        }

        return editSet;
    }

    /**
     * Does nothing for TranspositionEditGenerator.
     */
    @Override
    public void useCharSet(Set<Character> charSet) {
    }
}
