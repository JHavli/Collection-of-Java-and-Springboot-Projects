package JakobsTop50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class StringParserTest {
    private StringParser stringParser = new StringParser();

    @Test
    void parseString() {
        String string = "Martyrs;Horror;2008;8.8";
        Optional<Movie> result = stringParser.parseString(string);
        Optional<Movie> expected = Optional.of(new Movie("Martyrs", "Horror",2008, 8.8));
        Assertions.assertEquals(expected, result);
    }


    @Test
    void parseEmptyString() {
        String emptyString = "";
        Optional<Movie> result = stringParser.parseString(emptyString);
        Optional<Movie> expected = Optional.empty();
        Assertions.assertEquals(expected, result);
    }
}