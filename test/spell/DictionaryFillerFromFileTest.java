package spell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

class DictionaryFillerFromFileTest {

    HashMapDictionary dict;

    @BeforeEach
    void setUp() {
        dict = new HashMapDictionary();
    }

    @Test
    void nonexistentFile() {
        Assertions.assertThrows(IOException.class,
                () -> DictionaryFillerFromFile.fill("./test/resources/nonexistent-file.txt", dict));
    }

    @Test
    void emptyFile() throws IOException {
        HashMap<String, Integer> expected = new HashMap<>();

        DictionaryFillerFromFile.fill("./test/resources/empty-file.txt", dict);
        Assertions.assertTrue(dict.equalsHashMap(expected));
    }

    @Test
    void oneWord() throws IOException {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hey", 1);

        DictionaryFillerFromFile.fill("./test/resources/one-word.txt", dict);
        Assertions.assertTrue(dict.equalsHashMap(expected));
    }

    @Test
    void severalWordsOneLine() throws IOException {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hey", 1);
        expected.put("yo", 1);
        expected.put("im", 1);
        expected.put("joe", 1);

        DictionaryFillerFromFile.fill("./test/resources/one-line.txt", dict);
        Assertions.assertTrue(dict.equalsHashMap(expected));
    }

    @Test
    void severalLines() throws IOException {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hey", 1);
        expected.put("yo", 1);
        expected.put("my", 1);
        expected.put("name", 1);
        expected.put("is", 1);
        expected.put("joe", 1);

        DictionaryFillerFromFile.fill("./test/resources/several-lines.txt", dict);
        Assertions.assertTrue(dict.equalsHashMap(expected));
    }

    @Test
    void repeatedWords() throws IOException {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hey", 4);
        expected.put("yo", 3);
        expected.put("my", 1);
        expected.put("name", 1);
        expected.put("is", 1);
        expected.put("joe", 2);

        DictionaryFillerFromFile.fill("./test/resources/repeated-words.txt", dict);
        Assertions.assertTrue(dict.equalsHashMap(expected));
    }

    @Test
    void lotsOfWhitespace() throws IOException {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hey", 1);
        expected.put("yo", 1);
        expected.put("my", 1);
        expected.put("name", 1);
        expected.put("is", 1);
        expected.put("joe", 1);

        DictionaryFillerFromFile.fill("./test/resources/whitespace.txt", dict);
        Assertions.assertTrue(dict.equalsHashMap(expected));
    }
}