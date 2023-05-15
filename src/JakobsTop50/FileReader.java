package JakobsTop50;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public List<String> read(String file) {
        Path path = Path.of(file);
        try{
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}

