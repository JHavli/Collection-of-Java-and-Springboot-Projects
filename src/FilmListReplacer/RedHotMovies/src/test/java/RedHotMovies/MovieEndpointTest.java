package RedHotMovies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MovieEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    MovieStore movieStore;
    String url = "/movies";
    @Test
    void get() {
        restTemplate.getForObject(url, Movie[].class);
        verify(movieStore).getMovies();
    }
}
