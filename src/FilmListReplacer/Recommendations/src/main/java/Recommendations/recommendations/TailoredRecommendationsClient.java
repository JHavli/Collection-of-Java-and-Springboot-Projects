package Recommendations.recommendations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Order(1)
public class TailoredRecommendationsClient implements RecommendationsClient {
    private final RestTemplate restTemplate;
    private final String url;
    public TailoredRecommendationsClient(RestTemplate restTemplate,
                                         @Value("${recommendations.urls.tailored-recommendations}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }
    public List<Movie> getRecommendations(String userUuid) {
        String oneUserUrl = url + "/" + userUuid;
        Movie[] movies = restTemplate.getForObject(oneUserUrl, Movie[].class);
        return Stream.of(movies)
                .collect(Collectors.toList());
    }
}
