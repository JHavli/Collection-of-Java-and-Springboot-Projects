package TailoredRecommendations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TailoredRecommendationsStoreTest {
    @Autowired
    TailoredRecommendationsStore tailoredRecommendationsStore;
    static Stream<Arguments> getTailoredRecommendationsByUserUuidParameters() {
        return Stream.of(
                of(List.of(), "unknownUUID"),
                of(List.of(new Movie("the test", "test movie")), "knownUUID")
        );
    }
    @DirtiesContext
    @Test
    void add() {
        List<TailoredRecommendation> tailoredRecommendations =
                tailoredRecommendationsStore.getTailoredRecommendations();
        assertEquals(1, tailoredRecommendations.size());
        tailoredRecommendations.add(new TailoredRecommendation());
        tailoredRecommendations = tailoredRecommendationsStore.getTailoredRecommendations();
        assertEquals(2, tailoredRecommendations.size());
    }
    @ParameterizedTest
    @MethodSource("getTailoredRecommendationsByUserUuidParameters")
    void getTailoredRecommendationsByUserUuid(List<Movie> expected, String uuid) {
        List<Movie> result =
                tailoredRecommendationsStore.getTailoredRecommendationsByUserUuid(uuid);
        assertEquals(expected, result);
    }
}

