package Blog;

import java.util.Optional;

public class BlogCreationDateRetriever {

    public Optional<Date> retrieve(Website website) {
        Optional<Blog> oBlog = website.getBlog();
        if (oBlog.isEmpty()) {
            return Optional.empty();
        }
        Blog blog = oBlog.get();
        Date dateCreated = blog.getDateCreated();
        return Optional.of(dateCreated);
    }
}
