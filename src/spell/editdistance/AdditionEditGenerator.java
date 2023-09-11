package spell.editdistance;

import java.util.HashSet;
import java.util.Set;

public class AdditionEditGenerator extends EditGenerator {

    private Set<Character> charSet = super.getDefaultCharSet();

    /**
     * Generate a Set of versions of the root word containing an additional
     * character from the current char set.
     *
     * Applies every possible "addition" edit to the root word, where an
     * addition edit is defined as inserting a char from the current char set
     * somewhere in the word, inlcuding as the first or last char.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    @Override
    public Set<String> generate(String rootWord) {
        Set<String> editSet = new HashSet<>();

        for (int indexToInsert = 0; indexToInsert <= rootWord.length(); indexToInsert++) {
            String prefix = rootWord.substring(0, indexToInsert);
            String suffix = rootWord.substring(indexToInsert);
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
