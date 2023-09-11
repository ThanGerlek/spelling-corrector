package spell;

import java.util.HashMap;

/**
 * A simple Dictionary class using a HashMap from words to word counts.
 */
public class HashMapDictionary implements Dictionary {

    HashMap<String, Integer> words;

    public HashMapDictionary() {
        words = new HashMap<>();
    }

    /**
     * Adds the specified word to the dictionary (if necessary) and increments the word's
     * frequency count.
     *
     * @param word the word being added to the dictionary
     */
    @Override
    public void add(String word) {
        if (words.containsKey(word)) {
            words.replace(word, words.get(word) + 1);
        } else {
            words.put(word, 1);
        }
    }

    /**
     * Searches the dictionary for the specified word and returns the number
     * of times that word appears in the dictionary.
     *
     * @param word the word being searched for.
     * @return the word's frequency count
     */
    @Override
    public int getFrequencyCount(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        }
        return 0;
    }

    /**
     * Returns the number of unique words in the dictionary.
     *
     * @return the number of unique words in the dictionary
     */
    @Override
    public int getWordCount() {
        return words.size();
    }

    public boolean equalsHashMap(HashMap<String,Integer> map) {
        return words.equals(map);
    }
}
