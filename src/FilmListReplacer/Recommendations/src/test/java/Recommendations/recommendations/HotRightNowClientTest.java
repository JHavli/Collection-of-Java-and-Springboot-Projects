package Recommendations.recommendations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class HotRightNowClientTest {
    @Autowired
    HotRightNowClient hotRightNowClient;
    @MockBean
    RestTemplate restTemplate;
    @Value("${recommendations.urls.hot-right-now}")
    String url;
    @Test
    void getRecommendations() {
        when(restTemplate.getForObject(url, Movie[].class))
                .thenReturn(new Movie[]{});
        String userUuid = "uuid";
        hotRightNowClient.getRecommendations(userUuid);
        verify(restTemplate).getForObject(url, Movie[].class);
    }
}
