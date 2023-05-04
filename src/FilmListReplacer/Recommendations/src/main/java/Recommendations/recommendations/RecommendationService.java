package Recommendations.recommendations;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {
    private final List<RecommendationsClient> recommendationsClients;
    public RecommendationService(List<RecommendationsClient> recommendationsClients) {
        this.recommendationsClients = recommendationsClients;
    }
    public List<Movie> getRecommendations(String userUuid) {
        return recommendationsClients.stream()
                .map(recommendationsClient -> recommendationsClient.getRecommendations(userUuid))
                .filter(movies -> !movies.isEmpty())
                .findFirst()
                .orElse(new ArrayList<>());
    }
}

