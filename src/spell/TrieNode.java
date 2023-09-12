package spell;

public class TrieNode implements INode {

    private int count;
    private TrieNode[] children;

    public TrieNode() {
        count = 0;
    }

    /**
     * Returns the frequency count for the word represented by the node.
     *
     * @return the frequency count for the word represented by the node.
     */
    @Override
    public int getValue() {
        return count;
    }

    /**
     * Increments the frequency count for the word represented by the node.
     */
    @Override
    public void incrementValue() {
        count++;
    }

    /**
     * Returns the child nodes of this node.
     *
     * @return the child nodes.
     */
    @Override
    public TrieNode[] getChildren() {
        if (children == null) {
            children = new TrieNode[26];
        }
        return children;
    }

    /**
     * Returns the child node of this node for the given char, or null if it doesn't exist.
     *
     * @return the child node.
     */
    public TrieNode getChild(char c) {
        if (hasChild(c)) {
            int index = c - 'a';
            return children[index];
        } else {
            return null;
        }
    }

    public boolean hasChild(char c) {
        int index = c - 'a';
        return children != null && children[index] != null;
    }


    /**
     * Creates the child node of this node for the given char if it doesn't already exist.
     *
     * @param c the char specifying which child to add.
     */
    public void addChild(char c) {
        int index = c - 'a';
        if (children == null) {
            children = new TrieNode[26];
        }
        if (children[index] == null) {
            children[index] = new TrieNode();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other.getClass() != TrieNode.class) return false;

        TrieNode otherNode = (TrieNode) other;
        if (count != otherNode.count) return false;

        for (char c = 'a'; c <= 'z'; c++) {
            if (hasChild(c) != otherNode.hasChild(c)) return false;
            if (hasChild(c) && !otherNode.getChild(c).equals(getChild(c))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer wordList = new StringBuffer();
        appendToWordlist(wordList, "");
        return wordList.toString();
    }

    public void appendToWordlist(StringBuffer wordList, String currentWord) {
        if (count > 0) {
            wordList.append(currentWord + "\n");
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (hasChild(c)) {
                String nextWord = currentWord + (Character) c;
                getChild(c).appendToWordlist(wordList, nextWord);
            }
        }
    }
}
