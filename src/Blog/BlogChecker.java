package Blog;

public class BlogChecker {
    public boolean hasBlog(Website website) {
        return website.getBlog().isPresent();
    }
}
