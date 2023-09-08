package spell;

import spell.INode;
import spell.ITrie;

public class Trie implements ITrie {
    /**
     * Adds the specified word to the trie (if necessary) and increments the word's
     * frequency count.
     *
     * @param word the word being added to the trie
     */
    @Override
    public void add(String word) {

    }

    /**
     * Searches the trie for the specified word.
     *
     * @param word the word being searched for.
     * @return a reference to the trie node that represents the word,
     * or null if the word is not in the trie
     */
    @Override
    public INode find(String word) {
        return null;
    }

    /**
     * Returns the number of unique words in the trie.
     *
     * @return the number of unique words in the trie
     */
    @Override
    public int getWordCount() {
        return 0;
    }

    /**
     * Returns the number of nodes in the trie.
     *
     * @return the number of nodes in the trie
     */
    @Override
    public int getNodeCount() {
        return 0;
    }
}
