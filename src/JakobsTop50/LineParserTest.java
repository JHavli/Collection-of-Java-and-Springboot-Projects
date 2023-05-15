package JakobsTop50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineParserTest {
    private LineParser lineParser = new LineParser();
    String filePath = "src/JakobsTop50/Files/FavoriteMoviesJakobTest.CSV";


    @Test
    void parseLines() {
        Movie result = lineParser.parseLines(filePath).get(0);
        Movie expected = new Movie("Martyrs", "Horror", 2008, 8.8);
        Assertions.assertEquals(expected, result);
    }
}

