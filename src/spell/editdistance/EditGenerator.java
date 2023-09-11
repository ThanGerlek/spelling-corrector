package spell.editdistance;

import java.util.HashSet;
import java.util.Set;

public abstract class EditGenerator {

    private static final char[] DEFAULT_CHARSET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * Generate a Set of edited versions of the root word using
     * the default char set.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    public abstract Set<String> generate(String rootWord);

    public abstract void useCharSet(Set<Character> charSet);

    protected Set<Character> getDefaultCharSet() {
        Set<Character> charSet = new HashSet<>();
        for (char c : DEFAULT_CHARSET) {
            charSet.add(c);
        }
        return charSet;
    }
}
