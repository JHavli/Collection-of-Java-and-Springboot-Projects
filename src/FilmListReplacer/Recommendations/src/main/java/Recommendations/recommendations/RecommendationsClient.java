package Recommendations.recommendations;

import java.util.List;

public interface RecommendationsClient {
    List<Movie> getRecommendations(String userUuid);
}
