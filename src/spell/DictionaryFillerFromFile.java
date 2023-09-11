package spell;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class DictionaryFillerFromFile {

    public static void fill(String filename, Dictionary dict) throws IOException {
        Path filepath = Path.of(filename);
        try (Scanner scanner = new Scanner(filepath)) {
            while (scanner.hasNext()) {
                dict.add(scanner.next());
            }
        }
    }
}
