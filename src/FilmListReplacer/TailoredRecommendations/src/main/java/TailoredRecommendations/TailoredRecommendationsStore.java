package TailoredRecommendations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("tailored-recommendations-store")
public class TailoredRecommendationsStore {
    private List<TailoredRecommendation> tailoredRecommendations;
    public void add(TailoredRecommendation tailoredRecommendation) {
        tailoredRecommendations.add(tailoredRecommendation);
    }
    public List<Movie> getTailoredRecommendationsByUserUuid(String userUuid) {
        return tailoredRecommendations.stream()
                .filter(tailoredRecommendation ->
                        tailoredRecommendation.getUserUuid().equals(userUuid))
                .map(TailoredRecommendation::getMovie)
                .collect(Collectors.toList());
    }
    List<TailoredRecommendation> getTailoredRecommendations() {
        return tailoredRecommendations;
    }
    void setTailoredRecommendations(List<TailoredRecommendation> tailoredRecommendations) {
        this.tailoredRecommendations = tailoredRecommendations;
    }
}
