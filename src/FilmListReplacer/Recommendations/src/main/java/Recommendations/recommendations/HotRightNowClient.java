package Recommendations.recommendations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Order(2)
public class HotRightNowClient implements RecommendationsClient {
    private final RestTemplate restTemplate;
    private final String url;
    public HotRightNowClient(RestTemplate restTemplate,
                             @Value("${recommendations.urls.hot-right-now}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }
    public List<Movie> getRecommendations(String userUuid) {
        Movie[] movies = restTemplate.getForObject(url, Movie[].class);
        return Stream.of(movies)
                .collect(Collectors.toList());
    }
}
