package TailoredRecommendations;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tailoredrecommendations")
public class TailoredRecommendationsEndpoint {
    private final TailoredRecommendationsStore tailoredRecommendationsStore;
    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore
                                                   tailoredRecommendationsStore) {
        this.tailoredRecommendationsStore = tailoredRecommendationsStore;
    }
    @GetMapping("/{userUuid}")
    List<Movie> get(@PathVariable String userUuid) {
        return tailoredRecommendationsStore.getTailoredRecommendationsByUserUuid(userUuid);
    }
    @PostMapping
    TailoredRecommendation post(@RequestBody TailoredRecommendation tailoredRecommendation) {
        tailoredRecommendationsStore.add(tailoredRecommendation);
        return tailoredRecommendation;
    }
}
