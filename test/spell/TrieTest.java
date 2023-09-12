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
    void testHashcode() {
        //TODO hashcode() tests
    }

    @Test
    void testEquals() {
        //TODO equals() tests
    }

    @Test
    void testToString() {
        //TODO toString() tests
    }
}