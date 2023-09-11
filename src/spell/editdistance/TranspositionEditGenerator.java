package spell.editdistance;

import java.util.Set;

public class TranspositionEditGenerator implements EditGenerator {

    /**
     * Generate a Set of versions of the root word with two adjacent characters transposed.
     *
     * Applies every possible "transposition" edit, where a transposition
     * edit is defined as swapping the locations of two adjacent characters
     * in the word.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    @Override
    public Set<String> generate(String rootWord) {
        // TODO implement generate()
        return null;
    }
}
