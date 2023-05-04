package Chitter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ChitterServiceTest {
    @Autowired
    ChitterService chitterService;
    @MockBean
    ChitterRepository chitterRepository;
    @Test
    void findAll() {
        chitterService.findAll();
        verify(chitterRepository).findByOrderByTimestampDesc();
    }
    @Test
    void findBy() {
        String user = "user";
        chitterService.findBy(user);
        verify(chitterRepository).findByUserOrderByTimestampDesc(user);
    }
    @Test
    void save() {
        Chitter chitter = new Chitter("user", "text");
        assertNull(chitter.getComments());
        assertNull(chitter.getTimestamp());
        chitterService.save(chitter);
        assertNotNull(chitter.getComments());
        assertTrue(chitter.getComments().isEmpty());
        assertNotNull(chitter.getTimestamp());
        verify(chitterRepository).save(chitter);
    }
    @Test
    void likeDoesNotFindTweet() {
        String id = "id";
        when(chitterRepository.findById(id))
                .thenReturn(Optional.empty());
        chitterService.like(id);
        verify(chitterRepository).findById(id);
        verify(chitterRepository, never()).save(any(Chitter.class));
    }
    @Test
    void likeFindsTweet() {
        String id = "id";
        Chitter chitter = new Chitter("user", "test");
        assertEquals(0, chitter.getLikes());
        when(chitterRepository.findById(id))
                .thenReturn(Optional.of(chitter));
        chitterService.like(id);
        assertEquals(1, chitter.getLikes());
        verify(chitterRepository).findById(id);
        verify(chitterRepository).save(chitter);
    }
    @Test
    void commentDoesNotFindTweet() {
        String id = "id";
        String comment = "comment";
        when(chitterRepository.findById(id))
                .thenReturn(Optional.empty());
        chitterService.comment(id, comment);
        verify(chitterRepository).findById(id);
        verify(chitterRepository, never()).save(any(Chitter.class));
    }
    @Test
    void commentFindsTweet() {
        String id = "id";
        String comment = "comment";
        Chitter tweet = new Chitter("user", "test", new ArrayList<>());
        assertNotNull(tweet.getComments());
        assertTrue(tweet.getComments().isEmpty());
        when(chitterRepository.findById(id))
                .thenReturn(Optional.of(tweet));
        chitterService.comment(id, comment);
        assertEquals(1, tweet.getComments().size());
        assertEquals(comment, tweet.getComments().get(0));
        verify(chitterRepository).findById(id);
        verify(chitterRepository).save(tweet);
    }
}

