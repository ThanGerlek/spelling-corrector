package spell;

public interface Dictionary {

    /**
     * Adds the specified word to the dictionary (if necessary) and increments the word's
     * frequency count.
     *
     * @param word the word being added to the dictionary
     */
    void add(String word);

    /**
     * Searches the dictionary for the specified word and returns the number
     * of times that word appears in the dictionary.
     *
     * @param word the word being searched for.
     * @return the word's frequency count
     */
    int getFrequencyCount(String word);

    /**
     * Returns the number of unique words in the dictionary.
     *
     * @return the number of unique words in the dictionary
     */
    int getWordCount();

    boolean containsWord(String word);
}
