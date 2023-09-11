package spell.editdistance;

import java.util.Set;

public class AdditionEditGenerator extends EditGeneratorWithCharSet {

    /**
     * Generate a Set of versions of the root word containing an additional
     * character from the given char set.
     *
     * Applies every possible "addition edit," defined as inserting an extra lowercase
     * letter somewhere in the word, inlcuding as the first or last char.
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
