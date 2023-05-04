package TailoredRecommendations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TailoredRecommendationsEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    TailoredRecommendationsStore tailoredRecommendationsStore;
    String url = "/tailoredrecommendations";
    @Test
    void get() {
        String uuid = "test";
        String oneUserUrl = url + "/" + uuid;
        restTemplate.getForObject(oneUserUrl, Movie[].class);
        verify(tailoredRecommendationsStore).getTailoredRecommendationsByUserUuid(uuid);
    }
    @Test
    void post() {
        TailoredRecommendation tailoredRecommendation = new TailoredRecommendation("test", new
                Movie("test", "test"));
        restTemplate.postForObject(url, tailoredRecommendation, TailoredRecommendation.class);
        verify(tailoredRecommendationsStore).add(tailoredRecommendation);
    }
}
