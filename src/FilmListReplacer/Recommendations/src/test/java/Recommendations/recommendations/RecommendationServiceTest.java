package Recommendations.recommendations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
@SpringBootTest(webEnvironment = NONE)
class RecommendationServiceTest {
    @Autowired
    RecommendationService recommendationService;
    @MockBean
    TailoredRecommendationsClient tailoredRecommendationsClient;
    @MockBean
    HotRightNowClient hotRightNowClient;
    @Test
    void getRecommendationsFindsNothig() {
        String userUuid = "testUuid";
        List<Movie> expected = List.of();
        when(tailoredRecommendationsClient.getRecommendations(userUuid))
                .thenReturn(expected);
        when(hotRightNowClient.getRecommendations(userUuid))
                .thenReturn(expected);
        List<Movie> result = recommendationService.getRecommendations(userUuid);
        assertEquals(expected, result);
        verify(tailoredRecommendationsClient).getRecommendations(userUuid);
        verify(hotRightNowClient).getRecommendations(userUuid);
    }
    @Test
    void getRecommendationsFindsHotRightNow() {
        String userUuid = "testUuid";
        when(tailoredRecommendationsClient.getRecommendations(anyString()))
                .thenReturn(new ArrayList<>());
        List<Movie> expected = List.of(new Movie("test", "test"));
        when(hotRightNowClient.getRecommendations(anyString()))
                .thenReturn(expected);
        List<Movie> result = recommendationService.getRecommendations(userUuid);
        assertEquals(expected, result);
        verify(tailoredRecommendationsClient).getRecommendations(userUuid);
        verify(hotRightNowClient).getRecommendations(userUuid);
    }
    @Test
    void getRecommendationsFindsTailoredRecommendations() {
        String userUuid = "testUuid";
        List<Movie> expected = List.of(new Movie("test", "test"));
        when(tailoredRecommendationsClient.getRecommendations(anyString()))
                .thenReturn(expected);
        List<Movie> result = recommendationService.getRecommendations(userUuid);
        assertEquals(expected, result);
        verify(tailoredRecommendationsClient).getRecommendations(userUuid);
        verify(hotRightNowClient, never()).getRecommendations(userUuid);
    }
}
