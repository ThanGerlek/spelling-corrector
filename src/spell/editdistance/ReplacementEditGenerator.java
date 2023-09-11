package spell.editdistance;

import java.util.HashSet;
import java.util.Set;

public class ReplacementEditGenerator extends EditGenerator {

    private Set<Character> charSet = super.getDefaultCharSet();

    /**
     * Generate a Set of versions of the root word with a single character replaced
     * with a char from the current char set.
     *
     * Applies every possible "replacement" edit to the root word, where a
     * replacement edit is defined as replacing a single char somewhere in the
     * word with a (different) char from the current char set. Replacing a char
     * with itself is not counted as a replacement edit.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    @Override
    public Set<String> generate(String rootWord) {
        Set<String> editSet = new HashSet<>();

        for (int indexToReplace = 0; indexToReplace < rootWord.length(); indexToReplace++) {
            String prefix = rootWord.substring(0, indexToReplace);
            String suffix = rootWord.substring(indexToReplace + 1);
            for (Character c : charSet) {
                String editedWord = prefix + c.toString() + suffix;
                editSet.add(editedWord);
            }
        }

        return editSet;
    }

    @Override
    public void useCharSet(Set<Character> charSet) {
        this.charSet = charSet;
    }
}
