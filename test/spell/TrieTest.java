package spell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieTest {

    private Trie trie;

    void assertCountValues(int expectedNodeCount, int expectedWordCount) {
        Assertions.assertEquals(expectedNodeCount, trie.getNodeCount());
        Assertions.assertEquals(expectedWordCount, trie.getWordCount());
    }

    @BeforeEach
    void setUp() {
        trie = new Trie();
    }

    @Test
    void testAdd() {
    }

    @Test
    void testFind() {
    }

    @Test
    void testHashcode() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testToString() {
    }
}