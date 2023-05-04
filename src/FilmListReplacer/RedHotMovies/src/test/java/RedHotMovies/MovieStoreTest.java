package RedHotMovies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;


@SpringBootTest(webEnvironment = NONE)
class MovieStoreTest {
    @Autowired
    MovieStore movieStore;
    @Test
    void getMovies() {
        List<Movie> result = movieStore.getMovies();
        assertEquals(1, result.size());
        Movie expected = new Movie("the test", "test movie");
        assertEquals(expected, result.get(0));
    }
}