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
    void testGenerate() throws IOException {
        String rootWord = "hey";
        Set<String> expected = editSetForHey();

        EditDistanceSetGenerator generator = new EditDistanceSetGenerator();
        Set<String> actual = generator.generate(rootWord);

        Assertions.assertEquals(expected, actual);
    }

    Set<String> editSetForHey() throws IOException {
        Set<String> set = new HashSet<>();
        Path path = Path.of("./test/resources/hey-edit-set.txt");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                set.add(scanner.next());
            }
            return set;
        } catch (IOException e) {
            Assertions.fail("Failed to open hey-edit-set.txt");
            throw e;
        }
    }
}