package JakobsTop50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class GenreRatioCalculatorTest {

    private GenreRatioCalculator calculator = new GenreRatioCalculator();
    private LineParser parser = new LineParser();
    List<Movie> movies = parser.parseLines("src/JakobsTop50/Files/FavoriteMoviesJakobTest.CSV");



    @Test
    void calculate() {
        double expected = 75.00;
        double result = calculator.calculate(movies, "horror");
        Assertions.assertEquals(expected, result);
    }
}