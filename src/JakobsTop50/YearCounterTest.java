package JakobsTop50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class YearCounterTest {
    private YearCounter counter = new YearCounter();

    @ParameterizedTest
    @MethodSource("parameters")
    void test(List<Movie> inputOne,int inputTwo, int inputThree,int expected) {
        int result = counter.countYears(inputOne,inputTwo,inputThree);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        List.of(new Movie("MovieOne", "Horror", 1969, 1),
                        new Movie("MovieOne", "Horror", 1963, 2),
                        new Movie("MovieTwo", "Horror", 1960, 2),
                        new Movie("MovieThree", "Horror", 1959, 2),
                        new Movie("MovieFour", "Horror", 1980, 2)
                        ), 1960, 1969, 3),
                Arguments.of(
                        List.of(new Movie("MovieOne", "Horror", 1969, 1),
                                new Movie("MovieOne", "Horror", 1963, 2),
                                new Movie("MovieTwo", "Horror", 1960, 2),
                                new Movie("MovieThree", "Horror", 1959, 2),
                                new Movie("MovieFour", "Horror", 1980, 2)
                        ), 1990, 1999, 0)
        );
    }
}

