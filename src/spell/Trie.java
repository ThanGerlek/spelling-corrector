package spell;

public class Trie implements ITrie, Dictionary {

    private final TrieNode root;
    private int wordCount, nodeCount;

    public Trie() {
        root = new TrieNode();
        wordCount = 0;
        nodeCount = 1;
    }

    /**
     * Adds the specified word to the trie (if necessary) and increments the word's
     * frequency count.
     *
     * @param word the word being added to the trie
     */
    @Override
    public void add(String word) {
        if (word == "") return;
        TrieNode node = find(word);
        if (node == null) {
            node = createNewNodeForWord(word);
        }
        if (node.getValue() == 0) {
            wordCount++;
        }
        node.incrementValue();
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
        TrieNode node = find(word);
        if (node == null) {
            return 0;
        }
        return node.getValue();
    }

    private TrieNode createNewNodeForWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.getChild(c) == null) {
                node.addChild(c);
                nodeCount++;
            }
            node = node.getChild(c);
        }
        return node;
    }

    /**
     * Searches the trie for the specified word.
     *
     * @param word the word being searched for.
     * @return a reference to the trie node that represents the word,
     * or null if the word is not in the trie
     */
    @Override
    public TrieNode find(String word) {
        if (word == "") {
            return null;
        }
        TrieNode node = root;
        for (int nextCharIndex = 0; nextCharIndex < word.length(); nextCharIndex++) {
            char nextChar = word.charAt(nextCharIndex);
            if (!node.hasChild(nextChar)) {
                return null;
            }
            node = node.getChild(nextChar);
        }
        return (node.getValue() == 0) ? null : node;
    }


    /**
     * Returns the number of unique words in the trie.
     *
     * @return the number of unique words in the trie
     */
    @Override
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Returns the number of nodes in the trie.
     *
     * @return the number of nodes in the trie
     */
    @Override
    public int getNodeCount() {
        return nodeCount;
    }

    @Override
    public boolean containsWord(String word) {
        TrieNode node = find(word);
        return node != null && node.getValue() > 0;
    }

    @Override
    public int hashCode() {
        int firstNonNullChildIndex = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (root.hasChild(c)) {
                firstNonNullChildIndex = c - 'a';
                break;
            }
        }

        return (firstNonNullChildIndex + 1) * wordCount * nodeCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other.getClass() != Trie.class) return false;

        Trie otherTrie = (Trie) other;
        if (nodeCount != otherTrie.nodeCount || wordCount != otherTrie.wordCount) {
            return false;
        }

        return root.equals(otherTrie.root);
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
