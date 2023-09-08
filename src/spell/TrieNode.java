package spell;

public class TrieNode implements INode {
    /**
     * Returns the frequency count for the word represented by the node.
     *
     * @return the frequency count for the word represented by the node.
     */
    @Override
    public int getValue() {
        return 0;
    }

    /**
     * Increments the frequency count for the word represented by the node.
     */
    @Override
    public void incrementValue() {

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
