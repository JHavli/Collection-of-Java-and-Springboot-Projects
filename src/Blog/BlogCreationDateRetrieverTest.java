package Blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

class BlogCreationDateRetrieverTest {

    BlogCreationDateRetriever retriever = new BlogCreationDateRetriever();

    @Test
    void retrieveReturnsEmptyOptional() {
        Website website = new Website("www.website.at", "content", Optional.empty());
        Optional<Date> oDate = retriever.retrieve(website);
        Assertions.assertTrue(oDate.isEmpty());
    }

    @Test
    void retrieveReturnsOptionalWithDate() {
        Date date = new Date(1, 4, 2023);
        Blog blog = new Blog("title", List.of(), date);
        Website website = new Website("www.website.at", "content", Optional.of(blog));
        Optional<Date> oDate = retriever.retrieve(website);
        Assertions.assertTrue(oDate.isPresent());
        Assertions.assertEquals(date, oDate.get());
    }
}