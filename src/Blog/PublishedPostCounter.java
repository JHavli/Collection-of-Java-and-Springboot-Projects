package Blog;

import java.util.List;

public class PublishedPostCounter {
    public int count(Blog blog) {
        int count = 0;
        List<Post> posts = blog.getPosts();
        for (Post post : posts) {
            if (post.isPublished()) {
                count++;
            }
        }
        return count;
    }
}