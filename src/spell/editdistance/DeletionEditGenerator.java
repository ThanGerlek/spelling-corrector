package spell.editdistance;

import java.util.HashSet;
import java.util.Set;

public class DeletionEditGenerator extends EditGenerator {

    /**
     * Generate a Set of versions of the root word with a single character missing.
     *
     * Applies every possible "deletion" edit to the root word, where a deletion
     * edit is defined as deleting a single char in the word. If the root word is
     * less than two chars long, an empty set is returned.
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

        for (int indexToDelete = 0; indexToDelete < rootWord.length(); indexToDelete++) {
            String prefix = rootWord.substring(0, indexToDelete);
            String suffix = rootWord.substring(indexToDelete + 1);
            String editedWord = prefix + suffix;
            editSet.add(editedWord);
        }

        return editSet;
    }

    /**
     * Does nothing for DeletionEditGenerator.
     */
    @Override
    public void useCharSet(Set<Character> charSet) {
    }
}
