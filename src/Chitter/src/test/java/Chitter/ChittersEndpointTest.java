package Chitter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TweetsEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @MockBean
    ChitterService chitterService;
    String url = "/chitters";
    @Test
    void getAll() {
        testRestTemplate.getForObject(url, Chitter[].class);
        verify(chitterService).findAll();
    }
    @Test
    void getForUser() {
        String user = "user";
        testRestTemplate.getForObject(url + "/user/" + user, Chitter[].class);
        verify(chitterService).findBy(user);
    }
    @Test
    void post() {
        Chitter chitter = new Chitter("user", "text");
        testRestTemplate.postForObject(url, chitter, Chitter.class);
        verify(chitterService).save(chitter);
    }
    @Test
    void like() {
        String id = "id";
        testRestTemplate.put(url + "/" + id + "/likes", null);
        verify(chitterService).like(id);
    }
    @Test
    void comment() {
        String id = "id";
        String comment = "comment";
        testRestTemplate.put(url + "/" + id + "/comments", comment);
        verify(chitterService).comment(id, comment);
    }
}
