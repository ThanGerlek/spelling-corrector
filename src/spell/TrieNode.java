package spell;

public class TrieNode implements INode {

    private int count;
    private TrieNode[] children;

    public TrieNode() {
        count = 0;
    }

    public TrieNode(int count) {
        this.count = count;
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
    public INode[] getChildren() {
        return new INode[0];
    }
}
