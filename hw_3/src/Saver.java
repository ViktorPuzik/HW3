import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Saver {
    public static void save(String fileName, String text) throws IOException {
        File file = new File(fileName);
        Files.writeString(Path.of(fileName),text + System.lineSeparator(), StandardOpenOption.CREATE);
    }
}
