package spell.editdistance;

import java.util.Set;

public class DeletionEditGenerator implements EditGenerator {

    /**
     * Generate a Set of versions of the root word with a single character missing.
     *
     * Applies every possible "deletion" edit, where a deletion edit is defined
     * as deleting a single char in the word, including the first or last char.
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
