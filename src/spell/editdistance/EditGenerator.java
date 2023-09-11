package spell.editdistance;

import java.util.Set;

public interface EditGenerator {

    /**
     * Generate a Set of edited versions of the root word.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    Set<String> generate(String rootWord);
}
