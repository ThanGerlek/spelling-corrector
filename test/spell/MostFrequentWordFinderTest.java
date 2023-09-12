package spell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class MostFrequentWordFinderTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void emptyEditSet() {
        Dictionary dict = new HashMapDictionary();
        dict.add("baaa");
        dict.add("zaaa");
        Set<String> editSet = new HashSet<>();

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);

        Assertions.assertFalse(finder.foundWord());
    }

    @Test
    void emptyDictionary() {
        Dictionary dict = new HashMapDictionary();
        Set<String> editSet = new HashSet<>();
        editSet.add("baaa");
        editSet.add("zaaa");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);

        Assertions.assertFalse(finder.foundWord());
    }

    @Test
    void noRealWords() {
        Dictionary dict = new HashMapDictionary();
        dict.add("hi");
        dict.add("bye");
        dict.add("bye");

        Set<String> editSet = new HashSet<>();
        editSet.add("baaa");
        editSet.add("zaaa");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);

        Assertions.assertFalse(finder.foundWord());
    }

    @Test
    void compareTwoAlphabetical() {
        Dictionary dict = new HashMapDictionary();
        dict.add("ba");
        dict.add("ca");

        Set<String> editSet = new HashSet<>();
        editSet.add("ba");
        editSet.add("ca");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);
        Assertions.assertTrue(finder.foundWord());
        Assertions.assertEquals("ba", finder.getWord());
    }

    @Test
    void compareThreeAlphabetical() {
        Dictionary dict = new HashMapDictionary();
        dict.add("ca");
        dict.add("ba");
        dict.add("aa");

        Set<String> editSet = new HashSet<>();
        editSet.add("ca");
        editSet.add("ba");
        editSet.add("aa");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);
        Assertions.assertTrue(finder.foundWord());
        Assertions.assertEquals("aa", finder.getWord());
    }

    @Test
    void compareFrequencyAndAlphabetical() {
        Dictionary dict = new HashMapDictionary();
        dict.add("aaaa");
        dict.add("caaa");
        dict.add("caaa");
        dict.add("baaa");
        dict.add("baaa");

        Set<String> editSet = new HashSet<>();
        editSet.add("aaaa");
        editSet.add("baaa");
        editSet.add("caaa");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);
        Assertions.assertTrue(finder.foundWord());
        Assertions.assertEquals("baaa", finder.getWord());
    }

    @Test
    void prioritizeFrequencyOverAlphabetical() {
        Dictionary dict = new HashMapDictionary();
        dict.add("aaaa");
        dict.add("zaaa");
        dict.add("zaaa");

        Set<String> editSet = new HashSet<>();
        editSet.add("aaaa");
        editSet.add("zaaa");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);
        Assertions.assertTrue(finder.foundWord());
        Assertions.assertEquals("zaaa", finder.getWord());
    }

    @Test
    void compareAlphabeticalDifferentLengths() {
        Dictionary dict = new HashMapDictionary();
        dict.add("ba");
        dict.add("baaa");

        Set<String> editSet = new HashSet<>();
        editSet.add("ba");
        editSet.add("baaa");

        MostFrequentWordFinder finder = new MostFrequentWordFinder(dict);
        finder.findInSet(editSet);
        Assertions.assertTrue(finder.foundWord());
        Assertions.assertEquals("ba", finder.getWord());
    }
}