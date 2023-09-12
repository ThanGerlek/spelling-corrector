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
    void testCountsWithNoWords() {
        assertCountValues(1, 0);
    }

    @Test
    void addEmptyStringToEmpty() {
        trie.add("");
        assertCountValues(1, 0);
    }

    @Test
    void addEmptyStringWithBranches() {
        trie.add("hi");
        trie.add("");
        assertCountValues(3, 1);
    }

    @Test
    void addOneShortWord() {
        trie.add("a");
        assertCountValues(2, 1);
    }

    @Test
    void addTwoSeparateShortWords() {
        trie.add("a");
        trie.add("i");
        assertCountValues(3, 2);
    }

    @Test
    void addOneTwoLetterWord() {
        trie.add("an");
        assertCountValues(3, 1);
    }

    @Test
    void addShortWordThenChildWord() {
        trie.add("a");
        trie.add("an");
        assertCountValues(3, 2);
    }

    @Test
    void addShortWordThenParentWord() {
        trie.add("an");
        trie.add("a");
        assertCountValues(3, 2);
    }

    @Test
    void addShortWordTwice() {
        trie.add("a");
        trie.add("a");
        assertCountValues(2, 1);
    }

    @Test
    void addTwoWordsSharedPrefix() {
        trie.add("help");
        trie.add("hello");
        assertCountValues(7, 2);
    }

    @Test
    void addTwoWordsNoSharedPrefix() {
        trie.add("help");
        trie.add("john");
        assertCountValues(9, 2);
    }

    @Test
    void addThreeWordsDoubleSharedPrefixes() {
        trie.add("abc");
        trie.add("abd");
        trie.add("abde");
        assertCountValues(6, 3);
    }

    @Test
    void addWordTwice() {
        trie.add("moe");
        trie.add("moe");
        assertCountValues(4, 1);
    }

    @Test
    void addWordTwicePastBranch() {
        trie.add("moe");
        trie.add("mop");
        trie.add("mop");
        assertCountValues(5, 2);
    }

    @Test
    void addWordTwiceBeforeBranch() {
        trie.add("moe");
        trie.add("mo");
        trie.add("mo");
        assertCountValues(4, 2);
    }

    @Test
    void addWordTwiceAtBranchPoint() {
        trie.add("pops");
        trie.add("popped");
        trie.add("pop");
        trie.add("pop");
        assertCountValues(8, 3);
    }

    @Test
    void addWordTwiceAtBranchPointBeforeAndAfter() {
        trie.add("pop");
        trie.add("pops");
        trie.add("popped");
        trie.add("pop");
        assertCountValues(8, 3);
    }

    @Test
    void findEmptyStringFromEmpty() {
        TrieNode node = trie.find("");
        Assertions.assertNull(node);
    }

    @Test
    void findEmptyStringWithBranches() {
        trie.add("hi");
        TrieNode node = trie.find("");
        Assertions.assertNull(node);
    }

    @Test
    void findWordFromEmpty() {
        TrieNode node = trie.find("hello");
        Assertions.assertNull(node);
    }

    @Test
    void findShortWordFromEmpty() {
        TrieNode node = trie.find("a");
        Assertions.assertNull(node);
    }

    @Test
    void findNonexistentShortWordWithUnrelatedBranches() {
        trie.add("hello");
        trie.add("help");
        TrieNode node = trie.find("a");
        Assertions.assertNull(node);
    }

    @Test
    void findNonexistentLongWordWithUnrelatedBranches() {
        trie.add("hello");
        trie.add("help");
        TrieNode node = trie.find("applejuice");
        Assertions.assertNull(node);
    }

    @Test
    void findZeroCountShortWord() {
        trie.add("atom");
        TrieNode node = trie.find("a");
        Assertions.assertNull(node);
    }

    @Test
    void findZeroCountWord() {
        trie.add("atom");
        TrieNode node = trie.find("at");
        Assertions.assertNull(node);
    }

    @Test
    void findNonexistentWordAtBranchPoint() {
        trie.add("pops");
        trie.add("popped");
        TrieNode node = trie.find("pop");
        Assertions.assertNull(node);
    }

    @Test
    void findShortWord() {
        trie.add("a");
        TrieNode node = trie.find("a");
        Assertions.assertNotNull(node);
    }

    @Test
    void findWordNoBranches() {
        trie.add("hello");
        TrieNode node = trie.find("hello");
        Assertions.assertNotNull(node);
    }

    @Test
    void findWordWithChild() {
        trie.add("to");
        trie.add("top");
        TrieNode node = trie.find("to");
        Assertions.assertNotNull(node);
    }

    @Test
    void findWordWithChildren() {
        trie.add("to");
        trie.add("top");
        trie.add("tot");
        TrieNode node = trie.find("to");
        Assertions.assertNotNull(node);
    }

    @Test
    void findWordAfterBranching() {
        trie.add("hello");
        trie.add("helps");
        TrieNode node = trie.find("helps");
        Assertions.assertNotNull(node);
    }

    @Test
    void findWordAtBranchPoint() {
        trie.add("popsicle");
        trie.add("popped");
        trie.add("pop");
        TrieNode node = trie.find("pop");
        Assertions.assertNotNull(node);
    }

    @Test
    void findWordBeforeBranching() {
        trie.add("popping");
        trie.add("popped");
        trie.add("pop");
        TrieNode node = trie.find("pop");
        Assertions.assertNotNull(node);
    }

    @Test
    void hashEmptyTrie() {
        Trie trie = new Trie();
        Assertions.assertEquals(0, trie.hashCode());
    }

    @Test
    void hashTrieWithData1() {
        Trie trie = new Trie();
        trie.add("bye");
        trie.add("hello");
        trie.add("frogs");
        trie.add("french");
        // 2nd index, 18 nodes, 4 words
        Assertions.assertEquals(2 * 18 * 4, trie.hashCode());
    }

    @Test
    void hashTrieWithData2() {
        Trie trie = new Trie();
        trie.add("orange");
        trie.add("jamba");
        trie.add("juice");
        // 10th index, 16 nodes, 3 words
        Assertions.assertEquals(10 * 16 * 3, trie.hashCode());
    }

    @Test
    void equalsEmptyTrie() {
        Trie trie1 = new Trie();
        Trie trie2 = new Trie();
        Assertions.assertEquals(trie1, trie2);
        Assertions.assertEquals(trie2, trie1);
    }

    @Test
    void equalsWithUnrelatedWords() {
        Trie trie1 = new Trie();
        trie1.add("bye");
        trie1.add("hello");
        trie1.add("frogs");

        Trie trie2 = new Trie();
        trie2.add("frogs");
        trie2.add("hello");
        trie2.add("bye");

        Assertions.assertEquals(trie1, trie2);
        Assertions.assertEquals(trie2, trie1);
    }

    @Test
    void equalsWithBranching() {
        Trie trie1 = new Trie();
        trie1.add("frogs");
        trie1.add("frog");
        trie1.add("french");
        trie1.add("frederick");

        Trie trie2 = new Trie();
        trie2.add("french");
        trie2.add("frederick");
        trie2.add("frog");
        trie2.add("frogs");

        Assertions.assertEquals(trie1, trie2);
        Assertions.assertEquals(trie2, trie1);
    }

    @Test
    void notEqualsWithUnrelatedWords() {
        Trie trie1 = new Trie();
        trie1.add("bye");
        trie1.add("hello");
        trie1.add("frogs");

        Trie trie2 = new Trie();
        trie2.add("frogs");
        trie2.add("hello");
        trie2.add("fred");

        Assertions.assertNotEquals(trie1, trie2);
        Assertions.assertNotEquals(trie2, trie1);
    }

    @Test
    void notEqualsWithMissingWord() {
        Trie trie1 = new Trie();
        trie1.add("bye");
        trie1.add("hello");
        trie1.add("frogs");

        Trie trie2 = new Trie();
        trie2.add("hello");
        trie2.add("frogs");

        Assertions.assertNotEquals(trie1, trie2);
        Assertions.assertNotEquals(trie2, trie1);
    }

    @Test
    void notEqualsWithBranching() {
        Trie trie1 = new Trie();
        trie1.add("frogs");
        trie1.add("frog");
        trie1.add("french");
        trie1.add("frederick");

        Trie trie2 = new Trie();
        trie2.add("france");
        trie2.add("frederick");
        trie2.add("frog");
        trie2.add("frogs");

        Assertions.assertNotEquals(trie1, trie2);
        Assertions.assertNotEquals(trie2, trie1);
    }

    @Test
    void notEqualsWithDifferentFrequency() {
        Trie trie1 = new Trie();
        trie1.add("frogs");

        Trie trie2 = new Trie();
        trie2.add("frogs");
        trie2.add("frogs");

        Assertions.assertNotEquals(trie1, trie2);
        Assertions.assertNotEquals(trie2, trie1);
    }

    @Test
    void notEqualsWithEmptyTrie() {
        Trie trie1 = new Trie();
        Trie trie2 = new Trie();
        trie2.add("frogs");

        Assertions.assertNotEquals(trie1, trie2);
        Assertions.assertNotEquals(trie2, trie1);
    }

    @Test
    void toStringEmptyTrie() {
        Trie trie = new Trie();
        Assertions.assertEquals("", trie.toString());
    }

    @Test
    void toStringOneWord() {
        Trie trie = new Trie();
        trie.add("hey");
        Assertions.assertEquals("hey\n", trie.toString());
    }

    @Test
    void toStringSeveralWords() {
        Trie trie = new Trie();
        trie.add("hey");
        trie.add("yo");
        trie.add("im");
        trie.add("joe");
        Assertions.assertEquals("hey\nim\njoe\nyo\n", trie.toString());
    }

    @Test
    void toStringDifferentFrequencies() {
        Trie trie = new Trie();
        trie.add("hey");
        trie.add("yo");
        trie.add("hey");
        trie.add("hey");
        trie.add("im");
        trie.add("joe");
        trie.add("yo");
        Assertions.assertEquals("hey\nim\njoe\nyo\n", trie.toString());
    }

    @Test
    void toStringWithBranching() {
        Trie trie = new Trie();
        trie.add("frogs");
        trie.add("frog");
        trie.add("french");
        trie.add("frederick");
        Assertions.assertEquals("frederick\nfrench\nfrog\nfrogs\n", trie.toString());
    }
}