package spell;

import java.io.IOException;

public class SpellCorrector implements ISpellCorrector {
    /**
     * Tells this <code>SpellCorrector</code> to use the given file as its dictionary
     * for generating suggestions.
     *
     * @param dictionaryFileName the file containing the words to be used
     * @throws IOException If the file cannot be read
     * @pre SpellCorrector will have had empty-param constructor called, but dictionary has nothing in it.
     * @post SpellCorrector will have dictionary filled and be ready to suggestSimilarWord any number of times.
     */
    @Override
    public void useDictionary(String dictionaryFileName) throws IOException {

    }

    /**
     * Suggest a word from the dictionary that most closely matches
     * <code>inputWord</code>.
     *
     * @param inputWord the word we are trying to find or find a suggestion for
     * @return the suggestion or null if there is no similar word in the dictionary
     */
    @Override
    public String suggestSimilarWord(String inputWord) {
        return null;
    }
}