package spell.editdistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class EditDistanceSetGeneratorTest {

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