package spell.editdistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class EditDistanceSetGeneratorTest {

    static EditDistanceSetGenerator getTestGenerator() {
        Set<Character> testCharSet = getTestCharSet();

        EditDistanceSetGenerator setGenerator =
                new EditDistanceSetGenerator() {
                    @Override
                    ArrayList<EditGenerator> getGenerators() {
                        ArrayList<EditGenerator> generators = super.getGenerators();
                        setEditGeneratorsToUseCharSet(generators, testCharSet);
                        return generators;
                    }
                };

        return setGenerator;
    }

    static void setEditGeneratorsToUseCharSet(
            ArrayList<EditGenerator> generators, Set<Character> charSet) {
        for (EditGenerator generator : generators) {
            generator.useCharSet(charSet);
        }
    }

    static Set<Character> getTestCharSet() {
        Set<Character> testCharSet = new HashSet<>();
        testCharSet.add('a');
        testCharSet.add('b');
        return testCharSet;
    }

    @Test
    void testGenerateForHey() throws IOException {
        String rootWord = "hey";
        String filePathStr = "./test/resources/hey-edit-set.txt";
        Set<String> expected = getEditSetFromFile(filePathStr);

        EditDistanceSetGenerator generator = getTestGenerator();
        Set<String> actual = generator.generate(rootWord);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGenerateForSingleChar() throws IOException {
        String rootWord = "a";
        String filePathStr = "./test/resources/single-char-edit-set.txt";
        Set<String> expected = getEditSetFromFile(filePathStr);

        EditDistanceSetGenerator generator = getTestGenerator();
        Set<String> actual = generator.generate(rootWord);

        Assertions.assertEquals(expected, actual);
    }

    Set<String> getEditSetFromFile(String filePathStr) throws IOException {
        Set<String> set = new HashSet<>();
        Path path = Path.of(filePathStr);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                set.add(scanner.next());
            }
            return set;
        } catch (IOException e) {
            Assertions.fail("Failed to open edit set file: " + filePathStr);
            throw e;
        }
    }
}