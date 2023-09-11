package spell.editdistance;

import java.util.HashSet;
import java.util.Set;

public abstract class EditGeneratorWithCharSet implements EditGenerator {

    protected static final char[] DEFAULT_CHARSET = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /**
     * Generate a Set of edited versions of the root word using
     * the given char set.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    abstract Set<String> generate(String rootWord, Set<Character> charSet);

    /**
     * Generate a Set of edited versions of the root word using
     * the default char set.
     *
     * @param rootWord the word to edit
     * @return the Set of edited versions of the root word
     */
    @Override
    public Set<String> generate(String rootWord) {
        Set<Character> charSet = new HashSet<>();
        for (char c : DEFAULT_CHARSET) {
            charSet.add(c);
        }
        return generate(rootWord, charSet);
    }
}
