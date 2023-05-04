package Recommendations.recommendations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RecommendationEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    RecommendationService recommendationService;
    String url = "/recommendations";

    @Test
    void get() {
        String userUuid = "testUuid";
        String oneUserUrl = url + "/" + userUuid;
        restTemplate.getForObject(oneUserUrl, Movie[].class);
        verify(recommendationService).getRecommendations(userUuid);
    }
}