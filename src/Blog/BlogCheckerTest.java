package Blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

class BlogCheckerTest {

    BlogChecker checker = new BlogChecker();

    @Test
    void hasBlogReturnsFalse() {
        Website website = new Website("www.website.at", "website", Optional.empty());
        boolean result = checker.hasBlog(website);
        Assertions.assertFalse(result);
    }

    @Test
    void hasBlogReturnsTrue() {
        Date date = new Date(1, 4, 2023);
        Blog blog = new Blog("title", List.of(), date);
        Website website = new Website("www.website.at", "content", Optional.of(blog));
        boolean result = checker.hasBlog(website);
        Assertions.assertTrue(result);
    }
}
