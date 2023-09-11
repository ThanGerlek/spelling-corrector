package spell.editdistance;

import java.util.Set;

public class ReplacementEditGenerator implements EditGenerator {

    /**
     * Generate a Set of versions of the root word with a single character replaced.
     *
     * Applies every possible "replacement" edit, where a replacement edit is defined
     * as replacing a single char somewhere in the word with a different
     * lowercase letter.
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
