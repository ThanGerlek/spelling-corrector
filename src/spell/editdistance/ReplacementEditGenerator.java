package spell.editdistance;

import java.util.Set;

public class ReplacementEditGenerator extends EditGeneratorWithCharSet {

    /**
     * Generate a Set of versions of the root word with a single character replaced
     * with a char from the given char set.
     *
     * Applies every possible "replacement" edit to the root word, where a
     * replacement edit is defined as replacing a single char somewhere in the
     * word with a (different) char from the given char set. Replacing a char
     * with itself is not counted as a replacement edit.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    @Override
    public Set<String> generate(String rootWord, Set<Character> charSet) {
        // TODO implement generate()
        return null;
    }
}
