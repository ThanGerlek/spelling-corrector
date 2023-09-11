package spell;

import spell.editdistance.EditDistanceSetGenerator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SpellCorrector implements ISpellCorrector {

    private Dictionary dictionary;

    public SpellCorrector() {
        dictionary = new Trie();
    }

    public SpellCorrector(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

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
        // TODO implement useDictionary()
    }

    public void useDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
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
        inputWord = cleanInputWord(inputWord);
        if (dictionary.containsWord(inputWord)) {
            return inputWord;
        }

        MostFrequentWordFinder corrector = new MostFrequentWordFinder(dictionary);

        Set<String> editDist1Set = generateEditSetFromString(inputWord);
        corrector.findInSet(editDist1Set);
        if (corrector.foundWord()) {
            return corrector.getWord();
        }

        Set<String> editDist2Set = generateEditSetFromSet(editDist1Set);
        corrector.findInSet(editDist2Set);
        if (corrector.foundWord()) {
            return corrector.getWord();
        }

        return null;
    }

    /**
     * Return a transformed version of this word containing only lowercase letters.
     *
     * @param inputWord the word to transform
     * @return the transformed word, containing only the chars a-z
     */
    private String cleanInputWord(String inputWord) {
        inputWord = inputWord.trim();
        inputWord = inputWord.replaceAll("[^a-zA-Z]+", "");
        return inputWord.toLowerCase();
    }

    private Set<String> generateEditSetFromString(String inputWord) {
        EditDistanceSetGenerator generator = new EditDistanceSetGenerator();
        return generator.generate(inputWord);
    }

    private Set<String> generateEditSetFromSet(Set<String> inputSet) {
        EditDistanceSetGenerator generator = new EditDistanceSetGenerator();
        Set<String> outputSet = new HashSet<>();

        for (String word : inputSet) {
            Set<String> partialEditSet = generator.generate(word);
            outputSet.addAll(partialEditSet);
        }
        return outputSet;
    }

}

